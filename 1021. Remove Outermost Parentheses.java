class Solution {
    public String removeOuterParentheses(String s) {
        StringBuffer resultSB = new StringBuffer();
        Deque<Character> stk = new ArrayDeque<>();
        int n = s.length();
        for (int i=0; i<n; i++){
            Character c = s.charAt(i);
            // the order of below three 'if' matters!
            if (c == ')'){
                stk.pop();
            }
            if (!stk.isEmpty()){
                resultSB.append(c);  // if the stk is empty, 2 situations 1) it's the first '(' -> no need to add to stack; 2) it's the last close ')', no need to add to stack;
            }
            if (c =='(') {      // push all ( into stack
                stk.push(c);
            }
        }
        return resultSB.toString();
    }
}



class Solution {
    public String removeOuterParentheses(String s) {
        StringBuffer resultSB = new StringBuffer();
        int level = 0;
        int n = s.length();
        for (int i = 0; i<n; i++){
            char c = s.charAt(i);
            // the order of below three 'if' matters!
            if (c == ')') {
                level--;
            }
            if (level>0){    // 1) if it is the first (, level = 0, it won't be added to result 2) if it is the last ), level =0 too, so it won't be appended.
                resultSB.append(c);
            }
            if (c == '('){
                level++;
            }
        }
        return resultSB.toString();
    }
}

