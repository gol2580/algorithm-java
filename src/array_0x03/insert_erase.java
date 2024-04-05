package array_0x03;

import java.util.Vector;

/*
void insert(int idx, int num, int arr[], int& len){

}

void erase(int idx, int arr[], int& len){

}

void printArr(int arr[], int& len){
  for(int i = 0; i < len; i++) cout << arr[i] << ' ';
  cout << "\n\n";
}

void insert_test(){
  cout << "***** insert_test *****\n";
  int arr[10] = {10, 20, 30};
  int len = 3;
  insert(3, 40, arr, len); // 10 20 30 40
  printArr(arr, len);
  insert(1, 50, arr, len); // 10 50 20 30 40
  printArr(arr, len);
  insert(0, 15, arr, len); // 15 10 50 20 30 40
  printArr(arr, len);
}

void erase_test(){
  cout << "***** erase_test *****\n";
  int arr[10] = {10, 50, 40, 30, 70, 20};
  int len = 6;
  erase(4, arr, len); // 10 50 40 30 20
  printArr(arr, len);
  erase(1, arr, len); // 10 40 30 20
  printArr(arr, len);
  erase(3, arr, len); // 10 40 30
  printArr(arr, len);
}

int main(void) {
  insert_test();
  erase_test();
}
 */
public class insert_erase {
    static int insert(int idx, int num, int[] arr, int len) {
        for(int i=len-1;i>=idx;i--) {
            arr[i+1]=arr[i];
        }
        arr[idx]=num;
        return ++len;
    }
    public static int erase(int idx, int[] arr, int len) {
        for(int i=idx+1;i<len;i++) {
            arr[i-1] = arr[i];
        }
        return --len;
    }
    static void printArr(int arr[], int len) {
        for(int i = 0; i < len; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("\n");
    }
    static void insert_test(){
        System.out.println("***** insert_test *****");
        int[] arr = new int[10];
        arr[0] = 10; arr[1] = 20; arr[2] = 30; // 10 20 30
        int len = 3;
        len = insert(3, 40, arr, len); // 10 20 30 40
        printArr(arr, len);
        len = insert(1, 50, arr, len); // 10 50 20 30 40
        printArr(arr, len);
        len = insert(0, 15, arr, len); // 15 10 50 20 30 40
        printArr(arr, len);
    }
    static void erase_test(){
        System.out.println("***** erase_test *****");
        int[] arr = {10, 50, 40, 30, 70, 20};
        int len = 6;
        len = erase(4, arr, len); // 10 50 40 30 20
        printArr(arr, len);
        len = erase(1, arr, len); // 10 40 30 20
        printArr(arr, len);
        len = erase(3, arr, len); // 10 40 30
        printArr(arr, len);
    }
    public static void main(String[] args) {
        insert_test();
        erase_test();
    }

}
