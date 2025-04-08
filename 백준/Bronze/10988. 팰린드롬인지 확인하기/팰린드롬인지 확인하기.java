import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArr = br.readLine().toCharArray();
        
        int check = 1;
        for(int i=0; i<charArr.length; i++){
            if(charArr[i]!=charArr[charArr.length-i-1]){
                check = 0;
                break;
            }
        }
        
        System.out.println(check);
    }
}