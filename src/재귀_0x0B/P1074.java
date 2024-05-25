package 재귀_0x0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1074 {
    static int n, r, c;
    static int result = 0;
    static int i=0;
    static int visit(int N, int R, int C) {
        if(N==0) return 0;
        //절반 : (2^n)/2 = 2^(n-1)
        int half = 1<<(N-1);
        // 1사각형
        if(R<half && C<half) {return visit(N-1,R,C);}
        // 2사각형
        if(R<half && C>=half) {return half*half + visit(N-1,R,C-half);}
        // 3사각형
        if(R>=half && C<half) {return half*half*2 + visit(N-1,R-half,C);}
        // 4사각형
        return half*half*3 + visit(N-1,R-half,C-half);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        System.out.println(visit(n,r,c));
    }
}
