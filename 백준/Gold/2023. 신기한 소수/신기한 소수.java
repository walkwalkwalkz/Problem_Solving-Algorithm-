import java.util.Scanner;

public class Main {
	static int N;
	static int[] nums = {1,3,7,9};
	
	static boolean check(int num) {
		for(int i=2;i<=Math.sqrt(num);i++) {
			if(num%i==0) return false;
		}
		return true;
	}
	
	static void amazingMinority(int depth, int num) {
		if(check(num)) {
			if(depth==N-1) {
				System.out.println(num);
				return;
			}
			
			for(int n:nums) {
				amazingMinority(depth+1,num*10+n);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		amazingMinority(0,2);
		amazingMinority(0,3);
		amazingMinority(0,5);
		amazingMinority(0,7);
	}

}