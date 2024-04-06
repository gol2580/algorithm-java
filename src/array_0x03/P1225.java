package array_0x03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inStr = br.readLine().split(" ");
        String n1 = inStr[0]; String n2 = inStr[1];
        long cnt=0;
        for(int i=0;i<n1.length();i++) {
            for (int j=0;j<n2.length();j++) {
                cnt+=(n1.charAt(i)-'0')*(n2.charAt(j)-'0');
            }
        }
        System.out.println(cnt);
    }
}
