package com.example.demo.jdk8.lambda.noparam.impl;

import com.example.demo.jdk8.lambda.noparam.OnClickListener;

/**
 * @author shijincheng
 * @version V1.0
 * date 2019/12/28 13:09
 * Description: TODO
 */
public class OnClickListenerImpl implements OnClickListener {

    @Override
    public void doOnClick() {
        System.out.println("传统的do on click");
    }

}
