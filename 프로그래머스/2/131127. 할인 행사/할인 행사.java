import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        int sum = 0;
        
        Map<String, Integer> map = new HashMap<>(); 
        for(int i=0; i<number.length; i++){
            map.put(want[i], number[i]);
            sum += number[i];
        }
        
        //System.out.println(map);
        
        for(int i=0; i<sum; i++){
            if(map.get(discount[i]) != null){
                map.put(discount[i], map.get(discount[i])-1);
            }
        }
        
        //System.out.println(map);
        
        for(int i=sum-1; i<discount.length; i++){
            if(i != sum-1){
                if(map.get(discount[i]) != null){
                    map.put(discount[i], map.get(discount[i])-1);
                }
                if(map.get(discount[i-sum]) != null){
                    map.put(discount[i-sum], map.get(discount[i-sum])+1);
                }
            }
            
            boolean flag = false;
            for(int col : map.values()){
                if(col > 0) {
                    flag = true;
                    break;
                }
            }
            
            if(!flag) answer ++;
        }
    
        return answer;
    }
}