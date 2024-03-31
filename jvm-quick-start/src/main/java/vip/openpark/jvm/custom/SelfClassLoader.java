package vip.openpark.jvm.custom;

import java.io.*;
import java.nio.file.Files;

/**
 * 自定义 ClassLoader：加载本机指定位置上的 class 文件
 *
 * @author anthony
 * @since 2024/3/31 18:21
 */
public class SelfClassLoader extends ClassLoader {
	private final String classRootPath;
	private final String classLoaderName;
	
	public SelfClassLoader(String classRootPath, String classLoaderName) {
		this.classRootPath = classRootPath;
		this.classLoaderName = classLoaderName;
	}
	
	@Override
	protected Class<?> findClass(String classFullName) throws ClassNotFoundException {
		byte[] bytes = loadClassData(classFullName);
		// 根据二进制流定义一个 Class
		return defineClass(classFullName, bytes, 0, bytes.length);
	}
	
	private byte[] loadClassData(String classFullName) throws ClassNotFoundException {
		String classFullPath = classRootPath + "/" + classFullName.replace(".", "/") + ".class";
		
		File file = new File(classFullPath);
		if (!file.exists()) {
			throw new ClassNotFoundException(classFullPath);
		}
		
		try (InputStream is = Files.newInputStream(file.toPath());
		     ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			int len;
			while ((len = is.read()) != -1) {
				out.write(len);
			}
			
			return out.toByteArray();
		} catch (IOException e) {
			throw new ClassNotFoundException(classFullPath);
		}
	}
}