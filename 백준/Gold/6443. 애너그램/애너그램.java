import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static List<String> word=new ArrayList<>();
	static List<Character> answer;
	static StringBuilder sb;
	static Map<Character,Integer> dic;
	static Character[] ks;
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

	    int n=Integer.parseInt(br.readLine());

	    for(int t=0; t<n; t++){
	        List<Character> tmp=new ArrayList<>();
	        String s = br.readLine();
	        for(int j=0; j<s.length(); j++){
	            tmp.add(s.charAt(j));
	        }

	        Collections.sort(tmp);
	        String string="";
	        for (Character c : tmp) {
	            string+=Character.toString(c);
	        }
	        String word_s = string;
//	        word.add(string);
//	    }
//
//	    for (String word_s : word) {
	    	sb=new StringBuilder();
	        dic=new HashMap<>();
	        for(int i=0; i<word_s.length(); i++){
	            if(dic.containsKey(word_s.charAt(i))){
	                dic.put(word_s.charAt(i),dic.get(word_s.charAt(i))+1);
	            }
	            else{
	                dic.put(word_s.charAt(i),1);
	            }

	        }

	        answer=new ArrayList<>();
	        ks = dic.keySet().toArray(new Character[dic.size()]);
	        Arrays.sort(ks);
	        permu(0,word_s.length());
	        System.out.print(sb);
	    }

//	    System.out.print(sb);


	}

	static public void permu(int cnt,int limit){
	    if(cnt==limit){
	        for (Character c : answer) {
	            sb.append(c);
	        }
	        sb.append("\n");
	        return;
	    }

	    for (Character c : ks) {
	        if(dic.get(c)==0){
	            continue;
	        }

	        dic.put(c,dic.get(c)-1);
	        answer.add(c);
	        permu(cnt+1,limit);
	        dic.put(c,dic.get(c)+1);
	        answer.remove(answer.size()-1);

	    }


	}

}