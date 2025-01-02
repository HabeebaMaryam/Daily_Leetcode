/* https://leetcode.com/problems/count-vowel-strings-in-ranges/description/ */

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] count = new int[n];
        int[] ans = new int[queries.length];
        count[0] = isValid(words[0]);
        for(int i = 1; i < n; i++){
            count[i] = count[i-1] + isValid(words[i]);
        }
        int i = 0;
        for(int temp[] : queries){
            int start = (temp[0] ==  0) ? 0 : temp[0]-1;
            int end = temp[1];
            if(temp[0] == 0)ans[i] = count[end];
            else ans[i] = count[end] - count[start];
            i++;
        }
        return ans;
    }
    public int isValid(String sts){
        Set<Character> s = new HashSet<>();
        s.add('a');
        s.add('e');
        s.add('i');
        s.add('o');
        s.add('u');
        if(s.contains(sts.charAt(0)) && s.contains(sts.charAt(sts.length() - 1)) )return 1;
        return 0;
    }
}


