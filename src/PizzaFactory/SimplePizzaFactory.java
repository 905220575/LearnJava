package PizzaFactory;

public class SimplePizzaFactory {
	public Pizza createPizza(String type){
		if(type.equals("cheese")){
			CheesePizza c = new CheesePizza();
			return c;
		}
		else if(type.equals("pepperoni")){
			PepperoniPizza p = new PepperoniPizza();
			return p;
		}
		else if(type.equals("clam")){
			ClamPizza a = new ClamPizza();
			return a;
		}
		else{
			System.out.println("Œﬁ¥À¿‡Pizza");
			return null;
		}
	}
	
	
}
