package 재귀_0x0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1780 {
    static int[][] paper;
    static int zero = 0; static int p_one=0; static int m_one=0;
    static boolean isSame(int x, int y, int n) {
        int a = paper[x][y];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(a!=paper[i+x][j+y]) return false;
            }
        }
        return true;
    }
    static void cut(int x, int y, int n) {
        //시작점(x, y)에서  n * n 배열이 모두 일치하지 않으면 9등분하고, 각 숫자를 나타내는 종이의 개수를 더하는 함수
        int height = n/3;
        if(isSame(x,y,n)) {
            if(paper[x][y]==0) zero++;
            if(paper[x][y]==1) p_one++;
            if(paper[x][y]==-1) m_one++;
            return;
        }
        //base condition
        if(n==1) {
            if(paper[x][y]==0) zero++;
            if(paper[x][y]==1) p_one++;
            if(paper[x][y]==-1) m_one++;
            return;
        }
        for (int i = 0; i < n; i+=height) {
            for (int j = 0; j < n; j+=height) {
                cut(x+i,y+j,height);
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < n; j++) {
                paper[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        cut(0,0,n);
        System.out.println(m_one);
        System.out.println(zero);
        System.out.println(p_one);
    }
}
