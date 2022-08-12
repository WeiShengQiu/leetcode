package jvm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile变量自增运算测试
 *
 * @author: wangshiqi
 * @DateTime: 2022/8/1 15:22
 * @Description:
 */
public class VolatileTest {
    public static volatile int race = 0;

    public static volatile AtomicInteger race2 = new AtomicInteger(0);

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    race++;
//                    race2.getAndIncrement();
                }
            });
            threads[i].start();
        }
        // 等待所有累加线程都结束
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(race);
//        System.out.println(race2);
    }
}
