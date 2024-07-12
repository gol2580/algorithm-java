package sort_0x0E;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2751 {
    //using merge sort
    static int[] arr, temp;
    public static void merge_sort(int start, int end) {
        if((start+1)==end) return;
        int mid = (start+end)/2;
        merge_sort(start,mid);
        merge_sort(mid, end);
        merge(start, end);
    }
    public static void merge(int start, int end) {
        int mid = (start + end)/2;
        int lIdx = start, rIdx = mid;
        for (int i = start; i < end; i++) {
            if(lIdx<mid && rIdx<end) {
                if(arr[lIdx]<arr[rIdx]) temp[i] = arr[lIdx++];
                else temp[i] = arr[rIdx++];
            } else {
                if(lIdx>=mid) temp[i] = arr[rIdx++];
                else temp[i] = arr[lIdx++];
            }
        }
        for (int i = start; i < end; i++) arr[i] = temp[i];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        temp = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());
        merge_sort(0, n);
        for (int i = 0; i < n; i++) sb.append(arr[i]).append('\n');
        System.out.print(sb);
    }
}
