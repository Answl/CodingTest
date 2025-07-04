class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int pSize = strToint(play_time);
        int aSize = strToint(adv_time);
        
        long[] initArr = new long[pSize+1];
        long[] sumArr = new long[pSize+1];
        for(String log : logs){
            String[] logArr = log.split("-");
            initArr[strToint(logArr[0])] ++;
            initArr[strToint(logArr[1])] --;
        }
        for(int i=1; i<=pSize; i++){
            initArr[i] += initArr[i-1];
            sumArr[i] = initArr[i] + sumArr[i-1];
        }
        
        long max = sumArr[aSize], idx = 0;
        for(int i=aSize; i<=pSize; i++){
            if(max < sumArr[i] - sumArr[i-aSize]) {
                max = sumArr[i] - sumArr[i-aSize];
                idx = i-aSize +1;
            }
        }
        return longToStr(idx);
    }
    private int strToint(String s){
        String[] sArr = s.split(":");
        return 3600 * Integer.parseInt(sArr[0])
            + 60 * Integer.parseInt(sArr[1])
            + Integer.parseInt(sArr[2]);
    }
    
    private String longToStr(long l){
        long h = l / 3600;
        long m = ( l % 3600 ) / 60;
        long s = l % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}