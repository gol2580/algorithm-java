package array_0x03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        int[] arrs = new int[1000000];
        for(int i=0;i<n;i++) {
            arrs[arr[i]]++;
            if(arr[i]>=x) {continue;}
            if(arrs[x-arr[i]]==1) {cnt++;}
        }
        System.out.println(cnt);
    }
}
