import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // A = 65, a = 97
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int WSize = Integer.parseInt(st.nextToken());
        int SSize = Integer.parseInt(st.nextToken());

        String W = br.readLine(); //52개
        int[] existingAlpha = new int[52];

        for(int i=0; i<W.length(); i++){
            existingAlpha[num(W.charAt(i))]++;
        }

        String S = br.readLine();
        int count = 0;

        int left = 0, right = left + WSize-1;

        //초기
        for(int i=left; i<=right; i++){
            existingAlpha[num(S.charAt(i))]--;
        }

        boolean noCountFlag = false;
        while (true) {
            for(int e: existingAlpha){
                if(e<0) {
                    noCountFlag = true;
                    break;
                } else noCountFlag = false;
            }

            if(!noCountFlag) count++;

            //다음 단계로 넘어가기
            existingAlpha[num(S.charAt(left))]++;
            left ++;
            right ++;

            if(right>=SSize) break;
            existingAlpha[num(S.charAt(right))]--;
        }

        System.out.println(count);
    }

    private static int num(char tmpChar){
        //소문자
        if('a' <= tmpChar && tmpChar <= 'z') return tmpChar-'A'-6;
        //대문자
        else return tmpChar -'A';
    }
}