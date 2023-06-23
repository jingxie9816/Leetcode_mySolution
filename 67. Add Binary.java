class Solution {
    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        int ai, bi;
        int carry = 0;
        StringBuffer ans = new StringBuffer();

        while(i>=0 && j>=0){
            //循环相加两个字符串相同长度的低位数部分, 即从index最大的开始
            ai = a.charAt(i--) - '0';
            bi = b.charAt(j--) - '0';
            ans.append((ai+bi+carry) % 2);
            carry = (ai+bi+carry) / 2;
        }
         // 如果 a 还没遍历完成（a串比b串长），则继续遍历添加 a 的剩余部分
        while(i>=0){
            ai = a.charAt(i--) - '0';
            ans.append((ai+carry) % 2);
            carry = (ai+carry) / 2;
        }
        // 如果 b 还没遍历完成（b串比a串长），则继续遍历添加 b 的剩余部分
        while(j>=0){
            bi = b.charAt(j--) - '0';
            ans.append((bi+carry) % 2);
            carry = (bi+carry) / 2;
        }
        //如果 carry 不等于0 还有个进位数没加进去，需要补充
        if(carry==1){
            ans.append(1);
        }
        //反转字符串获得正常结果
        return ans.reverse().toString();
    }
}