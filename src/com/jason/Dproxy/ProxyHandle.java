package com.jason.Dproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProxyHandle implements InvocationHandler {

	private Object obj;

	public Object bind(Object obj) {
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		log("调用开始。。。。。。"+method.getName());
		result = method.invoke(obj, args);
		log("调用后......"+method.getName());
		return null;
	}

	private void log(String message) {
		Logger.getLogger(ProxyHandle.class.getName()).log(Level.INFO, message);
	}

}
