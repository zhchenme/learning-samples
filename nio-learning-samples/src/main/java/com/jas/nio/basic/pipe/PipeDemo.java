package com.jas.nio.basic.pipe;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/07/20
 */
public class PipeDemo {

    public static void main(String[] args) throws IOException {

        Pipe pipe = Pipe.open();
        Pipe.SinkChannel sink = pipe.sink();

        ByteBuffer bf = ByteBuffer.allocate(48);
        bf.put("hello world".getBytes());
        bf.flip();

        // 数据写入 sinkChannel
        sink.write(bf);
        bf.clear();

        Pipe.SourceChannel source = pipe.source();
        // 从 sourceChannel 读取数据
        int read = source.read(bf);

        System.out.println(new String(bf.array(), 0, read));

        sink.close();
        source.close();
    }

}
