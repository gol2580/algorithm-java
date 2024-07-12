package sort_0x0E;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        int[] nArr = new int[n]; int[] mArr = new int[m];
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n; i++) nArr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < m; i++) mArr[i] = Integer.parseInt(st.nextToken());

        int nPtr = 0; int mPtr=0;
        for (int i = 0; i < n+m; i++) {
            if(nPtr<n && mPtr<m) {
                if (nArr[nPtr] <= mArr[mPtr]) sb.append(nArr[nPtr++]).append(" ");
                else sb.append(mArr[mPtr++]).append(" ");
            } else {
                if (nPtr>=n) sb.append(mArr[mPtr++]).append(" ");
                else sb.append(nArr[nPtr++]).append(" ");
            }
        }
        System.out.println(sb);
    }
}
