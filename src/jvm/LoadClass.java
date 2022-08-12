package jvm;

import static com.sun.beans.finder.ClassFinder.findClass;
import static com.sun.beans.finder.ClassFinder.resolveClass;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: wangshiqi
 * @DateTime: 2022/7/5 11:28
 * @Description:
 */
public class LoadClass {
    static class DeadLoopClass {
        static {
            // 如果不加上这个if语句，编译器将提示“Initializer does not complete normally” 并拒绝编译
            if (true) {
                System.out.println(Thread.currentThread() + "init DeadLoopClass");
                while (true) {
                }
            }
        }
    }
    public static void main(String[] args) {
        Runnable script = () -> {
            System.out.println(Thread.currentThread() + "start");
            DeadLoopClass dlc = new DeadLoopClass();
            System.out.println(Thread.currentThread() + " run over");
        };
        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);
        thread1.start();
        thread2.start();
    }




    LoadClass parent;

    protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        // 首先，检查请求的类是否已经被加载过了
        Class c = findLoadedClass(name);
        if (c == null) {
            try {
                if (parent != null) {
                    c = parent.loadClass(name, false);
                } else {
                    c = findBootstrapClassOrNull(name);
                }
            } catch (ClassNotFoundException e) {
                // 如果父类加载器抛出ClassNotFoundException
                // 说明父类加载器无法完成加载请求
            }
            if (c == null) {
                // 在父类加载器无法加载时
                // 再调用本身的findClass方法来进行类加载
                c = findClass(name);
            }
        }
        if (resolve) {
            resolveClass(String.valueOf(c));
        }
        return c;
    }

    private Class findBootstrapClassOrNull(String name) {
        return null;
    }

    private Class findLoadedClass(String name) {
        return null;
    }
}
