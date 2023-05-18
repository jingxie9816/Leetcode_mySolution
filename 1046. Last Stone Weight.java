class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);  // descending order pq
        for (int s : stones){
            pq.offer(s);
        }

        while(pq.size()>1){
            int x = pq.poll();
            int y = pq.poll();
            if (x>y) pq.offer(x-y);
        }
        return (pq.isEmpty()? 0 : pq.poll());
    }
}