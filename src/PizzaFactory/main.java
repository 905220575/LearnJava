package PizzaFactory;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimplePizzaFactory Factory = new SimplePizzaFactory();
		PizzaStore Store = new PizzaStore(Factory);
		String PizzaType = "cheese";
		Store.orderPizza(PizzaType);
		System.out.println("顾客A获取到了"+PizzaType+"Pizza");
		PizzaType = "pepperoni";
		Store.orderPizza(PizzaType);
		System.out.println("顾客B获取到了"+PizzaType+"Pizza");
	}

}
