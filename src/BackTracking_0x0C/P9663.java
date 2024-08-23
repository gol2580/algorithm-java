package BackTracking_0x0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9663 {
    static int N;
    static boolean[] isUsedR, isUsedD1, isUserD2;
    static int result=0;
    static void getResult(int c) {
        if(c==N) {
            result++;
            return;
        }
        for (int r = 0; r < N; r++) {
            if(!isUsedR[r] && !isUsedD1[c+r] && !isUserD2[c-r+N-1]) {
                isUsedR[r] = true;
                isUsedD1[c + r] = true;
                isUserD2[c - r + N-1] = true;
                getResult(c+1);
                isUsedR[r] = false;
                isUsedD1[c + r] = false;
                isUserD2[c - r + N-1] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        isUsedR = new boolean[N];
        isUsedD1 = new boolean[N+N]; isUserD2 = new boolean[N+N+1];

        getResult(0);
        System.out.println(result);
    }
}
