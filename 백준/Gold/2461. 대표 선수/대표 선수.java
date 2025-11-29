import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<int[]> students = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                students.add(new int[]{i, Integer.parseInt(st.nextToken())});
            }
        }
        Collections.sort(students, (a,b) -> a[1]-b[1]);
//        for(int[] student : students) System.out.println(Arrays.toString(student));

        int[] existTeam = new int[N];
        int start = 0, end = 0;
        existTeam[students.get(start)[0]] ++;

        long min = Long.MAX_VALUE;

        while(start <= end){
            //모두 있으면
            if(existAll(existTeam)){
//                System.out.println(Arrays.toString(existTeam));

                min = Math.min(min, students.get(end)[1]-students.get(start)[1]);
//                System.out.println(min + " " + start + " " + end);
                existTeam[students.get(start)[0]] --;
                start ++;
            }
            //없으면
            else {
                if(end == N*M-1) break;

                end ++;
                existTeam[students.get(end)[0]] ++;
            }
        }
        System.out.println(min);
    }
    private static boolean existAll(int[] existTeam){
        for(int team : existTeam){
            if(team == 0) return false;
        }
        return true;
    }
}