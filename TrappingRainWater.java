/*
 * #42. Trapping Rain Water
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:
Refer image from leetcode

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

1. n == height.length
2. 0 <= n <= 3 * 104
3. 0 <= height[i] <= 105

 */

/*
 * Time Complexity: O (N) -> 'N' is the length of 'height' array
 * 
 * Space Complexity: O (1) -> No extra space used
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.array3;

public class TrappingRainWater {
	public int trap(int[] height) {
        
        // #1. Base condition
        if(height == null || height.length == 0){
            return 0;
        }
        
        // #2. Initialize left and right pointers.
        int left = 0;
        int right = height.length - 1;
        
        // #3. Initialize the left width and right width to compute the volume of water trapped in the pockets
        int LW = 0;
        int RW = 0;
        
        // #4. Initialize total volume of water trapped
        int total = 0;
        
        // #5. Move left or right pointers and compute the units of trapped rain water
        while(left <= right){
            
            // #5.1. for left pointer
            /*
            *   W/O right pointer, we would move left pointer and compute volume of water trapped even when there are no pockets to trap the water, its wrong. Right pointer prevents that 
            */
            if(LW < RW){
                if(LW < height[left]){
                    LW = height[left];
                }
                else{
                    total += LW - height[left];
                }
                
                left++;
            }
            
            // #5.2. for right pointer
            else{
                
                if(RW < height[right]){
                    RW = height[right];
                }
                else{
                    total += RW - height[right];
                }
                
                right--;
            }
            
        }
        
        return total;
        
    }

}
