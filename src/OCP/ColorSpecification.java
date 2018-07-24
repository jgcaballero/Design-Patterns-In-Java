package OCP;

public class ColorSpecification implements Specification<Product> {

	private Product.Color color;
	
	public ColorSpecification(Product.Color color) {
		this.color = color;
	}
	
	@Override
	public boolean isSatisfied(Product p) {
		return p.color == color;
	}
	
}
