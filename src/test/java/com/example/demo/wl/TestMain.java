package com.example.demo.wl;

public class TestMain {

    public static void main(String[] args) {

        for(int n =0;n<11;n++){
            int count = 0;
            count = func(n+1);
            System.out.println("楼梯数:"+n+",方法数:"+count);
        }



    }

    public static int func(int i){
        if(i==2){
            return 2;
        }else if(i==1){
            return 1;
        }else if(i==0){
            return 0;
        }else{
            return func(i-1)+func(i-2);
        }
    }
}
