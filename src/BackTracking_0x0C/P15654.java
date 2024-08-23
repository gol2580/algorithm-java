package BackTracking_0x0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15654 {
    static int N, M;
    static int[] list, arr;
    static boolean[] isUsed;
    static StringBuilder sb = new StringBuilder();
    static void backtracking(int cur) {
        if(cur==M) {
            for (int i = 0; i < M; i++) sb.append(arr[i]).append(" ");
            sb.append('\n');
            return;
        }
        for (int i = 0; i < N; i++) {
            if(!isUsed[i]) {
                isUsed[i] = true;
                arr[cur] = list[i];
                backtracking(cur+1);
                isUsed[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        list = new int[N]; isUsed = new boolean[N];

        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++) list[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(list);
        backtracking(0);
        System.out.println(sb);
    }
}
