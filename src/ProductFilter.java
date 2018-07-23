import java.util.List;
import java.util.stream.Stream;



class ProductFilter {
		
	public Stream<Product> filterByColor (List<Product> products, Product.Color color){
		return products.stream().filter(p -> p.color == color);
	}
	
	public Stream<Product> filterBySize (List<Product> products, Product.Size size){
		return products.stream().filter(p -> p.size == size);
	}
	
	public Stream<Product> filterByColorAndSize (List<Product> products, Product.Color color, Product.Size size){
		return products.stream().filter(p -> p.size == size && p.color == color);
	}

}
