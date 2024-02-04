import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		if(k==0) {
			System.out.println(fac(n-1+m-1,m)/(fac(n-1,2)));
		}else {
			int x = (k-1)/m + 1; 
			int y = (k-1)%m + 1;
			
			System.out.println((fac(x-1+y-1,y)/fac(x-1,2))*(fac(n-x+m-y,m-y+1)/fac(n-x,2)));
		}
	}
	
	static long fac(int x,int n) {
		if(x==0 || x==1) return 1;
		if(x<n) return 1;
		return x*fac(x-1,n);
	}
}