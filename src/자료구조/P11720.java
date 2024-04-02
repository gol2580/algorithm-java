package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String inNum = br.readLine();
        int result=0;

        for(int i=0;i<n;i++) {
            result+=inNum.charAt(i)-'0';
        }
        System.out.println(result);
    }
}
