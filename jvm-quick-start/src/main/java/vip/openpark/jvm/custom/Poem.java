package vip.openpark.jvm.custom;

import java.io.Serializable;

/**
 * @author anthony
 * @since 2024/3/31 18:31
 */
public class Poem implements Serializable {
	private static final long serialVersionUID = -1832305958323480991L;
	
	public Poem() {
		System.out.println("人生得以须尽欢，莫使金樽空对月。");
	}
	
	public void print() {
		System.out.println("天生我材必有用，千金散尽还复来。");
	}
}