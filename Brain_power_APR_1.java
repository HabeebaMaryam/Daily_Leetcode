/*2140. Solving Questions With Brainpower

You are given a 0-indexed 2D integer array questions where questions[i] = [pointsi, brainpoweri].

The array describes the questions of an exam, where you have to process the questions in order (i.e., starting from question 0) and make a decision whether to solve or skip each question. Solving question i will earn you pointsi points but you will be unable to solve each of the next brainpoweri questions. If you skip question i, you get to make the decision on the next question.

For example, given questions = [[3, 2], [4, 3], [4, 4], [2, 5]]:
If question 0 is solved, you will earn 3 points but you will be unable to solve questions 1 and 2.
If instead, question 0 is skipped and question 1 is solved, you will earn 4 points but you will be unable to solve questions 2 and 3.
Return the maximum points you can earn for the exam.
*/
class Solution {
    int n ;
    public long mostPoints(int[][] questions) {
        n = questions.length;
        long[] t = new long[n];
        return  solve(questions);

        
    }
    // Recursion 
    // public long solve(int ind , int[][] arr){
    //     if(ind >= arr.length){
    //         return 0;
    //     }
    //     long take = arr[ind][0] + solve(ind + arr[ind][1] + 1 , arr);
    //     long not_take = solve(ind + 1 , arr);
    //     return Math.max(take , not_take);
    // }


    // Memoization
    // public long solve(int ind , int[][] arr , long[] t){
    //     if(ind >= arr.length){
    //         return 0;
    //     }
    //     if(t[ind] != 0){
    //         return t[ind];
    //     }
    //     long take = arr[ind][0] + solve(ind + arr[ind][1] + 1 , arr , t);
    //     long not_take = solve(ind + 1 , arr , t);
    //     return t[ind] = Math.max(take , not_take);
    // }

    // Bottom - up
    public long solve( int[][] arr ){
        long[] t = new long[200001];
        for(int i = n-1; i >= 0; i--){
            t[i] = Math.max(arr[i][0] + t[i + arr[i][1] + 1] , t[i+1]);
        }
        return t[0];
    }
}
