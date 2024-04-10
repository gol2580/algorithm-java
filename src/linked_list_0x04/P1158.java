package linked_list_0x04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class P1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inStr = br.readLine().split(" ");
        int n = Integer.parseInt(inStr[0]); int k = Integer.parseInt(inStr[1]);
        int[] result = new int[n];
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<n;i++) {
            list.add(i+1);
        }
        ListIterator<Integer> iter = list.listIterator();
        for(int i=0;i<n;i++) {
            for(int j=0;j<k;j++) {
                if(j==(k-1) && iter.hasNext()) {result[i]=iter.next(); break;}
                else if(j==(k-1) && !iter.hasNext()) {iter=list.listIterator(); result[i]=iter.next(); break;}
                if(iter.hasNext()) {iter.next();}
                else {iter=list.listIterator(); iter.next();}
            }
            iter.remove();
        }

        System.out.print("<");
        for(int i=0;i<n;i++) {
            System.out.print(result[i]);
            if(i!=(n-1)) {System.out.print(", ");}
        }
        System.out.print(">");
    }
}
