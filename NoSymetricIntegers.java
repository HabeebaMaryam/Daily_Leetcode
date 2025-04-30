/*
2843. Count Symmetric Integers

You are given two positive integers low and high.
An integer x consisting of 2 * n digits is symmetric if the sum of the first n digits of x is equal to the sum of the last n digits of x. Numbers with an odd number of digits are never symmetric.
Return the number of symmetric integers in the range [low, high].
*/

class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for(int i = low ; i <= high; i++){
            if(i >= 11 && i <= 99 && i % 11 == 0){
                ans ++;
            }
        
            if(i >= 1000 && i <= 9999 && ( (i/1000) + ((i/100)%10) ) == ((i/10)%10) + (i%10)){
                ans++;
            }
        }
        return ans;
    }
}


constraints - 1<=low <= hight <= 10^4
logic 
  1. from 1 to 99 - 2 digit numbers .. therefore first digit should equal to second digit - these type of all no between 1 to 99 are divisible by 11
  2. from 100 to 999 ---- all 3 digit which is odd --- therefor 0 symmetric numbers 
  3. from 1000 to 9999 ---- sum(first 2 digit ) == sum(last 2 digit)
