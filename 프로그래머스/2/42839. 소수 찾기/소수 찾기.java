import java.util.*;
class Solution {
    public Set<Integer> set = new HashSet<>();
    public int answer = 0;
    public int solution(String numbers) {
        dfs(numbers, "", new boolean[numbers.length()]);
        
        return answer;
    }
    public void dfs(String numbers, String num, boolean[] visited){
        if(!num.equals("")) {
            int n = Integer.parseInt(num);
            if(!set.contains(n) && sosu(n)){
                //System.out.println(num);
                answer++;
                set.add(n);
            }
        }
        //if(sosu(String.reverse(num))) answer++;
        
        for(int i=0; i<numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(numbers, num+numbers.charAt(i), visited);
                visited[i] = false;
            }
        }
    }
    
    public boolean sosu(int n){
        if(n <= 1) return false;
        for(int i=2; i<=n/2; i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}