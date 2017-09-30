
public class ToGradeScore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] score = new int[]{95,85,75,65,55};
		char[] lv = new char[score.length];
		System.arraycopy(ToGradeScore(score), 0, lv, 0, score.length);
		for(int i=0;i<score.length;i++){
			System.out.print(score[i]+":");
			System.out.println(lv[i]);
		}
	}
	public static char[] ToGradeScore(int[] score){
		char[] lv = new char[score.length];
		for(int i=0;i<lv.length;i++){
			if(score[i]<=100 && score[i]>=90){
				lv[i] = 'A';
			}
			else if(score[i]<=89 && score[i]>=80){
				lv[i] = 'B';
			}
			else if(score[i]<=79 && score[i]>=70){
				lv[i] = 'C';
			}
			else if(score[i]<=69 && score[i]>=60){
				lv[i] = 'D';
			}
			else{
				lv[i] = 'F';
			}
		}
		return lv;
	}
}
