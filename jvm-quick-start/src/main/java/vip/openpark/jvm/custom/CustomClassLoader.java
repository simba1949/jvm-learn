package vip.openpark.jvm.custom;

import java.io.*;
import java.nio.file.Files;

/**
 * 自定义 ClassLoader：加载本机指定位置上的 class 文件
 *
 * @author anthony
 * @since 2024/3/31 18:21
 */
public class CustomClassLoader extends ClassLoader {
	private final String classRootPath;
	private final String classLoaderName;
	
	/**
	 * 构造函数
	 *
	 * @param classRootPath   类文件根路径
	 * @param classLoaderName 类加载器名称
	 */
	public CustomClassLoader(String classRootPath, String classLoaderName) {
		super();
		this.classRootPath = classRootPath;
		this.classLoaderName = classLoaderName;
	}
	
	/**
	 * 构造函数
	 *
	 * @param classRootPath   类文件根路径
	 * @param classLoaderName 类加载器名称
	 * @param parent          父类加载器
	 */
	public CustomClassLoader(String classRootPath, String classLoaderName, ClassLoader parent) {
		super(parent);
		this.classRootPath = classRootPath;
		this.classLoaderName = classLoaderName;
	}
	
	/**
	 * 加载类
	 *
	 * @param classFullName 类全名
	 * @return 类
	 * @throws ClassNotFoundException 类未找到异常
	 */
	@Override
	protected Class<?> findClass(String classFullName) throws ClassNotFoundException {
		byte[] classByteArray = loadClassData(classFullName);
		// 根据二进制流定义一个 Class
		return this.defineClass(classFullName, classByteArray, 0, classByteArray.length);
	}
	
	/**
	 * 加载类二进制流
	 *
	 * @param classFullName 类全名
	 * @return 类二进制流
	 * @throws ClassNotFoundException 类未找到异常
	 */
	private byte[] loadClassData(String classFullName) throws ClassNotFoundException {
		// 类全名转类路径
		String classFullPath = classFullName.replace(".", "/") + ".class";
		File file = new File(classRootPath, classFullPath);
		// 文件不存在
		if (!file.exists()) {
			throw new ClassNotFoundException(classFullPath);
		}
		// 文件大小为0
		if (file.length() <= 0) {
			throw new ClassNotFoundException(classFullPath);
		}
		
		try (InputStream is = Files.newInputStream(file.toPath());
		     ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			int len;
			while ((len = is.read()) != -1) {
				out.write(len);
			}
			out.flush();
			return out.toByteArray();
		} catch (IOException e) {
			throw new ClassNotFoundException(classFullPath);
		}
	}
}