package com.example.demo;


import com.example.demo.observable.Observable;
import com.example.demo.observable.Subscriber;

public class TestObservable {

    public static void main(String[] args) {
        TestObservable testObservable = new TestObservable();
        testObservable.test();
    }

    private Observable createObserver(){
        return Observable.create(new Observable.OnSubscribe(){
            @Override
            public void call(Subscriber subscriber) {
                if(!subscriber.isUnsubscribed()){
                    subscriber.onNext(1);
                    subscriber.onCompleted();
                    subscriber.onError(new Throwable("value > 8"));
                }
            }
        });
    }

    private void test(){
        createObserver().subscribe(new Subscriber() {
            @Override
            public void onCompleted() {
                super.onCompleted();
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }

            @Override
            public void onNext(Integer integer) {
                super.onNext(integer);
            }
        });
    }

}
