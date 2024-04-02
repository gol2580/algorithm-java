package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inNum = Integer.parseInt(br.readLine());
        int result=1;
        for(int i=1;2*i<=inNum;) {
            i*=2;
            result=i;
        }
        System.out.println(result);
    }
}
