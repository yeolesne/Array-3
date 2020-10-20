/*
 * #189. Rotate Array
 * 
 * Given an array, rotate the array to the right by k steps, where k is non-negative.

Follow up:

1. Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
2. Could you do it in-place with O(1) extra space?
 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 

Constraints:

1. 1 <= nums.length <= 2 * 104
2. -231 <= nums[i] <= 231 - 1
3. 0 <= k <= 105

 */

/*
 * Time Complexity: O (N) + O (K) + O (N-K) -> O (N + K + N - K) -> O (N + N) -> O (2N) -> O (N) 
 * 					O (N) -> Reverse whole array
 * 					O (K) -> Reverse first k elements
 * 					O (N-K) -> Reverse remaining (N-K) elements
 * 
 * Space Complexity: O (1) -> No extra space used
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.array3;

public class RotateArrayKStepsRight {
	public void rotate(int[] nums, int k) {
        
        // #1. Base condition
        if(nums == null || nums.length == 0){
            return;
        }
        
        // #2. If k > length of array
        /*
        *   e.g: nums = [1,2,3], k = 4
        *   k > array length, 4 > 3
        *   So, k = k % length = 4 % 3 = 1
        *   Rotating given array 3 steps to the right gives [1,2,3], same array
        *   So, ignore and just rotate the array by 1 step to right -> [3,1,2]
        */
        if(k > nums.length){
            k = k % nums.length;
        }
        
        // #3. Reverse
        
        // #3.1. Reverse whole array
        reverse(nums, 0, nums.length-1);
        
        // #3.2. Reverse array from 0 to k-1, first 'k' elements
        reverse(nums, 0, k-1);
        
        // #3.3. Reverse array from k to nums.length-1, remaining (N-k) elements
        reverse(nums, k, nums.length-1);
        
        }
    
        // Reverse function
        public void reverse(int[] nums, int start, int end){
            while(start < end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                
                start++;
                end--;
                
            }
        }
        
}
