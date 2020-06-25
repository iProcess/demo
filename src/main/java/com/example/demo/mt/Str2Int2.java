package com.example.demo.mt;

/**
 * ASCII表：http://c.biancheng.net/c/ascii/
 */
public class Str2Int2 {

    //int类型存储长度为32bit.所以范围是“-2^32”到“2^32-1”
    //也就是“-2147483648”到“2147483647”
    public static void main(String[] args) {
//        String str = "2112854432";
        String str = "123";
        int a = 0;
        char base = '0';
        char[] chars = str.toCharArray();
        for (int j = 0; j < chars.length; j++) {
            /**
             * 1、(chars[j] - base)根据ASCII码中的十进制数字相减；
             *
             * 2、因为是减去0，故得到的是字符数组中的字符，且会转换为数字，这样才能和后面的数字相乘，
             * 相乘的目的是将该数字转换为：低位上的数都是0，然后和低位上的数相加，就得到完整的数字；
             *
             * 3、后面要乘什么数字，这与原序列的长度、该字符所处的位置有关，例如：123，长度是3
             * 对于第一个位置上的1来说，1是处于高位，需要将低位转为0。所以先计算出1之后有多少位数：3-0-1=2
             * 所以需要将它后面的两位转为0，1处于百位上，因为是十进制，1+10*10=100，就可以将1进行转换；
             *
             * 4、依次处理后面的数据，前后进行相加，就得到完整的数字。
             *
             */
            a += (chars[j] - base) * getPow(10, chars.length - j - 1);
        }
        System.out.println(a);
    }

    public static int getPow(int m,int n){
        int sum = 1;
        for(int i=0;i<n;i++){
            sum = sum*m;
        }
        return sum;
    }

}

