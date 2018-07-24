package OCP;

public class SizeSpecification implements Specification<Product>{
	
	private Product.Size size;
	
	public SizeSpecification(Product.Size size) {
		this.size = size;
	}

	@Override
	public boolean isSatisfied(Product p) {
		return p.size == size;
	}

	
	
}
