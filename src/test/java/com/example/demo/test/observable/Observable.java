package com.example.demo.test.observable;

public class Observable {

//    public interface Subscriber {
//        void onCompleted();
//        void onError(Throwable e);
//        void onNext(Integer integer);
//    }

    public interface OnSubscribe {
        void call(Subscriber subscriber);
    }

    private static final Observable observable = new Observable();

    public static Observable create(OnSubscribe onSubscribe){
        return observable;
    }

    public void subscribe(Subscriber subscriber){}




}
