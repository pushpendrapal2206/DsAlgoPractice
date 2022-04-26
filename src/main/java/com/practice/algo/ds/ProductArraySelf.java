package com.practice.algo.ds;


/**
 * l = 24
 * r = 24
 * [1,2,3,4]
 * [24,12,8,6]
 *
 * [24,12,8,6]
 *
 *
 *     int left = 1; // Product of integers before i.
 *     int right = 1; // Product of integers after n-1-i.
 *     for (int i = 0; i < nums.length; i++) {
 *       output[i] *= left; // Update result in the front.
 *       left *= nums[i]; // Update left.
 *       output[n - 1 - i] *= right; // Update result at the end.
 *       right *= nums[n - 1 - i]; // Update right.
 *     }
 */
public class ProductArraySelf {
}
