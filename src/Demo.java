import java.util.Arrays;
import java.util.List;

class Demo {

	public static void main(String [] args) {
			
		Product apple = new Product("apple", Product.Color.GREEN, Product.Size.SMALL);
		Product tree = new Product("Tree", Product.Color.GREEN, Product.Size.LARGE);
		Product house = new Product("House", Product.Color.BLUE, Product.Size.LARGE);
		
		List<Product> products = List.of(apple, tree, house);
	    List<Product> ss = List.of(apple, tree, house);

	}
	

}
