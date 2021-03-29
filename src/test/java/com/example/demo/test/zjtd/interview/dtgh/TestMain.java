package com.example.demo.test.zjtd.interview.dtgh;

import java.util.Scanner;

/**
 * http://www.voidcn.com/article/p-mgbbpqwt-bkm.html
 * 动态规划-村子募捐问题
 * 有一个村子，村子里的房屋围着一口井建的，现在井坏了，要花钱修理，所以在村子里募捐。
 * 每户人家都讨厌自己的邻居，只要自己的邻居捐了，那自己就不愿意捐。
 * 现在知道每户人家可以捐出的数目，求可以募捐的最大金额是多少？
 *
 * 意思就是在一列数组中取数，相邻的两个数不能够一起被取出，
 * 起始点和末尾点也是相邻的（因为是围着一口井建的，可以理解成一个圆），求取出序列的和最大是多少。
 *
 */
public class TestMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }
        System.out.println(Dptool(N,num));
    }

    static int Dptool(int N,int[] num){
        int a,b;
        //分成两个区间，为了排除起始点和末尾点相邻的情况。
        a = Dp(false, N, num);//0-N-1
        b = Dp(true, N, num);//1-N
        System.out.println(a+"-"+b);
        //取a，b中大的值。
        if (a >= b)
            return a;
        else
            return b;
    }

    static int Dp(boolean first,int N,int[] num){
        int aflag = 0;
        int bflag = num[0];
        int end = N;
        if (first == false) {//0-N-1
            end = N-1;
        }else if(first == true){//1-N
            bflag = 0;
            end = N;
        }
        for (int i = 1; i < end; i++) {
            if (aflag +num[i] >= bflag ) {
                int temp = bflag;
                bflag = aflag + num[i];
                aflag = temp;
            }
            else {
                aflag = bflag;
            }
        }
        return bflag;
    }

}
