package com.example.demo.io;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * https://www.jb51.net/article/168805.htm
 */
public class TestMain {

    public static void main(String[] args) throws Exception {
        int bufSize = 1024;
        byte[] bs = new byte[bufSize];
        ByteBuffer byteBuf = ByteBuffer.allocate(1024);
        FileChannel channel = new RandomAccessFile("d:\\filename", "r").getChannel();
        while (channel.read(byteBuf) != -1) {
            int size = byteBuf.position();
            byteBuf.rewind();
            byteBuf.get(bs);
            // 把文件当字符串处理，直接打印做为一个例子。
            System.out.print(new String(bs, 0, size));
            byteBuf.clear();
        }
    }

}
