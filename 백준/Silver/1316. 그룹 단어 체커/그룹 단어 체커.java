import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;

        for(int i=0; i<N; i++){
            boolean isGroupWord = true;

            String st = br.readLine();
            boolean[] isVisited = new boolean[26];
            for(int j=0; j<st.length(); j++){
                if(j>0 && st.charAt(j)==st.charAt(j-1)){
                    continue;
                }
                if(isVisited[st.charAt(j)-'a']){
                    isGroupWord = false;
                    break;
                }
                isVisited[st.charAt(j)-'a']=true;
            }
            if(isGroupWord) count+=1;
            
        }
        System.out.println(count);
    }
}