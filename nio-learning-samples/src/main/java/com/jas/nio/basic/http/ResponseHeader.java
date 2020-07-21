package com.jas.nio.basic.http;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/07/21
 */
public class ResponseHeader {

    public Integer code = 200;

    public String phrase = "OK";

    public String contentType = "text/html";

    public Integer contentLength;

    public String server = "zhchen";

    public String version = "HTTP/1.1";

    @Override
    public String toString() {
        return String.format("%s %d %s\r\n", version, code, phrase) +
                String.format("ContentType: %s\r\n", contentType) +
                String.format("ContentLength: %d\r\n", contentLength) +
                String.format("Server: %s\r\n", server) +
                "\r\n";
    }

}
