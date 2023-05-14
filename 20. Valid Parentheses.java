class Solution {
    public boolean isValid(String s) {
        // if the length of s is odd, then it must be false
        int n = s.length();
        if (n % 2 == 1) return false;
        // create a map to store the correct type of brackets
        Map<Character, Character> dict = new HashMap<>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        // create a stack to store open brackets, waiting for the mapping of closed bracets
        Deque<Character> stk = new LinkedList<>();
        for (int i = 0; i< n; i++){
            Character c = s.charAt(i);
            if (dict.containsKey(c)){
                if (stk.isEmpty() || stk.peek() != dict.get(c)){
                    return false;
                }
                else stk.pop();
            }
            else stk.push(c);
        }
    return stk.isEmpty();
    }
}