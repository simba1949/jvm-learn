package vip.openpark.jvm.custom;

/**
 * <div>
 *     <ul>
 *         <li>1. 编译该类，获取 class 文件</li>
 *         <li>2. 把 classes 文件下放到 classRootPath 目录下，需要保证类全路径和 class 文件名一致</li>
 *         <li>3. 注释该类，防止 ApplicationClassLoader 加载，如果是破坏双亲委托机制的话，可以不注释</li>
 *     </ul>
 * </div>
 *
 * @author anthony
 * @since 2024/3/31 18:31
 */
public class Poem {
	public Poem() {
		System.out.println("人生得以须尽欢，莫使金樽空对月。");
	}
	
	public void print() {
		System.out.println("天生我材必有用，千金散尽还复来。");
	}
}