/*
Maximum Value of an Ordered Triplet I
You are given a 0-indexed integer array nums.

Return the maximum value over all triplets of indices (i, j, k) such that i < j < k. If all such triplets have a negative value, return 0.

The value of a triplet of indices (i, j, k) is equal to (nums[i] - nums[j]) * nums[k].
*/

class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
         return solve(nums);
    }
    public long solve(int[] nums){
        long max_diff = 0, max = 0 , ans = 0;
        for(int k = 0; k < nums.length; k++){
            ans = Math.max(ans , max_diff * nums[k]);
            max_diff = Math.max(max_diff , max - nums[k]);
            max = Math.max(max , nums[k]);
            
        }
        return ans;
    }
}
