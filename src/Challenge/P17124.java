package Challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P17124 {
    static int N, M, result;
    static long[] arrN, arrM;

    static void searchNearest(long target) {
        //arrM[index] : target이랑 같거나 가장 가까운 큰 값
        int lIdx = 0;
        int index = Arrays.binarySearch(arrM, target);

        //같은 값이 없는 경우
        if (index < 0) index = (index + 1) * (-1);

        if (index >= M) index--;
        if(index>0) lIdx = index-1;

        long lDiff = Math.abs(target - arrM[index]);
        long sDiff = Math.abs(target - arrM[lIdx]);

        //등호 주의 : 같은 경우에도 더 작은 값인 arrM[lIdx] 선택
        if (lDiff >= sDiff) result += arrM[lIdx];
        else result += arrM[index];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            result=0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arrN = new long[N];
            arrM = new long[M];
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) arrN[j] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) arrM[j] = Integer.parseInt(st.nextToken());

            Arrays.sort(arrM);
            for (int j = 0; j < N; j++) searchNearest(arrN[j]);
            System.out.println(result);
        }
    }
}
