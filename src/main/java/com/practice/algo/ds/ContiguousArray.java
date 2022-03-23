package com.practice.algo.ds;

public class ContiguousArray {
    
    public static void main(String[] s) {
        System.out.println("THIS HOTEL HAS A NICE VIEW OF THE CITYCENTER. THE LOCATION IS PERFECT.".replaceAll("\\p{Punct}", ""));
        System.out.println(new ContiguousArray().findMaxLength(new int[]{1, 1, 0}));
    }
    
    public int findMaxLength(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int s = 0;
        int e = nums.length - 1;
        int ml = 0;
        
        return fml(nums, s, e);
    }
    
    public int fml(int[] nums, int s, int e) {
        int len = e - s + 1;
        if (len < 2) {
            return 0;
        } else if (len == 2) {
            if (nums[0] != nums[1]) {
                return 2;
            } else {
                return 0;
            }
        } else {
            int mid = len / 2;
            return fml(nums, s, mid) + fml(nums, mid + 1, e);
        }
    }
}
