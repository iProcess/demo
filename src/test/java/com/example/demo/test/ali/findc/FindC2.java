package com.example.demo.test.ali.findc;


public class FindC2 {

    public static void main(String[] args) {
        String s = "aab122coo221!!@baa.com";
        int length = s.chars().max().orElseThrow(RuntimeException::new) + 1;
        int[] hist = new int[length];

        s.chars().forEach(i -> System.out.println(i));

        System.out.println(hist);

        s.chars().forEach(i -> System.out.println(hist[i]));

        s.chars().forEach(i -> System.out.println(hist[i]++));

        s.chars().forEach(i -> hist[i]++);
        for (int i = 0; i < length; i++)
            if (hist[i] > 0)
                System.out.printf("%c=%d  ", i, hist[i]);

    }
}
