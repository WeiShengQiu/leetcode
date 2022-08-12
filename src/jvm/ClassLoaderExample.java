package jvm;

import java.io.IOException;
import java.io.InputStream;


/**
 * Created with IntelliJ IDEA.
 *
 * @author: wangshiqi
 * @DateTime: 2022/4/25 16:52
 * @Description:
 */
public class ClassLoaderExample {
    static {
        i = 0; // 给变量复制可以正常编译通过
        //        System.out.print(i); // 这句编译器会提示“非法向前引用”
    }

    static int i = 1;


    static class SuperClass {
        static {
            System.out.println("父类初始化!");
        }

        static int value = 123;
    }

    static class SubClass extends SuperClass {
        static {
            System.out.println("子类初始化!");
        }
    }

    /**
     * 被动使用类字段演示一：
     * 通过子类引用父类的静态字段，不会导致子类初始化
     **/

    static class ConstClass {
        static {
            System.out.println("常量类初始化!");
        }

        public static final String HELLOWORLD = "hello world";
    }

    /**
     * 被动使用类字段演示三：
     * 常量在编译阶段会存入调用类的常量池中，
     * 本质上没有直接引用到定义常量的类，
     * 因此不会触发定义常量的类的初始化
     **/
    //    public static void main(String[] args) {
    //        System.out.println(ConstClass.HELLOWORLD);
    //    }

    static class Parent {
        public static int a = 1;

        static {
            a = 2;
        }
    }

    static class Sub extends Parent {
        public static int b = a;
    }

    public static void main(String[] args) throws Exception {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };
        Object obj = myLoader.loadClass("jvm.ClassLoaderExample").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof ClassLoaderExample);
    }

}
