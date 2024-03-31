package vip.openpark.order;

/**
 * @author anthony
 * @since 2024/3/31 16:20
 */
public class Son extends Parent {
	static {
		System.out.println("Son static block");
	}
	
	{
		System.out.println("Son instance block");
	}
	
	public Son() {
		System.out.println("Son constructor");
	}
}
