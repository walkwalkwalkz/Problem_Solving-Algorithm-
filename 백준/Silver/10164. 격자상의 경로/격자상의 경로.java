import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		if(k==0) {
			System.out.println(fac(n-1+m-1)/(fac(n-1)*fac(m-1)));
		}else {
			int x = (k-1)/m + 1; 
			int y = (k-1)%m + 1;
			
			System.out.println((fac(x-1+y-1)/(fac(x-1)*fac(y-1)))*(fac(n-x+m-y)/(fac(n-x)*fac(m-y))));
		}
	}
	
	static long fac(int x) {
		if(x==0 || x==1) return 1;
		
		return (long)fac(x-1)*x;
	}
}