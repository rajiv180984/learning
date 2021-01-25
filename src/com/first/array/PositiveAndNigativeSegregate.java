package src.com.first.array;

public class PositiveAndNigativeSegregate {

	public static void main(String[] args) {
			int []a = {-10, -4,20,-1,8,9,11,1};
			int i=0; int j=a.length-1;
			while(i<j) {
				if(a[i]<0) {
					i++;
				}else {
					if(a[j]>0) {
						j--;
					}else {
						int t= a[i];
						a[i] = a[j];
						a[j] =t;
						i++;
						j--;
					}
				}
			}
			for(int k: a) {
				System.out.println(k);
			}
	}
	
}
