package mylearn.dynamic.proxy;

import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) throws Throwable {
        MyInterface myObject = new MyObject();
        // ʵ����InvocationHandler
        MyInvocationHandler invocationHandler = new MyInvocationHandler(myObject);
        MyInterface proxy = (MyInterface) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                                                                 myObject.getClass().getInterfaces(), invocationHandler);
        // ���ô������ķ���
        proxy.print();
    }

}
