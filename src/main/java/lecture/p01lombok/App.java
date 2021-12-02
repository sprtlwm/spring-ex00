package lecture.p01lombok;

public class App {
	
	public static void main(String[] args) {
		Customer c1 = new Customer();
		
		c1.setName(c1.getName());
		c1.setCity(c1.getCity());
		c1.setAddress(c1.getAddress());
		c1.setId(c1.getId());
		
		System.out.println(c1.getName());
	}
}
