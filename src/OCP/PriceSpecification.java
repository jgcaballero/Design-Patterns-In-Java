package OCP;

public class PriceSpecification implements Specification<Product>{
	
	private Product.Price price;
	
	public PriceSpecification(Product.Price price) {
		this.price = price;
	}

	@Override
	public boolean isSatisfied(Product p) {
		return p.price == price;
	}
	
	

}
