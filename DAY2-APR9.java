/*
3375. Minimum Operations to Make Array Values Equal to K

You are given an integer array nums and an integer k. An integer h is called valid if all values in the array that are strictly greater than h are identical.
For example, if nums = [10, 8, 10, 8], a valid integer is h = 9 because all nums[i] > 9 are equal to 10, but 5 is not a valid integer. 
You are allowed to perform the following operation on nums:
Select an integer h that is valid for the current values in nums.
For each index i where nums[i] > h, set nums[i] to h.
Return the minimum number of operations required to make every element in nums equal to k. If it is impossible to make all elements equal to k, return -1.
*/

/*------------------------Logic-------------------

1. We must reduce all elements to 'k' using valid operations.
2. An operation can only reduce all elements greater than a valid 'h' to 'h', 
   and valid 'h' requires all elements greater than 'h' to be the same.
3. We can only reduce elements that are >= k. If any element is < k, return -1.
4. Count the number of unique elements >= k.
5. Each unique element ≥ k (except k itself) requires one operation.
6. So, the answer is (number of unique elements >= k) - 1 if k exists, 
   or just number of unique elements if k is not present.
*/

class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> unique = new HashSet<>();
        int min = Integer.MAX_VALUE;

        // Single loop to compute both min and build the set of elements >= k
        for (int num : nums) {
            min = Math.min(min, num);
            if (num >= k) {
                unique.add(num);
            }
        }

        // If any value is less than k, it's impossible to reach k
        if (min < k) {
            return -1;
        }

        // If all elements are already k
        if (unique.size() == 1 && unique.contains(k)) {
            return 0;
        }

        // Return number of unique elements >= k minus 1 if k is included
        return unique.contains(k) ? unique.size() - 1 : unique.size();
    }
}
