// 3396. Minimum Number of Operations to Make Elements in Array Distinct

/* Question : You are given an integer array nums. You need to ensure that the elements in the array are distinct. To achieve this, you can perform the following operation any number of times:
Remove 3 elements from the beginning of the array. If the array has fewer than 3 elements, remove all remaining elements.
Note that an empty array is considered to have distinct elements. Return the minimum number of operations needed to make the elements in the array distinct.
*/

/* --------------Logic---------------
1.  The problem requires finding the minimum number of "remove 3 elements" operations to make all elements in the array distinct.
2.  The key idea is to iterate from the end of the array and keep track of the unique elements encountered so far in a set.
3.  The first time we encounter a duplicate, we know that all elements before that index need to be removed to make the array distinct.
4.  The number of operations is then calculated based on how many elements need to be removed from the beginning. Since each operation removes 3 elements, we divide the number of elements to remove by 3 and round up to the nearest integer.

*/
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        Set<Integer> s = new HashSet<>();  // Create a HashSet to store the unique elements encountered from the end of the array.  HashSet allows us to check element existence in O(1) time.
        int i = 0;

        // Iterate from the end of the array to find the first duplicate element.
        for (i = n - 1; i >= 0; i--) {
            // If the current element is already in the set, it means we've found a duplicate.
            if (s.contains(nums[i])) {
                break; // Exit the loop because we've found the first duplicate.
            }
            // Add the current element to the set.
            s.add(nums[i]);
        }

        // After the loop, 'i' will be the index of the first duplicate element encountered from the end.
        // All elements from index 0 to 'i' (inclusive) need to be removed.
        // The number of elements to remove is (i + 1).

        // Calculate the number of operations needed.
        // Each operation removes 3 elements.
        // If (i + 1) is divisible by 3, then the number of operations is (i + 1) / 3.
        // Otherwise, we need to round up to the nearest integer, so the number of operations is (i + 1) / 3 + 1.

        if ((i + 1) % 3 == 0) {
            return (i + 1) / 3; // If the number of elements to remove is divisible by 3.
        }
        return ((i + 1) / 3) + 1; // If the number of elements to remove is NOT divisible by 3, round up to the nearest integer.
    }
}



/*
class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        Set<Integer> s = new HashSet<>();  // create set to array store the elements ,
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
*/
