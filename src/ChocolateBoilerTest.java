
public class ChocolateBoilerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChocolateBoiler c;
		c = ChocolateBoiler.getInstance();
		for(int i=0;i<2;i++){
			c.fill();
			c.boil();
			c.drain();
		}
	}

}
