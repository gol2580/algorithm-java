package BFS_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P9466 {
    public static int n;
    public static int m;
    public static int result;
    public static int[] board;
    public static boolean[] visited_a;
    public static boolean[] visited_l;
    public static Queue<Integer> q = new LinkedList<>();
    public static int getGroup() {
        Arrays.fill(visited_l,false);
        int cur=0; int next=0; int start =0;
        while(!q.isEmpty()) {
            cur = q.poll();
            next = board[cur];
            visited_l[cur]=true; visited_a[cur]=true;
            //이미 그룹이 지어진 사람이거나 이번 or 저번에 방문했던 경우
            if(visited_l[next] ||  visited_a[next] || board[next]==next) {break;}
            //팀 형성
            if(visited_l[board[next]]==true) {
                start = board[next];
                q.offer(board[next]);
                while(true) {
                    cur = q.poll(); result--;
                    next = board[cur];
                    if(board[next]==start) { result--; return -1;}
                    q.offer(next);
                }
            }
            q.offer(next);
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        while(n-->0) {
            m = Integer.parseInt(br.readLine());
            result = m;
            st = new StringTokenizer(br.readLine()," ");
            board = new int[m]; visited_a=new boolean[m]; visited_l=new boolean[m];
            for(int i=0;i<m;i++) {board[i]=Integer.parseInt(st.nextToken())-1;}
            for(int i=0;i<m;i++) {
                if(board[i]==i) { result--; visited_a[i]=true; continue; } //
                //이미 혼자팀 or 저번 싸이클에서 방문
                if(visited_a[i]) { continue; }
                q.offer(i);
                getGroup();
            }
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }
}
