package vip.openpark.jvm.custom;

import java.lang.reflect.Constructor;

/**
 * @author anthony
 * @since 2024/3/31 18:32
 */
public class SelfClassLoaderApplication {
	public static void main(String[] args) throws Exception {
		// 自定义类加载器
		SelfClassLoader selfClassLoader = new SelfClassLoader("D:\\workspace\\jvm-quick-start\\target\\classes", "selfClassLoader");
		// 加载类
		Class<?> aClass = selfClassLoader.loadClass("vip.openpark.jvm.custom.Poem");
		// 创建对象
		Constructor<?> constructor = aClass.getConstructor();
		Poem poem = (Poem) constructor.newInstance();
		poem.print();
	}
}