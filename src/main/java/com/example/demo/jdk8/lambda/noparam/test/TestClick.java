package com.example.demo.jdk8.lambda.noparam.test;

import com.example.demo.jdk8.lambda.noparam.OnClickListener;
import com.example.demo.jdk8.lambda.noparam.impl.OnClickListenerImpl;
import com.example.demo.jdk8.lambda.noparam.impl.OnClickListenerLambdaImpl;

/**
 * @author shijincheng
 * @version V1.0
 * date 2019/12/28 13:41
 * Description: TODO
 */
public class TestClick {

    public static void main(String[] args) {
        OnClickListener clickListener = new OnClickListenerImpl();
        clickListener.doOnClick();

        OnClickListenerLambdaImpl lambda = new OnClickListenerLambdaImpl();
        lambda.mListener.doOnClick();
    }

}
