package mylearn.reflect.base;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;
import javassist.NotFoundException;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;

public class MethodTest {

    public static void main(String[] args) throws ClassNotFoundException, NotFoundException {
//        jdkRefect();
        javassistMethod();  
    }

    private static void javassistMethod() throws ClassNotFoundException, NotFoundException {
        Class clazz = Class.forName("mylearn.reflect.base.domain.MyObject");
        ClassPool pool = ClassPool.getDefault();  
        CtClass cc = pool.get(clazz.getName());  
        CtMethod cm = cc.getDeclaredMethod("test3");  
      
        MethodInfo methodInfo = cm.getMethodInfo();  
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();  
        LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);  
        if (attr == null) {  
            // exception  
        }  
        String[] paramNames = new String[cm.getParameterTypes().length];  
        int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;  
        for (int i = 0; i < paramNames.length; i++)  
            paramNames[i] = attr.variableName(i + pos);  
    
        for (int i = 0; i < paramNames.length; i++) {  
            System.out.println(paramNames[i]);  
        }
    }

    private static void jdkRefect() throws ClassNotFoundException {
        Class myClass = Class.forName("mylearn.reflect.base.domain.MyObject");
        Method[] myMethod = myClass.getMethods();
        for (Method method : myMethod) {
            if(!method.getName().equals("test3")){
                continue;
            }
            Parameter[] parameters = method.getParameters();
            if (parameters == null) {
                continue;
            }
            for (Parameter parameter : parameters) {
                String pName = parameter.getName();
                System.out.println(pName);
            }
        }
    }

}
