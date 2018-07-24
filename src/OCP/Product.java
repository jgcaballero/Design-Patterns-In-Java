package OCP;

public class Product {
	
	enum Color {
		RED, GREEN, BLUE
	}

	enum Size {
		SMALL, MEDIUM, LARGE, YUGE
	}
	
	enum Price {
		AFFORDABLE, EXPENSIVE, INSANE
	}

	public String name;
	public Color color;
	public Size size;
	public Price price;
	
	//Tutorial implements products with only name color and size.
	public Product(String name, Color color, Size size) {
		this.name = name;
		this.color = color;
		this.size = size;
	}
	
	//Going to add more functionality to see if I grasped the subject completely.
	public Product(String name, Color color, Size size, Price price) {
		this.name = name;
		this.color = color;
		this.size = size;
		this.price = price;
	}
	
	// G&S
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", size=" + size + "]";
	}
	
	
	

}
