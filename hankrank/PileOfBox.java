public class PileOfBox{
    // 把一堆弄成一样高
    public static long minStep(List<Integer> boxesInPiles){
        int res = 0;
        // 一样高的有几堆
        Map<Integer, Integer> map = new HashMap<>();
        for(int p : piles) {
            map.put(p, map.getOrDefault(p, 0)+1);
        }
        // 按堆的从高到低排序
        Queue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getKey() - a.getKey());
        maxHeap.addAll(map.entrySet());
        while(maxHeap.size() > 1) {
            Map.Entry<Integer, Integer> entry1 = maxHeap.poll();
            Map.Entry<Integer, Integer> entry2 = maxHeap.poll();
            res += entry1.getValue();
            entry2.setValue(entry2.getValue() + entry1.getValue());
            maxHeap.offer(entry2);
        }
        return res;
    }
}