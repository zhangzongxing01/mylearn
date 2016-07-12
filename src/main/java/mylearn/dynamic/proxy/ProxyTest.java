package mylearn.dynamic.proxy;

public class ProxyTest {

    public static void main(String[] args) {
        MyInterface myObject = new MyObject();

        // 实例化InvocationHandler
        MyInvocationHandler invocationHandler = new MyInvocationHandler(myObject);

        // 根据目标对象生成代理对象
        MyInterface proxy = (MyInterface) invocationHandler.getProxy();

        // 调用代理对象的方法
        proxy.print();
    }

}
