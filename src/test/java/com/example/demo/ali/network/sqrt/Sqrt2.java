package com.example.demo.ali.network.sqrt;

public class Sqrt2 {

    private final static double EPSINON = 0.0000000001;

    double sqrt2(){
        double low = 1.4;
        double high = 1.5;
        double mid = (low + high) / 2;

        while (high - low > EPSINON){
            if (mid * mid > 2){
                high = mid;
            }else{
                low = mid;
            }
            mid = (high + low) / 2;
        }
        return mid;
    }

    public static void main(String[] args) {
        Sqrt2 sqrt2 = new Sqrt2();
        double d = sqrt2.sqrt2();
        System.out.println(d);
    }

}
