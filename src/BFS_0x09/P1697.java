package BFS_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1697 {
    public static void main(String[] args) throws IOException {
        int[] dist = new int[100005];
        int[] dx = new int[3]; dx[0]=1; dx[1]=-1;
        Queue<Integer> q = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
        dist[n]=1; //시작점을 1로 두자
        q.offer(n);
        while(dist[m]==0) {
            int cur = q.poll();
            dx[2]=cur;
            for(int dir=0;dir<3;dir++) {
                int nx = cur+dx[dir];
                if(nx>=100005 || nx<0) {continue;} //범위넘어감
                if (dist[nx] != 0) {continue;} //이미 방문함
                dist[nx] = dist[cur]+1;
                q.offer(nx);
            }
        }
        System.out.println(dist[m]-1);
    }
}
