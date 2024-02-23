import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] arr;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int[] parents;
	static int cnt;
	
	static void make() {
		parents = new int[cnt+1];
		for(int i=2;i<cnt+1;i++) {
			parents[i]=i;
		}
	}
	
	static int find(int a) {
		if(a==parents[a]) return a;
		
		return parents[a]=find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a==b) return false;
		
		parents[a]=b;
		return true;
	}
	
	static void bfs(int x, int y, int num) {
		Deque<int []> dq = new ArrayDeque<int[]>();
		dq.offer(new int[] {x,y});
		arr[x][y]=num;
		
		while(!dq.isEmpty()) {
			int[] xy = dq.poll();
			
			for(int i=0;i<4;i++) {
				int xx = dx[i] + xy[0];
				int yy = dy[i] + xy[1];
				if((xx>=0)&&(xx<N)&&(yy>=0)&&(yy<M)&&(arr[xx][yy]==1)) {
					dq.offer(new int[] {xx,yy});
					arr[xx][yy]=num;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		// 섬 만들기
		cnt=1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==1) {
					bfs(i,j,++cnt);
				}
			}
		}
		
		
		List<int []> list = new ArrayList<int []>();
		//다리 만들기(가로)
		for(int i=0;i<N;i++) {
			int toy=-1;
			int fromy=0;
			int l=0;
			for(int j=0;j<M;j++) {
				if(arr[i][j]!=0) {
					fromy=j;
					if(toy!=-1) {
						if(l>=2) {
							list.add(new int[] {l,i,toy,i,fromy});
						}
					}
					toy=fromy;
					l=0;
				}else {
					l++;
				}
			}
		}
		
		
		//다리 만들기(세로)
		for(int i=0;i<M;i++) {
			int tox=-1;
			int fromx=0;
			int l=0;
			for(int j=0;j<N;j++) {
				if(arr[j][i]!=0) {
					fromx=j;
					if(tox!=-1) {
						if(l>=2) {
							list.add(new int[] {l,tox,i,fromx,i});
						}
					}
					tox=fromx;
					l=0;
				}else {
					l++;
				}
			}
		}
		

		//크루스칼알고리즘
		Collections.sort(list, new Comparator<int []>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		make();
		int count=0;
		int res=0;
		for(int i=0,size=list.size();i<size;i++) {
			int[] ar = list.get(i);
			if(union(arr[ar[1]][ar[2]],arr[ar[3]][ar[4]])) {
//				if(ar[1]==ar[3]) {
//					ar[1]--;
//					ar[3]++;
//				}
//				if(ar[2]==ar[4]) {
//					ar[2]--;
//					ar[4]++;
//				}
//				for(int j=ar[1]+1;j<ar[3];j++) {
//					for(int k=ar[2]+1;k<ar[4];k++) {
//						arr[j][k]=1;
//					}
//				}
				res+=ar[0];
				if(++count==cnt-2) break;
			}
		}
		
		if(count==cnt-2) {
			System.out.println(res);
		}else {
			System.out.println(-1);
		}
		
	}

}