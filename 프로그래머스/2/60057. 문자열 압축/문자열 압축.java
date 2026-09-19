import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        for(int i=1; i<=s.length(); i++){ //압축 단위
            String tmp = "";
            int count = 1, result = 0;
            int j;
            // System.out.println(i);
            
            for(j=0; j+i<=s.length(); j+=i){
                if(j==0) {
                    tmp = s.substring(j,j+i); 
                    continue;
                }
                
                if(tmp.equals(s.substring(j,j+i))) count ++;
                else {
                    tmp = s.substring(j,j+i);
                    result += i;
                    if(count >= 2) result += String.valueOf(count).length();
                    count = 1;
                }
                // System.out.println(tmp + " " + result);
            }
            result += i;
            if(count >= 2) result += String.valueOf(count).length();
            
            if(j+i > s.length()){
                result += s.length() - j;
            }
            // System.out.println(result);
            answer = Math.min(answer, result);
        }
        
        return answer;
    }
}