package array_0x03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] alphabet = new int[26];
        int idx=0;
        for(int i=0;i<s.length();i++) {
            idx = s.charAt(i)-'a';
            alphabet[idx]++;
        }

        for(int i : alphabet) {
            System.out.print(i+" ");
        }
    }
}
