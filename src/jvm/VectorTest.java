package jvm;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: wangshiqi
 * @DateTime: 2022/12/8 10:46
 * @Description:
 */
public class VectorTest {
    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }
            Thread removeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }
                }
            });
            Thread printThread = new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    System.out.println((vector.get(i)));
                }
            });

            removeThread.start();
            printThread.start();
            //不要同时产生过多的线程，否则会导致操作系统假死
            while (Thread.activeCount() > 20)
                ;
        }

    }

    static {
        Thread removeThread = new Thread(() -> {
            synchronized (vector) {
                for (int i = 0; i < vector.size(); i++) {
                    vector.remove(i);
                }
            }
        });
        Thread printThread = new Thread(() -> {
            synchronized (vector) {
                for (int i = 0; i < vector.size(); i++) {
                    System.out.println((vector.get(i)));
                }
            }
        });
    }
}
