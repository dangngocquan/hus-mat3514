package hw7_21000699_dangngocquan.extend001;

public class Solution {
    static int isRepresentingBST(int arr[], int N) {
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] >= arr[i+1]) return 0;
        }
        return 1;
    }
}
