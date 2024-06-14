package DP_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a= new int[100004]; int[] d = new int[100004];

        //default
        d[0] = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            d[i] = d[i-1]+a[i];
        }

        while(m--!=0) {
            int i, j;
            st = new StringTokenizer(br.readLine(), " ");
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            System.out.println(d[j]-d[i-1]);
        }

    }
}
