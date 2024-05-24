package 재귀_0x0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1074 {
    static int N, r, c;
    static int result = 0;
    static int i=0;
    static void visit(int R, int C) {
        result++; i++;
        if(R==r && C==c) return;
        if((i%4)==1) visit(R,C+1);
        if((i%4)==2) visit(R-1, C-1);
        if((i%4)==3) visit(R,C+1);
        if((i%4)==0) {

        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        visit(0,0);
        System.out.println(result);
    }
}
