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
        // ʹ���Զ������������� byte�ֽ�������ת��Ϊ��Ӧ��class����
        MyClassLoader loader = new MyClassLoader();
        @SuppressWarnings("unchecked")
        Class<MyObject> clazz = (Class<MyObject>) loader.defineMyClass(result, 0, count);
        // ���Լ����Ƿ�ɹ�����ӡclass ���������
        System.out.println(clazz.getCanonicalName());

        // ʵ����һ��Programmer����
        Object o = clazz.newInstance();
        // ����Programmer��code����
        clazz.getMethod("print", null).invoke(o, null);
    }
}
