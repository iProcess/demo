package com.example.demo.jdk8.lambda.param;

/**
 * @author shijincheng
 * @version V1.0
 * date 2019/12/28 15:59
 * Description: TODO
 */
public class TestIMathListener {

    IMathListener listener = (x , y) -> {
        if(x > y){
            return x;
        }else {
            return y;
        }
    };

    public static void main(String[] args) {

        TestIMathListener mathListener = new TestIMathListener();
        System.out.println(mathListener.listener.doMathOperator(1, 2));

        IMathListener listener = (x , y) ->{
          if(x > y){
              return x;
          }else {
              return y;
          }
        };
        System.out.println(listener.doMathOperator(2, 3));

    }
}
