package exercisecoding.dynamicagent.cglib;



import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: wangxu
 * @date: 2020/9/16 14:35
 */
public class AgentClass implements MethodInterceptor {


    private void before(){
        System.out.println("我是增强类");
    }

    /**
     * 代理方法, 每次调用目标方法时都会进到这里
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        before();
        return methodProxy.invokeSuper(obj, args);
        //        return method.invoke(obj, args);  这种也行
    }

}
