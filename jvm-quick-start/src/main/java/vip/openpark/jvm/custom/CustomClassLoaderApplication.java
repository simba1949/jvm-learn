package vip.openpark.jvm.custom;

import java.lang.reflect.Method;

/**
 * @author anthony
 * @since 2024/3/31 18:32
 */
public class CustomClassLoaderApplication {
	public static void main(String[] args) throws Exception {
		// 自定义类加载器
		CustomClassLoader customClassLoader = new CustomClassLoader("D:\\IDE\\IDEA\\workspace\\class-loader", "selfClassLoader");
		// 加载类
		Class<?> aClass = customClassLoader.loadClass("vip.openpark.jvm.custom.Poem");
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