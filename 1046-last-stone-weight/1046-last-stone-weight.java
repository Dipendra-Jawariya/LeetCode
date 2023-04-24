class Solution {
    public int lastStoneWeight(int[] stones) {
        //setting decreasing order of the heap or max heap
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> b-a);
        for(int each: stones)
            heap.add(each);

        while(heap.size()>1){
            int top1 = heap.poll();
            int top2 = heap.poll();
            int diff = Math.abs(top1-top2);

            if(diff!=0){
                heap.add(diff);
            }
        }

        if(heap.size()!=0){
            return heap.poll();
        }else{
            return 0;
        }
    }
}