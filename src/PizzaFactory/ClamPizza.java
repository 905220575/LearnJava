package PizzaFactory;

public class ClamPizza extends Pizza{
	public  void prepare(){
		System.out.println("ClamPizza正在准备");
	}//准备材料
	public  void bake(){
		System.out.println("ClamPizza正在烘培");
	}//烘焙披萨
	public  void cut(){
		System.out.println("ClamPizza正在切割");
	}//切割披萨
	public  void box(){
		System.out.println("ClamPizza正在装包");
	}//披萨装包
}
