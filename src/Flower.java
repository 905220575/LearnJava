
public class Flower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=0,b=0,c=0;		//个位，十位，百位
		for(int i=100;i<1000;i++){
			a = i%10;			//个位
			b = (i%100-a)/10;	//十位
			c = (i-10*b-a)/100;	//百位
			if(i == (c*c*c+b*b*b+a*a*a)){
				System.out.println(i);
			}
		}
		
	}

}
