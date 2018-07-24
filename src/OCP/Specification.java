package OCP;

//Checks whether a particular items satisfy some criteria.
public interface Specification<T> {

	boolean isSatisfied(T item);
	
	
}
