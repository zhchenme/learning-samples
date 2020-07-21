package com.jas.nio.basic.http;

import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.*;

/**
 * 参考自：https://github.com/code4wt/toyhttpd
 *
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/07/21
 */
public class NIOHttpServer {

    private static final Integer PORT = 8080;
    private static final String ADDRESS = "127.0.0.1";
    private static final Integer DEFAULT_BUFFER_SIZE = 10240;
    private static final String CRLF = "\r\n";
    private static final String KEY_VALUE_SEPARATOR = ":";

    private final Integer port;
    private final String address;

    public NIOHttpServer() {
        this(ADDRESS, PORT);
    }

    public NIOHttpServer(String address, Integer port) {
        this.address = address;
        this.port = port;
    }

    public void start() throws Exception {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        ssc.socket().bind(new InetSocketAddress(address, port));
        Selector selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            int readyNums = selector.select();
            if (readyNums <= 0) {
                continue;
            }
            Set<SelectionKey> readySelectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = readySelectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey readySelectionKey = iterator.next();
                if (readySelectionKey.isAcceptable()) {
                    SocketChannel socketChannel = ssc.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (readySelectionKey.isReadable()) {
                    this.request(readySelectionKey);
                    readySelectionKey.interestOps(SelectionKey.OP_WRITE);
                } else if (readySelectionKey.isWritable()) {
                    this.response(readySelectionKey);
                }
                iterator.remove();
            }
        }
    }

    private void request(SelectionKey readySelectionKey) throws Exception {
        SocketChannel sc = (SocketChannel) readySelectionKey.channel();
        ByteBuffer bf = ByteBuffer.allocate(DEFAULT_BUFFER_SIZE);
        int read = sc.read(bf);
        if (read != -1) {
            bf.flip();
            byte[] bytes = new byte[bf.limit()];
            bf.get(bytes);
            bf.clear();
            String requestHeaderStr = new String(bytes);
            RequestHeader requestHeader = this.parseRequestHeader(requestHeaderStr);
            readySelectionKey.attach(requestHeader);
        }
    }

    private RequestHeader parseRequestHeader(String requestHeaderStr) {
        if (null == requestHeaderStr || requestHeaderStr.isEmpty()) {
            throw new IllegalArgumentException();
        }
        int index = requestHeaderStr.indexOf(CRLF);
        if (index == -1) {
            throw new IllegalArgumentException();
        }
        RequestHeader requestHeader = new RequestHeader();
        // HTTP head line: GET /index.html HTTP/1.1
        String httpFirstHeader = requestHeaderStr.substring(0, index);
        String[] parts = httpFirstHeader.split(" ");
        int httpFirstHeaderParts = 3;
        if (parts.length < httpFirstHeaderParts) {
            throw new IllegalArgumentException();
        }
        requestHeader.setMethod(parts[0]);
        requestHeader.setPath(parts[1]);
        requestHeader.setVersion(parts[2]);
        parts = requestHeaderStr.split(CRLF);
        Map<String, String> headerMap = new HashMap<>();
        for (String part : parts) {
            index = part.indexOf(KEY_VALUE_SEPARATOR);
            if (index == -1) {
                continue;
            }
            String key = part.substring(0, index);
            if (index + 1 >= part.length()) {
                headerMap.put(key, "");
                continue;
            }
            String value = part.substring(index + 1);
            headerMap.put(key, value);
        }
        requestHeader.setHeaderMap(headerMap);
        return requestHeader;
    }

    private void response(SelectionKey readySelectionKey) throws Exception {
        SocketChannel sc = (SocketChannel) readySelectionKey.channel();
        RequestHeader requestHeader = (RequestHeader) readySelectionKey.attachment();
        this.dispatchRequest(sc, requestHeader.getPath());
        sc.close();
    }

    private void dispatchRequest(SocketChannel sc, String path) throws Exception {
        ResponseHeader responseHeader = new ResponseHeader();
        ByteBuffer bodyBuffer = getDispatchFile(path);
        responseHeader.contentLength = bodyBuffer.capacity();
        ByteBuffer headerBuffer = ByteBuffer.wrap(responseHeader.toString().getBytes());
        sc.write(new ByteBuffer[]{headerBuffer, bodyBuffer});
        headerBuffer.clear();
        bodyBuffer.clear();
    }

    private ByteBuffer getDispatchFile(String path) throws Exception {
        path = path.replaceAll("/", "");
        if (!"index.html".equals(path)) {
            return ByteBuffer.allocate(DEFAULT_BUFFER_SIZE);
        }
        String absolutePath = Objects.requireNonNull(this.getClass().getClassLoader().getResource(path)).getPath();
        RandomAccessFile raf = new RandomAccessFile(absolutePath, "r");
        FileChannel sc = raf.getChannel();
        ByteBuffer bf = ByteBuffer.allocate((int) sc.size());
        sc.read(bf);
        bf.flip();
        return bf;
    }

    public static void main(String[] args) throws Exception {
        new NIOHttpServer().start();
    }

}
