package com.zx.demo.demode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import com.zx.demo.advise.AdviseType;
import com.zx.demo.demode.proxy.impl.RealSubject;

/**
 * 动态代理
 * 
 * @author zhixin
 *
 */
public class DynamicProxyFactory {

	/**
	 * 使用动态代理的对象必须实现一个或多个接口,如果想代理没有实现接口的类,就可以使用Cglib实现.
	 * 
	 * @return
	 */
	public static Subject createProxy() {

		final Subject sub = new RealSubject();
		Subject proxy = (Subject) Proxy.newProxyInstance(DynamicProxyFactory.class.getClassLoader(),
				RealSubject.class.getInterfaces(), new InvocationHandler() {
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("执行前...");
						AdviseType.BEFORE.advise();
						Object invoke = method.invoke(sub, args);
						AdviseType.AFTER.advise();
						System.out.println("执行后...");
						return invoke;
					}
				});

		return proxy;
	}

	/**
	 * 如果目标对象没有实现接口可以采用cglib代理，目标类实现了接口采用jdk动态代理，静态代理一般不建议使用。
	 * 
	 * @return
	 */
	public static Subject createCglibProxy() {
		final Subject sub = new RealSubject();
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(Subject.class);
		enhancer.setCallback(new MethodInterceptor() {

			public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy)
					throws Throwable {
				System.out.println("执行前...");
				AdviseType.BEFORE.advise();
				Object invoke = method.invoke(sub, args);
				AdviseType.AFTER.advise();
				System.out.println("执行后...");
				return invoke;
			}
		});

		return (Subject) enhancer.create();
	}

}
