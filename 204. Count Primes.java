class Solution {
    public int countPrimes(int n) {
        int[] primeArray = new int[n];
        Arrays.fill(primeArray,1);
        int count = 0;
        for (int i = 2; i<n; i++){
            if (primeArray[i]==1) {
                count++;
                if ((long) i*i<n){
                    for (int j = i*i; j<n; j+=i){
                        primeArray[j] = 0;
                    }
                }
            }
        }
        return count;
    }
}