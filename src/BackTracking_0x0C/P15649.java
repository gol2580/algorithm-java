package BackTracking_0x0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15649 {
    static int N, M;
    static int[] arr;
    static boolean[] isUsed;
    static StringBuilder sb = new StringBuilder();
    static void findArr(int i) {
        if(i==M) {
            for (int j = 0; j < M; j++) sb.append(arr[j]).append(" ");
            sb.append('\n');
            return;
        }

        for (int j = 1; j <= N; j++) {
            if(!isUsed[j]) {
                arr[i] = j;
                isUsed[j]= true;
                findArr(i+1);
                isUsed[j]=false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        isUsed = new boolean[N+1];
        
        findArr(0);
        System.out.println(sb.toString());
    }
}
