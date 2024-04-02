package vip.openpark.jvm.custom;

import java.lang.reflect.Method;

/**
 * @author anthony
 * @since 2024/3/31 19:44
 */
public class BreakParentalDelegationClassLoaderApplication {
	public static void main(String[] args) throws Exception {
		// 自定义类加载器
		BreakParentalDelegationClassLoader classLoader = new BreakParentalDelegationClassLoader("D:\\IDE\\IDEA\\workspace\\class-loader", "breakParentalDelegationClassLoader");
		// 加载类
		Class<?> aClass = classLoader.loadClass("vip.openpark.jvm.custom.Poem");
		// 打印 class 类全路径
		System.out.println(aClass);
		// 打印 class 类加载器
		System.out.println(aClass.getClassLoader());
		
		// 因为代码里面找不到 Poem 类，这里使用 Object 作为 Poem 类的实例
		Object instance = aClass.getDeclaredConstructor().newInstance();
		// 调用 print 方法
		Method printMethod = aClass.getMethod("print");
		printMethod.invoke(instance);
	}
}