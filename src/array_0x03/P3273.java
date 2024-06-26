package array_0x03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P3273 {
    public static void main(String[] args) throws IOException {
        int cnt=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split(" "); int[] arr = new int[n];
        int x = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        Arrays.sort(arr);

        int start = 0; int end = n-1;
        while(start<end) {
            int sum = arr[start]+arr[end];
            if(sum==x) {cnt++; start++;}
            else if(sum<x) {start++;}
            else if(sum>x) {end--;}
        }
        System.out.println(cnt);
    }
}
