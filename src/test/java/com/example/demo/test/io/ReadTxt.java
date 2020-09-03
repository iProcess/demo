package com.example.demo.test.io;


import java.util.List;


/**
 *  * Created with IntelliJ IDEA.
 *  * User: Okey
 *  * Date: 14-3-6
 *  * Time: 上午11:02
 *  * To change this template use File | Settings | File Templates.
 *  https://www.jb51.net/article/168805.htm
 */
public class ReadTxt {
    public static void main(String[] args) throws Exception {
        String filename = "E:/address_city.utf8.txt";
        ReaderListener readerListener = new ReaderListener() {
            @Override
            public void output(List<String> stringList) throws Exception {
                for (String s : stringList) {
                    System.out.println("s = " + s);
                }
            }
        };
        readerListener.setReadColNum(100000);
        NIOFileReader nioFileReader = new NIOFileReader(readerListener, "utf-8");
        nioFileReader.readFileByLine(filename);
    }
}
