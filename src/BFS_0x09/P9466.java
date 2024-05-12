package BFS_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P9466 {
    public static int n;
    public static int m;
    public static int result;
    public static int[] board;
    public static int[] grouped;
    public static Queue<Integer> q = new LinkedList<>();
    public static int getGroup(int start) {
        int members=0;
        int cur=0; int next=0;
        while(!q.isEmpty()) {
            cur = q.poll(); members++;
            next = board[cur];
            if(board[cur]==-1) {break;}
            if(cur==next) {break;}
            if(next==start) { result-=members; return -1; }
            board[cur]=-1;
            q.offer(next);
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        while(n-->0) {
            m = Integer.parseInt(br.readLine());
            result = m;
            st = new StringTokenizer(br.readLine()," ");
            board = new int[m]; grouped = new int[m];
            for(int i=0;i<m;i++) {board[i]=Integer.parseInt(st.nextToken())-1;}
            for(int i=0;i<m;i++) {
                if(board[i]==i) { result--; board[i]=-1; continue; }
                if(board[i]==-1) { continue; }
                q.offer(i);
                getGroup(i);
            }
            System.out.println(result);
        }
    }
}
