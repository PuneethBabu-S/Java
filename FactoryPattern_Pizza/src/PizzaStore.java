
public class PizzaStore {
	
	public Pizza orderPizza(String type) {
		Pizza p = PizzaFactory.makePizza(type);
		p.prepare();
		p.bake();
		p.cut();
		return p;
	}
	
}
