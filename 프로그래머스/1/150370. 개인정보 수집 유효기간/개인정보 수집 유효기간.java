import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {

        List<Integer> list = new ArrayList<>();
        
        HashMap<String, Integer> map = new HashMap<>();
        for(String term : terms){
            map.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1]));
        }
        
        int i=0;
        for(String p : privacies){
            i++;
            
            String f = p.split(" ")[0];
            int y = Integer.parseInt(f.split("\\.")[0]);
            int m = map.get(p.split(" ")[1]) + Integer.parseInt(f.split("\\.")[1]);
            if(m > 12){
                if(m % 12 == 0){
                    y = y + (m / 12) - 1;
                    m = m - (12 * ((m / 12) - 1));
                }
                else {
                    y += m / 12;
                    m = m % 12;
                }
            }
            
            int d = Integer.parseInt(f.split("\\.")[2]);
            
            
            int todayY = Integer.parseInt(today.split("\\.")[0]);
            int todayM = Integer.parseInt(today.split("\\.")[1]);
            int todayD = Integer.parseInt(today.split("\\.")[2]);
            
            // System.out.println(y + " " + m + " " + d);
            // System.out.println(todayY + " " + todayM + " " + todayD);
            if(todayY < y) continue;
            else if(todayY > y){
                list.add(i);
                continue;
            }
            
            if(todayM < m) continue;
            else if(todayM > m){
                list.add(i);
                continue;
            }
            
            if(todayD < d) continue;
            else if(todayD >= d){
                list.add(i);
                continue;
            }
        }
        
        int[] answer = new int[list.size()];
        int idx = 0;
        for(int l : list){
            answer[idx++] = l;
        }
        return answer;
    }
}