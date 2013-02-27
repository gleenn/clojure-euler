package gleenn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Foo {
  public void sayHi();
  public void sayBye();
}

abstract class Bar {
  public abstract void sayHi();
}

public class ProxyTime {
  public static void main(String[] args) throws IllegalAccessException, InstantiationException {

    InvocationHandler sayHiHandler = new InvocationHandler() {
      public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        return null;
      }
    };
    Class proxyClass = Proxy.getProxyClass(Foo.class.getClassLoader(), new Class[]{Foo.class});
    Foo foo = (Foo)proxyClass.newInstance();

//    Foo f = (Foo) proxyClass.getConstructor(new Class[]{InvocationHandler.class}).
//            newInstance(new Object[]{sayHiHandler});
//
//    System.out.println("hi");
//    Foo f = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),
//            new Class[]{Foo.class, Bar.class},
//            new InvocationHandler() {
//              public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
//                System.out.println("omg i'm so awesome");
//                return null;
//              }
//            });
//    f.sayHi();
//    f.sayBye();
  }
}
