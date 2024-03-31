package vip.openpark.jvm;

/**
 * @author anthony
 * @since 2024/3/31 18:07
 */
public class ClassLoaderApplication {
	public static void main(String[] args) {
		// jdk8 可以获取启动类加载器、扩展类加载器，jdk21 获取为null
		// 获取启动类加载器加载的类
		String bootstrapClassPath = System.getProperty("sun.boot.class.path");
		System.out.println("bootstrapClassPath = " + bootstrapClassPath);
		// 获取扩展类加载器加载的类
		String extClassPath = System.getProperty("java.ext.dirs");
		System.out.println("extClassPath = " + extClassPath);
		// 获取用户类加载器加载的类
		String userClassPath = System.getProperty("java.class.path");
		System.out.println("userClassPath" + userClassPath);
	}
}