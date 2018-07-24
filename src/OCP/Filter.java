package OCP;

import java.util.List;
import java.util.stream.Stream;

//Taking a list of items and retuns only those items that satisfy that given specification
public interface Filter<T> {
	
	Stream<T> filter(List<T> items, Specification<T> spec);

}
