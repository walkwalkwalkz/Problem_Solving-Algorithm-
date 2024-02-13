import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		arr[3]=1;
		if(N>=5) {
			arr[5]=1;
		}
		
		for(int i=3;i<N+1;i++) {
			if(arr[i]!=0) {
				if(i+3<=N&&arr[i+3]==0) {
					arr[i+3]=arr[i]+1;
				}
				if(i+5<=N&&arr[i+5]==0) {
					arr[i+5]=arr[i]+1;
				}
			}
		}
		
		if(arr[N]==0) {
			System.out.println(-1);
		}else {
			System.out.println(arr[N]);
		}
	}

}