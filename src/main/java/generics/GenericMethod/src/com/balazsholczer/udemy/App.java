package generics.GenericMethod.src.com.balazsholczer.udemy;

public class App {

	public static void main(String[] args) {
		
		com.balazsholczer.udemy.GenericMethod genericMethod = new com.balazsholczer.udemy.GenericMethod();
		//genericMethod.showItem(34.7);
		//System.out.println("The returned item is: " + genericMethod.showItem(45));
		
		Integer[] integerArray = {3,4,5,2,1};
		String[] names = {"Kevin","Joe","Adam","Smith"};
		
		genericMethod.showArray(names);
		
	}
}
