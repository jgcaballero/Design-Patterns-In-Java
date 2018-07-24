package OCP;

public class Product {
	
	enum Color {
		RED, GREEN, BLUE
	}

	enum Size {
		SMALL, MEDIUM, LARGE, YUGE
	}

	public String name;
	public Color color;
	public Size size;
	
	public Product(String name, Color color, Size size) {
		this.name = name;
		this.color = color;
		this.size = size;
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
