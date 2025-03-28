import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int dice[] = new int[3];

        for(int i=0; i<3; i++){
            dice[i] = Integer.parseInt(st.nextToken());
        }
        
        int money;
        if(dice[0]==dice[1] && dice[2]==dice[1]){
            money = 10000 + dice[1]*1000;
        }else if((dice[0]==dice[1] && dice[2]!=dice[1]) || (dice[0]!=dice[1] && dice[2]==dice[1])){
            money = 1000 + dice[1]*100;
        }else if(dice[0]!=dice[1] && dice[2]==dice[0]){
            money = 1000 + dice[2]*100;
        }else{
            int maxDice = dice[0];
            for(int i=1;i<3;i++){
                if(maxDice<dice[i]){
                    maxDice=dice[i];
                }
            }
            money = maxDice*100;
        }
        
        System.out.println(money);
    }
}