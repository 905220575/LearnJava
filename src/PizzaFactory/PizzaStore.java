package PizzaFactory;

public class PizzaStore {
	private SimplePizzaFactory Factory;
	public PizzaStore(SimplePizzaFactory F){
		Factory = F;
	}
	public Pizza orderPizza(String type){
		Pizza p = this.Factory.createPizza(type);
		p.bake();
		p.cut();
		p.box();
		return p;
	}
}
