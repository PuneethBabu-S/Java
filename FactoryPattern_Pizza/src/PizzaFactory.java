
public class PizzaFactory {
	
	public static Pizza makePizza(String type) {
		Pizza p = null;
		if(type.equals("Veg")) p = new VegPizza();
		else if(type.equals("Chicken")) p = new ChickenPizza();
		return p;
	}
	
}
