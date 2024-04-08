package linked_list_0x04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class P1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());

        LinkedList<Character> list = new LinkedList();
        for (int i = 0; i < str.length(); i++) {list.add(str.charAt(i));}

        ListIterator<Character> iter = list.listIterator();
        while(iter.hasNext()) {iter.next();}


        for(int i=0;i<n;i++) {
            String[] command = br.readLine().split(" ");
            if (command[0].equals("P")) {
                char inChar = command[1].charAt(0);
                iter.add(inChar);
            }
            if (command[0].equals("L")) {
                if (iter.hasPrevious() == false) {continue;}
                iter.previous();
            }
            if (command[0].equals("D")) {
                if (iter.hasNext()==false) {continue;}
                iter.next();
            }
            if(command[0].equals("B")) {
                if (iter.hasPrevious() == false) {continue;}
                iter.previous(); iter.remove();
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : list) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}
