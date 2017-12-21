package ChocolateThread;

public class ChocolateBoilerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChocolateBoiler c;
		c = ChocolateBoiler.getInstance();
		Thread TA = new Thread(c);
		Thread TB = new Thread(c);
		Thread TC = new Thread(c);
		Thread TD = new Thread(c);
		TA.start();
		TB.start();
		TC.start();
		TD.start();
	}

}
