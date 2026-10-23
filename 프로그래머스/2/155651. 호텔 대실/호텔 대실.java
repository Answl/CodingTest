class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] time = new int[1451];
        
        for(int i=0; i<book_time.length; i++){
            time[Integer.parseInt(book_time[i][0].split(":")[0]) * 60 + 
                    Integer.parseInt(book_time[i][0].split(":")[1])] ++;
            time[Integer.parseInt(book_time[i][1].split(":")[0]) * 60 + 
                    Integer.parseInt(book_time[i][1].split(":")[1]) + 10] --;
        }
        
        int max = 0;
        for(int t : time){
            answer += t;
            max = Math.max(answer, max);
        }
        
        
        return max;
    }
}