package linked_list_0x04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class P1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        LinkedList<Character> list = new LinkedList();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }
        int cursor = list.size() - 1;
        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");
            if (command[0].equals("P")) {
                char inChar = command[1].charAt(0);
                if (cursor == (list.size() - 1)) {
                    list.addLast(inChar); cursor++;
                } else if (cursor == -1) {
                    list.addFirst(inChar); cursor++;
                } else {
                    list.add(++cursor,inChar);
                }
            }
            if (command[0].equals("L")) {
                if (cursor == -1) {continue;}
                else { cursor--;}
            }
            if (command[0].equals("D")) {
                if (cursor == (list.size() - 1)) {continue;}
                else {cursor++;}
            }
            if(command[0].equals("B")) {
                if (cursor == (list.size() - 1)) {list.removeLast(); cursor--;}
                else if (cursor == -1) {continue;}
                else {list.remove(cursor);cursor--;}
            }
        }
        for(char c : list) {
            System.out.print(c);
        }
    }
}
