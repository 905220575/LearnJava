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
			System.out.println("���¯�����ɿ�����ţ�̵Ļ���");
		}
		else{
			System.out.println("��¯�Ѿ������ɿ�����ţ�̵Ļ���");
		}
	} 
	public void boil() {
		if(c.isEmpty() == false && c.isBoiled() == false){
			c.boiled = true;
			System.out.println("��¯����С�");
		}
		else if(c.isEmpty() == true){
			System.out.println("��¯��û���ɿ�����ţ�̵Ļ���");
		}
		else{
			System.out.println("��¯�Ѿ���С�");
		}
	}
	public void drain() {
		if(c.isEmpty() == false && c.isBoiled() == true){
			c.empty = true;
			c.boiled = false;
			System.out.println("�ų���е��ɿ�����ţ�̡�");
		}
		else if(isEmpty() == true){
			System.out.println("��¯��û���ɿ�����ţ�̵Ļ���");
		}
		else{
			System.out.println("��¯δ��С�");
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
