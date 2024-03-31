package vip.openpark.order;

/**
 * @author anthony
 * @since 2024/3/31 16:20
 */
public class Parent {
	
	static {
		System.out.println("Parent static block");
	}
	
	{
		System.out.println("Parent instance block");
	}
	
	public Parent() {
		System.out.println("Parent constructor");
	}
}