import java.io.*;
import java.util.*;

public class Main {
	
	static long[][] arr;
	static long[][] res;
	static String s;
	
	static void upmove() {
		for(int i=0;i<8;i++) {
			long tmp=0;
			ArrayList<Long> list = new ArrayList<>();
			for(int j=0;j<8;j++) {
				if(arr[j][i]==0) continue;
				
				if(arr[j][i]==tmp) {
					list.add(tmp*2);
					tmp=0;
				}else if(arr[j][i]!=tmp) {
					if(tmp!=0) {
						list.add(tmp);	
					}
					tmp=arr[j][i];
				}
			}
			
			if(tmp!=0) list.add(tmp);
			
			for(int j=0,size=list.size();j<size;j++) {
				res[j][i]=list.get(j);
			}
		}
	}
	
	static void downmove() {
		for(int i=0;i<8;i++) {
			long tmp=0;
			ArrayList<Long> list = new ArrayList<>();
			for(int j=7;j>=0;j--) {
				if(arr[j][i]==0) continue;
				
				if(arr[j][i]==tmp) {
					list.add(tmp*2);
					tmp=0;
				}else if(arr[j][i]!=tmp) {
					if(tmp!=0) {
						list.add(tmp);	
					}
					tmp=arr[j][i];
				}
			}
			
			if(tmp!=0) list.add(tmp);
			
			for(int j=0,size=list.size();j<size;j++) {
				res[7-j][i]=list.get(j);
			}
		}
	}
	
	static void leftmove() {
		for(int i=0;i<8;i++) {
			long tmp=0;
			ArrayList<Long> list = new ArrayList<>();
			for(int j=0;j<8;j++) {
				if(arr[i][j]==0) continue;
				
				if(arr[i][j]==tmp) {
					list.add(tmp*2);
					tmp=0;
				}else if(arr[i][j]!=tmp) {
					if(tmp!=0) {
						list.add(tmp);	
					}
					tmp=arr[i][j];
				}
			}
			
			if(tmp!=0) list.add(tmp);
			
			for(int j=0,size=list.size();j<size;j++) {
				res[i][j]=list.get(j);
			}
		}
	}
	
	static void rightmove() {
		for(int i=0;i<8;i++) {
			long tmp=0;
			ArrayList<Long> list = new ArrayList<>();
			for(int j=7;j>=0;j--) {
				if(arr[i][j]==0) continue;
				
				if(arr[i][j]==tmp) {
					list.add(tmp*2);
					tmp=0;
				}else if(arr[i][j]!=tmp) {
					if(tmp!=0) {
						list.add(tmp);	
					}
					tmp=arr[i][j];
				}
			}
			
			if(tmp!=0) list.add(tmp);
			
			for(int j=0,size=list.size();j<size;j++) {
				res[i][7-j]=list.get(j);
			}
		}
	}
	
    public static void main(String[] args) throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	arr = new long[8][8];
    	res = new long[8][8];
    	
    	for(int i=0;i<8;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0;j<8;j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	s=br.readLine();
    	if(s.equals("U")) {
    		upmove();
    	}else if(s.equals("D")) {
    		downmove();
    	}else if(s.equals("L")) {
    		leftmove();
    	}else {
    		rightmove();
    	}
    	
    	for(int i=0;i<8;i++) {
    		for(int j=0;j<8;j++) {
    			System.out.print(res[i][j]+" ");
    		}
    		System.out.println();
    	}
    }
}