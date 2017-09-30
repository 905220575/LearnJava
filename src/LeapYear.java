
public class LeapYear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		for(int i=1990;i<=2007;i++){
			if(i%4==0 && i%100 != 0){
				count++;
				System.out.print(i+"  ");
				if(count%2==0){
					System.out.print("\n");
				}
			}
			else if(i%400==0){
				count++;
				System.out.print(i+"  ");
				if(count%2==0){
					System.out.print("\n");
				}
			}
		}
	}

}
