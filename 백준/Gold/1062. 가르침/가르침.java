import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int[] lang; //단어마다 5개중 없는거
	static List<Integer> arr = new ArrayList<Integer>(); // 조합할 글자 //확인함
	static int[] numbers; // 조합 넣을거
	static int res;
	static int m;
	static int n;
	
	static int check() {
		int tmp=0;
		for(int i=0;i<m;i++) {
			tmp|=numbers[i];
		}
		
		int cnt=0;
		for(int i=0;i<n;i++) {
			if((tmp&lang[i])==lang[i]) {
				cnt+=1;
			}
		}

		return cnt;
	}
	
	static void comb(int idx,int start) {
		
		if(idx==m) {
			int tmp = check();
			if(tmp>res) {
				res=tmp;
			}
			return;
		}
		
		for(int i=start,size=arr.size();i<size;i++) {
			numbers[idx]=arr.get(i);
			comb(idx+1,i+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		if(m<5) {
			System.out.println(0);
			System.exit(0);
		}
		m=m-5;
		
		numbers = new int[m];
		
		int let = 0; // antic추가할거
		let |= (int)Math.pow(2,'a'-96);
		let |= (int)Math.pow(2,'n'-96);
		let |= (int)Math.pow(2,'t'-96);
		let |= (int)Math.pow(2,'i'-96);
		let |= (int)Math.pow(2,'c'-96);
		
		int letmp = 0; // antic
		letmp |= (int)Math.pow(2,'a'-96);
		letmp |= (int)Math.pow(2,'n'-96);
		letmp |= (int)Math.pow(2,'t'-96);
		letmp |= (int)Math.pow(2,'i'-96);
		letmp |= (int)Math.pow(2,'c'-96);
		
		lang = new int[n];
		
		for(int i=0;i<n;i++) {
			String s = sc.next();
			int tmp=0; //lang에 넣을거 단어마다 없는거
			for(int j=0,size=s.length();j<size;j++) {
				char c = s.charAt(j);
				int t = (int)Math.pow(2, c-96);
				if((t&let)==0) {
					arr.add(t);
					let |= t;
				}
				if((t&letmp)==0) {
					tmp |= t;
				}
			}
			lang[i]=tmp;
		}
		m=Math.min(m,arr.size());
//		System.out.println(arr);
//		System.out.println(Arrays.toString(lang));
		comb(0,0);
		System.out.println(res);
	}

}