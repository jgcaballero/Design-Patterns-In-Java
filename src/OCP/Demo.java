package OCP;

import java.util.ArrayList;
import java.util.List;
import OCP.Product.Color;
import OCP.Product.Price;
import OCP.Product.Size;

/**
 * OCP + Specification || Specification - In computer programming, the
 * specification pattern is a particular software design pattern, whereby
 * business rules can be recombined by chaining the business rules together
 * using boolean logic. The pattern is frequently used in the context of
 * domain-driven design.
 */

/**
 * THOUGHTS: The OCP has been taught in atleast 3 courses over my bachelors and
 * masters. I had never implemented it in a "real world application", but while
 * on paper it seems that code should be "open for extension, closed for
 * modification", it does not seem very ... straightforward? While I see why
 * this is a good thing, I ended up with having to create multiple classes for
 * something simple that could have been done in fewer. For example, instead of
 * having similiar forms of filtering in my filter class, OCP states that I
 * should not add more code/functionality to my class but rather extend it
 * through the use of implementing interfaces. I ended up with
 * **AndSpecification** and *MultipleSpecification* instead of having those
 * similar methods in one class. It could be that the appeal for OCP is not as
 * strong for such a small-scale project, and where it shines is really in
 * enterprise-level projects, but I can't imagine the amount of classes and the
 * amount of time it takes to search for just that one functionality in a ton of
 * classes. Just my 2c.
 * 
 * Also, a quick google search on critiques of OCP and the Specification design
 * pattern also think similarly of what I just rambled about. Something that
 * struck was the term over-engineering, which is probably what happened here
 * (too much for such a small project).
 * 
 * Even wikipedia critiques the Specification Design Pattern Criticisms The
 * Specification Pattern could be considered a software Anti-Pattern:
 * 
 * Cargo Cult Programming - There lacks a well-defined purpose for this pattern,
 * and there's no guide when to implement it or not. Also, see Law of the
 * instrument. 
 * 
 * Inner-platform effect - And() function which directly replicate
 * && in C#. Also, Not() and potentially more. Also, see Reinventing the square
 * wheel. 
 * 
 * Spaghetti/Lasagna Code - Separate classes for each part of the
 * specification fragments what could be a cohesive object. In the example
 * above, OverDue is an extra layer between the Logic for SendToCollection and
 * the OverDueSpecification implementation.
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
		System.out.println("Green products (With old filter that violates the OCP): ");
		pf.filterByColor(products, Color.GREEN).forEach(p -> System.out.println(" - " + p.name + " is green"));

		// Creating a "better filter" that does not violate the OCP.
		BetterFilter bf = new BetterFilter();
		System.out.println("Green products (With better filter) (No violation): ");
		bf.filter(products, new ColorSpecification(Color.GREEN))
				.forEach(p -> System.out.println(" - " + p.name + " is green"));

		System.out.println("Large blue items: ");
		bf.filter(products,
				new AndSpecification<>(new ColorSpecification(Color.BLUE), new SizeSpecification(Size.LARGE)))
				.forEach(p -> System.out.println(" - " + p.name + " is blue and large"));

		// Extended functionality that is not covered in the tutorial. For practice.
		Product computer = new Product("MSI PC", Color.RED, Size.YUGE, Price.EXPENSIVE);
		Product laptop = new Product("Alienware", Color.GREEN, Size.LARGE, Price.INSANE);
		Product tablet = new Product("iPad", Color.BLUE, Size.SMALL, Price.AFFORDABLE);

		products = List.of(computer, laptop, tablet);
		System.out.println("Custom specifications");
		bf.filter(products,
				new MutipleSpecification<>(new ColorSpecification(Color.RED), new SizeSpecification(Size.YUGE),
						new PriceSpecification(Price.EXPENSIVE)))
				.forEach(p -> System.out.println(" - " + p.name + " fits the criteria"));

	}

}
