package BFS_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P13549 {
    static int n, m, cur, next;
    static int[] distance = new int[100001];
    static Queue<Integer> q = new LinkedList<>();
    static int[] dir = new int[3];
    static boolean end = false;
    static void BFS() {
        while(!end) {
            cur = q.poll();
            if(cur==m) {
                System.out.println(distance[cur]-1);
                end = true;
                break;}
            dir[0] = cur;
            for (int d = 0; d < 3; d++) {
                next = cur + dir[d];

                if(next>=100001 || next<0) {continue;}
                if(distance[next]!=0) {continue;}
                if(d!=0) {
                    q.offer(next);
                    distance[next] = distance[cur]+1;
                }
                else {
                    q.offer(next);
                    q.offer(cur);
                    distance[next] = distance[cur];
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        dir[1]=-1; dir[2] = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        if(n==m) {
            System.out.println(0);
        } else {
            q.offer(n); distance[n] = 1;
            BFS();
        }
    }
}
