package mylearn.dynamic.proxy;

public class ProxyTest {

    public static void main(String[] args) {
        MyInterface myObject = new MyObject();

        // ʵ����InvocationHandler
        MyInvocationHandler invocationHandler = new MyInvocationHandler(myObject);

        // ����Ŀ��������ɴ������
        MyInterface proxy = (MyInterface) invocationHandler.getProxy();

        // ���ô������ķ���
        proxy.print();
    }

}
