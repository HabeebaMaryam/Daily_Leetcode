/*
2873. Maximum Value of an Ordered Triplet I

You are given a 0-indexed integer array nums.

Return the maximum value over all triplets of indices (i, j, k) such that i < j < k. If all such triplets have a negative value, return 0.

The value of a triplet of indices (i, j, k) is equal to (nums[i] - nums[j]) * nums[k].
*/


class Solution {
    int n ;
    public long maximumTripletValue(int[] nums) {
         n = nums.length;
        long ans = 0;
        // for(int i = 0; i < n-2; i++){
        //     for(int j = i+1; j < n-1; j++){
        //         for(int k = i+2; k <n; k++){
        //             ans = Math.max(ans , (nums[i] - nums[j]) * nums[k]);
        //         }
        //     }
        // }
        return solve(nums);
    }

    // method - 2;
    // public long solve(int[] nums ){
    //     long ans = 0;
    //     int[] l = left_max(nums);
    //     int[] r = right_max(nums);
    //     for(int i = 1; i < n-1; i++){
    //         ans = Math.max(ans ,(long)(l[i] - nums[i]) * r[i]);
    //     }
    //     return ans;
    // }

    public int[] left_max(int[] nums){
        int[] left_max = new int[n];
        
        int max = 0;
        for(int i = 0; i < n; i++){
            
            left_max[i] = max;
            max = Math.max(max , nums[i]);
        }
        return left_max;
    }
    public int[] right_max(int[] nums){
        int[] right_max = new int[n];
        right_max[n-1] = nums[n-1];
        int max = 0;
        for(int i = n-1; i >=0; i--){
            
            right_max[i] = max;
            max = Math.max(max , nums[i]);
        }
        return right_max;
    }

    // approach - 3 --- O(n) , O(1)

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
