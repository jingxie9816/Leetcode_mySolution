class Solution {
    public int calPoints(String[] operations) {
        List<Integer> res = new ArrayList<>();
        int sum = 0;
        for (String op:operations){
            int j = res.size();
            switch(op.charAt(0)){
                case '+': 
                    sum += res.get(j-1) + res.get(j-2);
                    res.add(res.get(j-1) + res.get(j-2));
                    break;
                case 'D': 
                    sum += res.get(j-1)*2;
                    res.add(res.get(j-1)*2);
                    break;
                case 'C': 
                    sum -= res.get(j-1);
                    res.remove(j-1);
                    break;
                default:
                    sum += Integer.parseInt(op);
                    res.add(Integer.parseInt(op));
                    break;
            }
        }
        return sum;
    }
}
