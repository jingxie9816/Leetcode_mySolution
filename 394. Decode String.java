class Solution {
    public String decodeString(String s) {
        Deque<StringBuilder> SBstack = new ArrayDeque<>();
        Deque<Integer> kstack = new ArrayDeque<>();
        int k = 0;
        StringBuilder ans = new StringBuilder();
        for (char ch: s.toCharArray()){
            if (Character.isDigit(ch)){
                k = k*10 + ch-'0';   // in case the k is more than 1 digit, e.g. 15 - repeat 15 times
            }
            else if (ch=='['){
                kstack.push(k);
                SBstack.push(ans);
                ans = new StringBuilder();
                k=0;
            } else if (Character.isLetter(ch)){
                ans.append(ch);
            } else {
                StringBuilder tempSB = SBstack.pop();
                int repeat = kstack.pop();
                while(repeat>0) {tempSB.append(ans); repeat--;}
                ans = tempSB;
            }
        }
    return ans.toString();
    }
}