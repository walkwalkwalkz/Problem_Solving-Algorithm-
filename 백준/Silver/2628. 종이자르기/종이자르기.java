import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		List<Integer> wList = new ArrayList<>();
		wList.add(0);
		List<Integer> hList = new ArrayList<>();
		hList.add(0);
		int t = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		
		for(int i=0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a==1) {
				wList.add(b);
			}else {
				hList.add(b);
			}
		}
		Collections.sort(wList);
		Collections.sort(hList);
		wList.add(w);
		hList.add(h);
		
		int res=0;
		for(int i=0, sizeW = wList.size()-1;i<sizeW;i++) {
			int tmpW = wList.get(i+1) - wList.get(i);
			for(int j=0, sizeH = hList.size()-1;j<sizeH;j++) {
				int tmpH = hList.get(j+1) - hList.get(j);
				int tmp = tmpW*tmpH;
				if(res<tmp) {
					res=tmp;
				}
			}
		}
		System.out.println(res);
	}

}