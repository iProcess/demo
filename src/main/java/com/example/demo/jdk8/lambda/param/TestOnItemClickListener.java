package com.example.demo.jdk8.lambda.param;

/**
 * @author shijincheng
 * @version V1.0
 * date 2019/12/28 15:47
 * Description: TODO
 */
public class TestOnItemClickListener {

    OnItemClickListener mItemListener = position -> System.out.println("position = [" + position + "]");

    OnItemClickListener mItemListener1 = position -> System.out.println("position = ");

    public static void main(String[] args) {
        TestOnItemClickListener lambda = new TestOnItemClickListener();
        lambda.mItemListener.doItemClickListener(123);

        lambda.mItemListener1.doItemClickListener(121);
    }
}
