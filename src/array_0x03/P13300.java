package array_0x03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P13300 {
    public static void main(String[] args) throws IOException {
        int rooms=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        String[] stdStr = new String[2];
        int n = Integer.parseInt(str[0]); int k = Integer.parseInt(str[1]);
        int[] students = new int[12];
        for(int i=0;i<n;i++) {
            stdStr = br.readLine().split(" ");
            if(stdStr[0].equals("0")) {
                students[Integer.parseInt(stdStr[1])*2-2]++; }
            else {students[Integer.parseInt(stdStr[1])*2-1]++;}
        }
        for(int i=0;i<12;i++) {
            if(students[i]==0) {continue;}
            rooms+=(int)Math.ceil((double)students[i]/(double)k);
        }
        System.out.println(rooms);
    }
}
