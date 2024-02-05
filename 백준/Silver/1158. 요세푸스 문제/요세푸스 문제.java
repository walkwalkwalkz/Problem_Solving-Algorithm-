import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i=1;i<n+1;i++) {
			list.offer(i);
		}
		
		int index=0;
		System.out.print("<");
		while(!list.isEmpty()) {
			index = (index+k-1)%list.size();
			if(list.size()>1) {
				System.out.print(list.remove(index)+", ");
			}else {
				System.out.print(list.remove(index));
			}
		}
		System.out.print(">");
	}

}