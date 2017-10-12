package PizzaFactory;

public class CheesePizza extends Pizza{
	public  void prepare(){
		System.out.println("CheesePizza正在准备");
	}//准备材料
	public  void bake(){
		System.out.println("CheesePizza正在烘培");
	}//烘焙披萨
	public  void cut(){
		System.out.println("CheesePizza正在切割");
	}//切割披萨
	public  void box(){
		System.out.println("CheesePizza正在装包");
	}//披萨装包
}
