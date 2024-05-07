package BFS_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P5014 {
    public static void main(String[] args) throws IOException {
        int cur; int next; int result=1;
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken()); //현재위치
        int g = Integer.parseInt(st.nextToken()); //도착위치
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[] dir = {u, -d};
        int[] building = new int[2*f+1];
        building[s]=1;
        q.offer(s);
        while(!q.isEmpty() && building[g]==0) {
            cur = q.poll();
            for(int i=0;i<2;i++) {
                next = cur+dir[i];
                if(next<=0 || next>f) {continue;}
                if(building[next]!=0) {continue;}
                building[next]=building[cur]+1;
                if(next==g) {result = building[next];}
                q.offer(next);
            }
        }
        if(building[g]!=0) {sb.append(result-1);}
        else {sb.append("use the stairs");}
        System.out.println(sb);
    }
}
