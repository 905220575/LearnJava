
public class Flower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=0,b=0,c=0;		//��λ��ʮλ����λ
		for(int i=100;i<1000;i++){
			a = i%10;			//��λ
			b = (i%100-a)/10;	//ʮλ
			c = (i-10*b-a)/100;	//��λ
			if(i == (c*c*c+b*b*b+a*a*a)){
				System.out.println(i);
			}
		}
		
	}

}
