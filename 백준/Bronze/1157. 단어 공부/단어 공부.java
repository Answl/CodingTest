import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String st = br.readLine().toUpperCase();
        int[] arr_ch = new int[26];

        for(char ch : st.toCharArray()){
            arr_ch[ch-'A'] += 1;
        }

        int max=0;
        int maxChar=0;
        for(int i=0; i<26; i++){
            if(max < arr_ch[i]){
                max = arr_ch[i];
                maxChar = i;
            }
        }

        boolean isSeveral = false;
        for(int i=maxChar+1; i<26; i++){
            if(max == arr_ch[i]){
                isSeveral = true;
                System.out.println("?");
                break;
            }
        }

        if(!isSeveral) System.out.println((char)(maxChar+'A'));
    }
}
