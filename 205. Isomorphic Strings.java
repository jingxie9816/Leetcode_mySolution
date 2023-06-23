class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n!=m) return false;

        int[] charArrayS = new int[256];
        int[] charArrayT = new int[256];
        
        for (int i = 0; i< n; i++){
            Character x = s.charAt(i);
            Character y = t.charAt(i);
            if (charArrayS[x] != charArrayT[y]){
                return false;
            }
            charArrayS[x] = i+100;
            charArrayT[y] = i+100; 
            
        }
        return true;
    }
}