
public interface Interface1 {
	
	//Interface1 is functional interface since only one abstract method
	
	//default method can be overridden
	public default void print() {
		System.out.println("Hello World");
	}
	
	//static method cannot be overridden
	public static void method() {
		System.out.println("Static method");
	}
	
	//abstract method
	void solve();
	
}
