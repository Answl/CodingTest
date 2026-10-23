import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Arrays.sort(book_time, (a,b)->{
            return a[0].compareTo(b[0]);
        });
        
        int[][] book = new int[book_time.length][2];
        for(int i=0; i<book_time.length; i++){
            for(int j=0; j<2; j++){
                book[i][j] = Integer.parseInt(book_time[i][j].split(":")[0]) * 60 + 
                    Integer.parseInt(book_time[i][j].split(":")[1]);
            }
        }
        
        //System.out.println(Arrays.deepToString(book));
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<book_time.length; i++){
            boolean flag = false;
            for(int j=0; j<list.size(); j++){
                if(book[i][0]>=list.get(j)+10){
                    list.set(j, book[i][1]);
                    flag = true;
                    break;
                } 
            }
            if(!flag) list.add(book[i][1]);
        }
        
        return list.size();
    }
}