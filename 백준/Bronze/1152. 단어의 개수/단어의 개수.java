import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = (br.readLine()).split(" ");

        if(str.length==0){
            System.out.println(str.length);
        }else{
            System.out.println((str[0]!="")?str.length:str.length-1);
        }
    }
}