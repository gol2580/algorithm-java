package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inStr = br.readLine().split(" ");
        int n = Integer.parseInt(inStr[0]); int x = Integer.parseInt(inStr[1]);

        String[] strNums = br.readLine().split(" ");
        for(int i=0;i<n;i++) {
            int num = Integer.parseInt(strNums[i]);
            if(num<x) {
                System.out.print(num+" ");
            }
        }
    }
}
