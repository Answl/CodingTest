import java.util.*;
class Solution {
    
    static List<String> answer = new ArrayList<>();
    static boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        
        Arrays.sort(tickets, (a,b)->a[1].compareTo(b[1]));
        visited = new boolean[tickets.length];
        
        answer.add("ICN");
        dfs("ICN", 1, tickets);
        
        int i =0;
        String[] answer2 = new String[answer.size()];
    
        for(String a : answer){
            answer2[i++] = a;
        }
        
        return answer2;
    }
    private boolean dfs(String start, int count, String[][] tickets){
        if(count == tickets.length+1) {
            System.out.println(answer);
            return true;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(visited[i]) continue;
            if(!tickets[i][0].equals(start)) continue;
            
            visited[i] = true;
            answer.add(tickets[i][1]);
            
            if(dfs(tickets[i][1], count+1, tickets)){
                return true;
            }
            
            visited[i] = false;
            answer.remove(answer.size()-1);
        } 
        return false;
    }
}