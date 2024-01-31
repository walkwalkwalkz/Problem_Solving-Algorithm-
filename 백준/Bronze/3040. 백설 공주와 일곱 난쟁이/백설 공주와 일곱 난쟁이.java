import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[] data = new int[7];
	static int[] dwarf;
	
	static boolean comb(int idx,int start, int sum) {
		if(sum>100) return false;
		if(idx==7) {
			if(sum==100) {
				for(int i=0;i<7;i++) {
					System.out.println(data[i]);
				}
				return true;
			}else {
				return false;
			}
		}
		
		for(int i=start;i<9;i++) {
			data[idx]=dwarf[i];
			if(comb(idx+1,i+1,sum+dwarf[i])) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dwarf = new int[9];
		for(int i=0;i<9;i++) {
			dwarf[i]=sc.nextInt();
		}
		
		
		comb(0,0,0);

	}

}