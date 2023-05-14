class Solution {
    public String removeDuplicates(String s) {
        StringBuffer strB = new StringBuffer();
        int pos = -1; // keep track of index of the last character in strB
        for (int i = 0; i<s.length(); i++){
            Character c = s.charAt(i);
            if (pos < 0 ||strB.charAt(pos) != c){
                strB.append(c);
                pos++;
            } else {
                strB.deleteCharAt(pos);
                pos--;
            }
        }
        return strB.toString();
    }
}
