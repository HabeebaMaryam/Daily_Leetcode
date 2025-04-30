/*
1863 - sum of all subset xor total
link - https://leetcode.com/problems/sum-of-all-subset-xor-totals/description/?envType=daily-question&envId=2025-04-05



The XOR total of an array is defined as the bitwise XOR of all its elements, or 0 if the array is empty.

For example, the XOR total of the array [2,5,6] is 2 XOR 5 XOR 6 = 1.
Given an array nums, return the sum of all XOR totals for every subset of nums. 

Note: Subsets with the same elements should be counted multiple times.

An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b.

*/
class Solution {
    public int subsetXORSum(int[] nums) {
        int[] ans = {0};
        // solve(nums , 0 , 0 , ans);
        // return ans[0];

        return solve(nums);
    }

    
    // Recursion solution
    // public void solve(int[] nums , int ind , int xor , int[] ans ){
    //     if(ind >= nums.length){
    //         ans[0] = ans[0] + xor;
    //         return;
    //     }
    //     solve(nums , ind+1 , xor^nums[ind] , ans);
    //     solve(nums , ind+1 , xor , ans);
    // }



    // solution - 2 - O(n)
    public int solve(int[] nums ){
        int or = 0;
        for(int elem : nums){
            or = or | elem;
        }
        return or << (nums.length-1);
    }

    // space complecity - O(height) - auxiliry stack space
    // time complexity - O(2^n)
}
