class Solution {
    public int longestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int[] count = new int[128]; //因为ascii码里面,常用就是128个，足够cover大小写的字母
        int odd = 0;
        int ans = 0;
        for (char ch:charArray){
            count[ch]++;
            
        }
        for (int v : count){
            if (v % 2==1) {
                odd = 1;
                ans += v-1;
            } else {
                ans += v;
            }
        }
        return ans + odd;
    }
}