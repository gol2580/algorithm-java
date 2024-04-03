package array_0x03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = Integer.parseInt(br.readLine())*Integer.parseInt(br.readLine())*Integer.parseInt(br.readLine());
        String resultStr = String.valueOf(result);
        int[] numbers = new int[10];
        for(int i=0;i<resultStr.length();i++) {
            numbers[resultStr.charAt(i)-'0']++;
        }
        for(int i : numbers) {
            System.out.println(i);
        }
    }
}
