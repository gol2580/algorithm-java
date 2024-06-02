package 재귀_0x0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2448 {
    static void printStar(int n, int x, int y) {
        //base condition
        //

        int nx = n/2;
        printStar(nx, x, y);
        //printStar(nx, x+nx, y);
        //printStar(nx, x+nx, y+nx);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        printStar(n,0,n-1);
    }
}
