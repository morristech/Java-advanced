package me.shouheng.guava;

import com.google.common.util.concurrent.*;

import javax.annotation.Nullable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class ListenableFutureExample {

    public static void main(String...args) {
        /**
         * 将ExecutorService装饰成ListeningExecutorService */
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());

        /**
         * 通过异步的方式计算返回结果 */
        ListenableFuture<String> future = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("call execute..");
                return "task success!";
            }
        });

        /**
         * 有两种方法可以执行此Future并执行Future完成之后的回调函数
         * 该方法会在多线程运算完的时候,指定的Runnable参数传入的对象会被指定的Executor执行 */
        future.addListener(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("result: " + future.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }, service);

        Futures.addCallback(future, new FutureCallback<String>() {
            @Override
            public void onSuccess(@Nullable String result) {
                System.out.println("callback result: "+result);
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println(t.getMessage());
            }
        },service);
    }
}
