import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant); Arrays.sort(completion);
        // System.out.println(Arrays.toString(participant));
        // System.out.println(Arrays.toString(completion));
        
        for(int i=0; i<completion.length; i++){
            if(!participant[i].equals(completion[i])) return participant[i];
        }
        return participant[completion.length];
    }
}