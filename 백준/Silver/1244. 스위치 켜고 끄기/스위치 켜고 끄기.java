import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] arr;
	static int n;
	
	static void man(int num) {
		for(int i=1;i<n+1;i++) {
			if(i%num==0) {
				arr[i] ^= 1;
			}
		}
	}
	
	static void woman(int num) {
		arr[num]^=1;
		int i=1;
		while((num-i>0)&&(num+i<n+1)) {
			if(arr[num-i]!=arr[num+i]) break;
			else {
				arr[num-i]^=1;
				arr[num+i]^=1;
			}
			i++;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		arr = new int[n+1];
		for(int i=1;i<n+1;i++) {
			arr[i]=sc.nextInt();
		}
		
		int m = sc.nextInt();
		for(int i=0; i<m; i++) {
			int s = sc.nextInt();
			int num = sc.nextInt();
			
			if(s==1) {
				man(num);
			}else {
				woman(num);
			}
		}
		
		for(int i=1; i<n+1; i++) {
			System.out.print(arr[i]+" ");
			if((i%20)==0) {
				System.out.println();
			}
		}
	}

}