package OCP;

import java.util.List;
import OCP.Product.Color;
import OCP.Product.Size;

/**
 * OCP + Specification || Specification - In computer programming, the
 * specification pattern is a particular software design pattern, whereby
 * business rules can be recombined by chaining the business rules together
 * using boolean logic. The pattern is frequently used in the context of
 * domain-driven design.
 */

public class Demo {

	public static void main(String[] args) {

		// Creating sample objects
		Product apple = new Product("apple", Color.GREEN, Product.Size.SMALL);
		Product tree = new Product("Tree", Color.GREEN, Product.Size.LARGE);
		Product house = new Product("House", Color.BLUE, Product.Size.LARGE);

		// Passing objects to a list
		List<Product> products = List.of(apple, tree, house);

		/**
		 * This violates the open closed principle because functionality should not be
		 * added to the same class. First filterByColor was added, then filterBySize,
		 * then filterBySizeAndColor. In object-oriented programming, the open/closed
		 * principle states "software entities (classes, modules, functions, etc.)
		 * should be open for extension, but closed for modification"; that is, such an
		 * entity can allow its behaviour to be extended without modifying its source
		 * code.
		 */
		ProductFilter pf = new ProductFilter();
		System.out.println("Green products (With old filter): ");
		pf.filterByColor(products, Color.GREEN).forEach(p -> System.out.println(" - " + p.name + " is green"));

		// Creating a "better filter" that does not violate the OCP.
		BetterFilter bf = new BetterFilter();
		System.out.println("Green products (With better filter): ");
		bf.filter(products, new ColorSpecification(Color.GREEN))
				.forEach(p -> System.out.println(" - " + p.name + " is green"));

		System.out.println("Large blue items: ");
		bf.filter(products,
				new AndSpecification<>(new ColorSpecification(Color.BLUE), new SizeSpecification(Size.LARGE)))
				.forEach(p -> System.out.println(" - " + p.name + " is blue and large"));

	}

}
