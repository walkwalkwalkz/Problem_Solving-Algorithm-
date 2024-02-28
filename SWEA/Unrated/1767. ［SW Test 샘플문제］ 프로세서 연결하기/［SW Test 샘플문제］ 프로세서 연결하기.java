import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] arr;
	static ArrayList<int[]> cells;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static int cntCore,cntLine;
	
	static void dfs(int depth, int core, int line) {
		if(cntCore>core+cells.size()-depth) return;
		
		if(depth==cells.size()) {
			if(core>cntCore) {
				cntCore=core;
				cntLine=line;
			}else if(core==cntCore) {
				if(line<cntLine) cntLine=line;
			}
			return;
		}
		
		int[] cell = cells.get(depth);
		for(int i=0;i<4;i++) {
			int x = cell[0];
			int y = cell[1];
			int j=1;
			int flag=0;
			while((0<=(x+dx[i]*j))&&(N>(x+dx[i]*j))&&(0<=(y+dy[i]*j))&&(N>(y+dy[i]*j))){
				if(arr[x+dx[i]*j][y+dy[i]*j]==1) {
					flag=1;
					break;
				}
				arr[x+dx[i]*j][y+dy[i]*j]=1;
				j+=1;
			}
			
			if(flag==0) {
				dfs(depth+1,core+1,line+j-1);
				
				j-=1;
				while(j>=1){
					arr[x+dx[i]*j][y+dy[i]*j]=0;
					j-=1;
				}
			}
			else {
				j-=1;
				while(j>=1){
					arr[x+dx[i]*j][y+dy[i]*j]=0;
					j-=1;
				}
				
				dfs(depth+1,core,line);
			}
			
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		
		int tc = Integer.parseInt(st.nextToken());
		for(int t=1;t<=tc;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			arr = new int[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//cell의 위치를 arraylist에 저장
			cells = new ArrayList<>();
			for(int i=1;i<N-1;i++) {
				for(int j=1;j<N-1;j++) {
					if(arr[i][j]==1) {
						cells.add(new int[] {i,j});
					}
				}
			}
			
			cntCore=0;
			cntLine=0;
			dfs(0,0,0);
			System.out.println("#"+t+" "+cntLine);
		}
		
	}

}