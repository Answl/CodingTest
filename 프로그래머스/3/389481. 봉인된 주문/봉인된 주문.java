import java.util.*;
class Solution {
    public String solution(long n, String[] bans) {
        String answer = "";
        
        List<Long> banList = new ArrayList<>();
        for(String ban : bans){
            int size = ban.length();
            long word = 0;
            for(int i=0; i<size; i++){
                word += (ban.charAt(i) - 'a' + 1) * Math.pow(26, (size-i-1));
            }
            banList.add(word);
        }
        //System.out.println(banList);
        Collections.sort(banList);
        //System.out.println(banList);
        
        
        for(Long banL : banList){
            if(n >= banL) n++;
        }
        
        //n = 52;
        while(n > 0){
            
            long na = (n-1) % 26;
            n = (n-1) / 26;
            
            answer = (char)(na + 97) + answer;
        
        }
        return answer;
    }
}
