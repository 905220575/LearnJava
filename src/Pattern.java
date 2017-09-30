
public class Pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<4;i++){
			for(int j=0;j<3-i;j++){
				System.out.print(" ");
			}
			for(int k=0;k<2*i+1;k++){
				System.out.print("*");
			}
			System.out.print("\n");
		}
		for (int i=3;i>0;i--) {
			for (int j=0;j<4-i;j++) {
				System.out.print(" ");
			}
			for(int k=1;k<2*i;k++){
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
