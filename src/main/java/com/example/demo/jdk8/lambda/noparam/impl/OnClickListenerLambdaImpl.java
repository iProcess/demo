package com.example.demo.jdk8.lambda.noparam.impl;

import com.example.demo.jdk8.lambda.noparam.OnClickListener;

/**
 * @author shijincheng
 * @version V1.0
 * date 2019/12/28 13:09
 * Description: TODO
 */
public class OnClickListenerLambdaImpl {

   public OnClickListener mListener = () -> System.out.println("lambda do on Click");


}
