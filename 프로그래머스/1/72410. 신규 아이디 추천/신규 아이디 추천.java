class Solution {
    public String solution(String new_id) {
        
        //1. 소문자로
        String answer = new_id.toLowerCase();
        
        //2. 특수문자 제거
        answer = answer.replaceAll("[^a-zA-Z0-9\\-_.]",  "");
        
        //3. 마침표2 -> 1
        answer = answer.replaceAll("\\.{2,}", ".");
        
        //4. 처음/끝 . 삭제
        if(answer.length()>0 && answer.charAt(0) == '.') answer = answer.substring(1);
        if(answer.length()>0 && answer.charAt(answer.length()-1) == '.') answer = answer.substring(0, answer.length()-1);
        
        //5. 빈문자열  -> a
        if(answer.length()==0) answer = "a";
        
        //6. 16자이상 -> 제거(15자까지)
        if(answer.length()>=16) answer = answer.substring(0,15);
        if(answer.charAt(answer.length()-1) == '.') answer = answer.substring(0,answer.length()-1);
        
        //7. 2자이하 -> 마지막 글자 반복
        if(answer.length()<=2){
            while(answer.length() < 3) answer += String.valueOf(answer.charAt(answer.length()-1));
        }
        
        return answer;
    }
}