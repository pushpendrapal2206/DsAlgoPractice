package com.practice.algo.ds;

public class SwapArrayEvenOddMaximize {

    static int swapCount = 0;

    private static int[] maximizeArray(int[] arr) {
        int j = arr.length - 1;

        while (j >= 0) {
            if (arr[j] % 2 == 0 && j + 1 < arr.length && arr[j + 1] % 2 != 0 && j - 1 >= 0 && arr[j - 1] % 2 != 0) {
                if (arr[j] > arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else if (arr[j] < arr[j + 1]) {
                    swap(arr, j, j + 1);
                }

            } else if (arr[j] % 2 == 0 && j + 1 < arr.length && arr[j + 1] % 2 != 0) {
                if (arr[j] < arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            } else if (arr[j] % 2 == 0 && j - 1 >= 0 && arr[j - 1] % 2 != 0) {
                if (arr[j] > arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            } else if (arr[j] % 2 != 0 && j + 1 < arr.length && arr[j + 1] % 2 == 0 && j - 1 >= 0 && arr[j - 1] % 2 == 0) {
                if (arr[j] > arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else if (arr[j] < arr[j + 1]) {
                    swap(arr, j, j + 1);
                }

            } else if (arr[j] % 2 != 0 && j + 1 < arr.length && arr[j + 1] % 2 == 0) {
                if (arr[j] < arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            } else if (arr[j] % 2 != 0 && j - 1 >= 0 && arr[j - 1] % 2 == 0) {
                if (arr[j] > arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
            j--;
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        swapCount++;
    }

    public static void main(String[] s) {
        for (int a : maximizeArray(new int[]{4, 5, 8})) {
            System.out.print(a);
        }
        System.out.println("   " + swapCount);
    }
}
