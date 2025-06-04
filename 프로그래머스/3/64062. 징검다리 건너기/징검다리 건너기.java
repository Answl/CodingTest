class Solution {
    public int solution(int[] stones, int k) {
        //try 1
//         int count = 0; int answer = 0;
//         while(true){
//             answer ++;
//             for(int i = 0 ; i<stones.length ; i++ ){
//                 stones[i] -= 1;
//                 if(stones[i] <= 0) count ++;
//                 else count = 0;
                
//                 if(count == k) return answer;
//             }
//         }
        
        //try 2
        // int min = Integer.MAX_VALUE;
        // for(int i=0; i+k <= stones.length; i++){
        //     int max = Integer.MIN_VALUE;
        //    for(int j = i; j < i+k; j++){
        //        max = Math.max(max, stones[j]);
        //    }
        //     min = Math.min(min, max);
        // }
        // return min;
        
        //try 3
        // int min = Integer.MAX_VALUE; 
        // for(int i = 0 ; i+k <= stones.length; ){
        //     int max = Integer.MIN_VALUE;
        //     int idx = -1;
        //     for(int j = i; j < i+k; j++) {
        //         if(max < stones[j]){
        //             idx = j;
        //             max = stones[j];
        //         }
        //     }
        //     min = Math.min(min, max);
        //     i = idx + 1;
        // }
        // return min;
        
        //try 4
        int end = 1;
        int start = 200000000;
            
        for(int stone : stones){
            end = Math.max(end, stone);
            start = Math.min(start, stone);
        }
        
        //연속 k여야함. 초과하면 실패. 미만이면 성공
        //성공하면 그보다 큰 값 되는지 보기
        //실패하면 작은 값 보기
        // 코테 화이팅!!!
        start -= 1;
        int answer = 0;
        while(start <= end){
            int mid = (start + end) / 2;
            int count = 0;
            for(int stone : stones) {
                
                if(stone <= mid) {
                    count ++;
                    if(count >= k) break;
                }
                else {
                    count = 0;
                }
            }
            if(count < k){ //성공
                start = mid + 1;
                answer = start;
            } else { //실패
                end = mid - 1;
            }
        }
        return answer;
    }
}