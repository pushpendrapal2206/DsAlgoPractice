package com.practice.algo.ds;

/**
 * 413. Arithmetic Slices
 * <p>
 * A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any
 * two consecutive elements is the same.
 * <p>
 * For example, these are arithmetic sequence:
 * <p>
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * The following sequence is not arithmetic.
 * <p>
 * 1, 1, 2, 5, 7
 * <p>
 * A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such
 * that 0 <= P < Q < N.
 * <p>
 * A slice (P, Q) of array A is called arithmetic if the sequence:
 * A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
 * <p>
 * The function should return the number of arithmetic slices in the array A.
 * <p>
 * Example:
 * <p>
 * A = [1, 2, 3, 4]
 * <p>
 * return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 * <p>
 * Related Topics: Math, Dynamic Programming
 * Similar Questions: (H) Arithmetic Slices II - Subsequence
 *
 * [10, 20, 30,  45, 50, 52, 58, 64|]
 * [1, 2, 3, 4]
 * sum = 6
 * AP sum = 1.5 (2 + 2) = 6

 */

public class ArithmeticSlices {
}
