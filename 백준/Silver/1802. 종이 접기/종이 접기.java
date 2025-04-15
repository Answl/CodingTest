import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            String st = br.readLine();

            int[] intArray = new int[st.length()];
            for(int i=0; i<st.length(); i++){
                intArray[i] = st.charAt(i) - '0';
            }

            int left=0, right=intArray.length-1;
            boolean isFold = true;
            while(left<right && isFold){
                for(int i=left, j=right; i<right/2; i++,j--){
                    // System.out.println("i : "+i);
                    // System.out.println("j : "+j);
                    // System.out.println("isFold : "+isFold);
                    if(intArray[i] + intArray[j] != 1){
                        isFold = false;
                        // System.out.println("isFold : "+isFold);
                        break;
                    }
                }
                right=(int)right/2 -1;
                // System.out.println("right : "+right);
            }
            System.out.println(isFold? "YES": "NO");
        }
    }
}