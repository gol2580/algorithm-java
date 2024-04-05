package array_0x03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine(); String str2 = br.readLine();
        int[] al1 = new int[26]; int[] al2 = new int[26];
        int cnt=0;

        for(int i=0;i<str1.length();i++) {
            al1[str1.charAt(i)-'a']++;
            }
        for(int i=0;i<str2.length();i++) {
            al2[str2.charAt(i) - 'a']++;
        }

            for(int i=0;i<26;i++) {
            if(al1[i]!=al2[i]) {cnt+=Math.abs(al1[i]-al2[i]);}
        }
        System.out.println(cnt);
    }
}
