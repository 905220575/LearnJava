package ChocolateThread;
import java.lang.Thread;
public class ChocolateBoiler implements Runnable{
	private static ChocolateBoiler c;
	private boolean empty;
	private boolean boiled;
	
	private ChocolateBoiler(){
		this.empty = true;
		this.boiled = false;
	}
	public static ChocolateBoiler getInstance(){
		if(c == null){
			c = new ChocolateBoiler();
		}
			return c;
	}
	public void fill() {
		if(c.isEmpty() == true){
			c.empty = false;
			System.out.println("向锅炉填满巧克力和牛奶的混合物。");
		}
		else{
			System.out.println("锅炉已经填满巧克力和牛奶的混合物。");
		}
	} 
	public void boil() {
		if(c.isEmpty() == false && c.isBoiled() == false){
			c.boiled = true;
			System.out.println("将炉内煮沸。");
		}
		else if(c.isEmpty() == true){
			System.out.println("锅炉内没有巧克力和牛奶的混合物。");
		}
		else{
			System.out.println("锅炉已经煮沸。");
		}
	}
	public void drain() {
		if(c.isEmpty() == false && c.isBoiled() == true){
			c.empty = true;
			c.boiled = false;
			System.out.println("排出煮沸的巧克力和牛奶。");
		}
		else if(isEmpty() == true){
			System.out.println("锅炉内没有巧克力和牛奶的混合物。");
		}
		else{
			System.out.println("锅炉未煮沸。");
		}
	} 
	public boolean isEmpty(){
		return c.empty;
	}
	public boolean isBoiled(){
		return c.boiled;
	}
	public void run(){
		try {
			while(true){
				synchronized(this){
					fill();
					boil();
					drain();
				}
				Thread.sleep(1000);
			}

		} catch(InterruptedException e) { 
			System.out.println(e); 
		}
	
	}
}
