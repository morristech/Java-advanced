package me.shouheng.rxjava;

import io.reactivex.*;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class RxJavaExample {

    public static void main(String...args) {
        simpleExample3();
    }

    /**
     * 示例1：
     *
     * 在下面这个程序中使用，Observable.create()方法创建了一个被观察者，在它的内部我们可以执行一些异步的操作
     * 比如下面的程序中，使用了线程的延时。而且，在这个程序中，我们可以使用observableEmitter来将执行的中间信
     * 息传递给它的观察者。最后，使用了subscribe方法，并传入了一个匿名类，在内部我们写一些当获取到观察的结果
     * 之后需要执行的逻辑。总体而言，对于需要异步处理的一些逻辑，使用rxJava这种观察者模式还是非常方便的。
     *
     * 其实JDK中本身也不缺少一些阻塞的异步方法，比如Future这样的，那么rxjava相比于它们有什么优势呢？是否可以
     * 在Java项目中大规模使用它呢？*/
    private static void simpleExample1() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            observableEmitter.onNext("Thread prepared!");
                            Thread.sleep(4000);
                            observableEmitter.onNext("Thread executed!");
                            throw new Exception("Error occord!");
                        } catch (Exception e) {
                            observableEmitter.onError(e);
                        }
                    }
                }).start();
            }
        }).subscribe(new Observer<String>() {

            int i = 0;

            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(String s) {
                System.out.println(++i + ":" + s);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError:" + throwable);
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete!");
            }
        });
    }

    /**
     * 多次调用 subscribeOn() 只有第一次的有效，其余的会被忽略。
     * 但多次指定订阅者接收线程是可以的，也就是说每调用一次 observerOn()，下游的线程就会切换一次。 */
    private static void simpleExample2() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            observableEmitter.onNext("Thread prepared!");
                            Thread.sleep(4000);
                            observableEmitter.onNext("Thread executed!");
                            observableEmitter.onComplete();
                        } catch (Exception e) {
                            observableEmitter.onError(e);
                        }
                    }
                }).start();
            }
        }).subscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(@NonNull String s) throws Exception {
                        System.out.println("After observeOn(io)，Current thread is " + Thread.currentThread().getName());
                    }
                });
    }

    private static void simpleExample3() {
        Disposable mDisposable = Flowable.interval(1, TimeUnit.SECONDS)
                .doOnNext(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long aLong) throws Exception {
                        System.out.println("accept: doOnNext : " + aLong );
                    }
                })
                .observeOn(Schedulers.io())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long aLong) throws Exception {
                        System.out.println("accept: 设置文本 ："+aLong );
                    }
                });
    }
}
