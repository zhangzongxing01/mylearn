package mylearn.dynamic.classLoader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

import mylearn.dynamic.proxy.MyObject;

public class ClassLoaderTest {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
        InputStream input = new FileInputStream(
                                                "D:\\allproject\\learn\\mylearn\\target\\classes\\mylearn\\dynamic\\proxy\\MyObject.class");
        byte[] result = new byte[1024];  
        int count = input.read(result);
        // 使用自定义的类加载器将 byte字节码数组转换为对应的class对象
        MyClassLoader loader = new MyClassLoader();
        @SuppressWarnings("unchecked")
        Class<MyObject> clazz = (Class<MyObject>) loader.defineMyClass(result, 0, count);
        // 测试加载是否成功，打印class 对象的名称
        System.out.println(clazz.getCanonicalName());

        // 实例化一个Programmer对象
        Object o = clazz.newInstance();
        // 调用Programmer的code方法
        clazz.getMethod("print", null).invoke(o, null);
    }
}
