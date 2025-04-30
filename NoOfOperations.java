/*
3396. Minimum Number of Operations to Make Elements in Array Distinct

You are given an integer array nums. You need to ensure that the elements in the array are distinct. To achieve this, you can perform the following operation any number of times:

Remove 3 elements from the beginning of the array. If the array has fewer than 3 elements, remove all remaining elements.
Note that an empty array is considered to have distinct elements. Return the minimum number of operations needed to make the elements in the array distinct.
*/

"https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/description/?envType=daily-question&envId=2025-04-08"

  
class Solution {
    public int minimumOperations(int[] nums) {
        int ans = 0;
        int n = nums.length;
        Set<Integer> s = new HashSet<>();
        int i = 0;
        for( i = n - 1; i >= 0; i--){
            if(s.contains(nums[i])){
                break;
            }
            s.add(nums[i]);
        }
        if((i + 1)%3 == 0){
            return (i+1)/3;
        }
        return ((i + 1)/3) + 1;
    }
}

Time complexity - O(N)
space complexity- O(N)
// since we can only remove the elements from first - we will try to  check the elements from last 
//    if we found any duplicate elemnet for the first time , then stop at that index , and get the answer by ceil(index/3)

