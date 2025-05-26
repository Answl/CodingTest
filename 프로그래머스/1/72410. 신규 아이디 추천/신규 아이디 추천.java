class Solution {
    public String solution(String new_id) {
        String idChar = "0123456789abcdefghijgklmnopqrstuvwxyz-_.";
        //1. 소문자로
        String step1 = new_id.toLowerCase();
        
        //2. idChar 제거
        String step2 = "";
        for(int i=0; i<step1.length(); i++){
            String s1 = step1.substring(i,i+1);
            if(idChar.contains(step1.substring(i,i+1))) step2 += s1;
        }
        
        //3. ..가 연속이면 하나로 치환
        String step3 = step2.replaceAll("\\.{2,}", ".");
        
        //4. .가 처음이나 마지막에 있으면 제거
        String step4 = "";
        if(step3.charAt(0) !='.') step4 += step3.substring(0,1);
        if(step3.length() >= 3) step4 += step3.substring(1,step3.length()-1);
        if(step3.length() >= 2 && step3.charAt(step3.length()-1) != '.') step4 += step3.substring(step3.length()-1,step3.length());
        
        //5. 빈문자열이면 a 대입
        String step5 = (step4.length() == 0)? "a" : step4;
        
        //6. 16자 이상이면 제거, 마지막에 .이면 제거
        String step6 = "";
        if(step5.length() >= 16){
            if(step5.charAt(14)=='.') step6 += step5.substring(0, 14);
            else step6 += step5.substring(0, 15);
        }else step6 += step5;
        
        //7. 2자 이하면 마지막 문자를 3이 될때까지 붙이기
        while(step6.length() < 3){
            step6 += step6.substring(step6.length()-1, step6.length());
        }
        return step6;
    }
}