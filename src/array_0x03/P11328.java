package array_0x03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Vector;

public class P11328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] alphabet1 = new int[26];
        int[] alphabet2 = new int[26];
        String[] result = new String[n];

        Vector<String> str = new Vector<>();
        for(int i=0;i<n;i++) {
            String[] inStr = br.readLine().split(" ");
            str.add(inStr[0]); str.add(inStr[1]);
        }
        for(int i=1;i<=n;i++) {
            String s1 = str.get(i*2-2); String s2 = str.get(i*2-1);
            for(int j=0;j<s1.length();j++) {
                alphabet1[s1.charAt(j)-'a']++;
            }
            for(int j=0;j<s2.length();j++) {
                alphabet2[s2.charAt(j)-'a']++;
            }
            if(Arrays.equals(alphabet1,alphabet2)) {
                result[i-1]="Possible";
            } else {
                result[i-1]="Impossible";
            }
            alphabet1=new int[26]; alphabet2 = new int[26];
        }
        for(String resStr : result) {
            System.out.println(resStr);
        }
    }
}
