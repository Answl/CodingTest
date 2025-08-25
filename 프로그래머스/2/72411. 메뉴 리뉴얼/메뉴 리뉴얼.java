import java.util.*;

class Solution {
    // src
    char[] src; int srcLen;
    // tgt
    StringBuilder sb = new StringBuilder(); int tgtLen;
    // 조합의 빈도수
    HashMap<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for(int i=0; i<course.length; i++){
            map.clear(); 
            tgtLen = course[i];
            
            for(int j=0; j<orders.length; j++){
                src = orders[j].toCharArray();
                Arrays.sort(src); // 미리 정렬
                
                srcLen = src.length;
                sb.setLength(0);
                
                if(tgtLen <= srcLen) comb(0, 0);
            }
            
            // map의 max값 찾아서 answer에 추가 (중복 가능)
            if(!map.isEmpty()){
                int max = Collections.max(map.values());
                if(max > 1){
                    for(String key : map.keySet()){
                        if(map.get(key) == max) answer.add(key);
                    }
                }
            }
        }
        
        String[] ret = answer.toArray(new String[0]);
        Arrays.sort(ret);
        return ret;
    }
    
    public void comb(int srcIdx, int tgtIdx){
        // 기저 조건
        if(tgtIdx == tgtLen){
            //completion
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        if(srcIdx == srcLen) return;
        
        sb.append(src[srcIdx]);
        comb(srcIdx+1, tgtIdx+1); // 선택 O
        sb.setLength(sb.length()-1);
        
        comb(srcIdx+1, tgtIdx); //선택 X   
    }
    
}