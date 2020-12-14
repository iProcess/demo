package com.example.demo.test.hexs;

public class TestToHexString {

    public static void main(String[] args) {
        int m = 0;
        for (int i = 0; i <= 9; i++) {
            m=i*10+i;
            byte[] bytes = (m + "").getBytes();
            for (byte aByte : bytes) {
                String s = aByte + "";
                Integer integer = Integer.valueOf(s);
                String s1 = Integer.toHexString(integer);
                System.out.print(s1);

            }
            System.out.println("");
        }
    }

}
