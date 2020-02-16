package com.example.demo.observable;

public abstract class Subscriber {

    public void onCompleted(){}
    public void onError(Throwable e){}
    public void onNext(Integer integer){}

    public boolean isUnsubscribed(){
        return false;
    }

}
