package array_0x03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int cnt=0;
        String[] strArr = br.readLine().split(" ");
        int v = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        for(int i=0;i<n;i++) {
            if(arr[i]==v) {cnt++;}
        }
        System.out.println(cnt);

    }
}
