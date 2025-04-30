/*
3375. Minimum Operations to Make Array Values Equal to K

You are given an integer array nums and an integer k.
An integer h is called valid if all values in the array that are strictly greater than h are identical.
For example, if nums = [10, 8, 10, 8], a valid integer is h = 9 because all nums[i] > 9 are equal to 10, but 5 is not a valid integer.
You are allowed to perform the following operation on nums:

Select an integer h that is valid for the current values in nums.
For each index i where nums[i] > h, set nums[i] to h.
Return the minimum number of operations required to make every element in nums equal to k. If it is impossible to make all elements equal to k, return -1.
*/

"https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k/description/?envType=daily-question&envId=2025-04-09"

class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> s = new HashSet<>();

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            min = Math.min(min , nums[i]);
        }
        if(min < k){
            return -1;
        }

        for(int elem : nums){
            if(!s.contains(elem)){
                s.add(elem);
            }
        }
        int ans = s.size();
        if(min == k) return ans - 1;
        return ans;
    }
}
