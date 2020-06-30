package com.practice.algo.ds;

public class SwapArrayMaximize {


    private static int[] maximizeArray(int swaps, int[] arr) {
        int i = 1;
        int largest = arr[0];
        int largestIndex = 0;
        int copySwaps = swaps;
        while (swaps >= 0 && i < arr.length) {
            if (arr[i] > largest) {
                largest = arr[i];
                largestIndex = i;
            }
            i++;
            swaps--;
        }
        int j = largestIndex;
        while (copySwaps > 0 && j > 0) {
            arr[j] = arr[j - 1];
            arr[j - 1] = largest;
            j--;
            copySwaps--;
        }
        return arr;
    }

    public static void main(String[] s) {
        for (int a : maximizeArray(3, new int[]{5, 4, 9, 8})) {
            System.out.print(a);
        }
    }
}
