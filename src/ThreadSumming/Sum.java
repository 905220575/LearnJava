package ThreadSumming;

public class Sum extends Thread{
	private static Thread [] jobs = new Thread[4]; 
	private int star;
	private int end;
	private static int sum = 0;
	public Sum(int s,int e){
		star=s;
		end=e;
	}
	public void run(){
		System.out.println("Star summing "+star+" from "+end);
		int stage = 0;
		try {
			for(int i=star;i<=end;i++){
				sum +=i;
				stage +=i;
			}
			sleep(1000);
		} catch(InterruptedException e) { 
			System.out.println(e); 
		}
		System.out.println("This stage sum is "+stage);
		System.out.println("The hole summing is "+sum);
	}
	public static void main(String[] args) {
		jobs[0] = new  Thread(new Sum(1,25));
		jobs[1] = new  Thread(new Sum(26,50));
		jobs[2] = new  Thread(new Sum(51,75));
		jobs[3] = new  Thread(new Sum(76,100));
		try { 
			for(int i=0; i<jobs.length; i++) { 
				jobs[i].start(); 
				jobs[i].join(); 
				} 
		} catch(InterruptedException e) { 
			System.out.println(e); 
		}

		
	}

}
