import java.util.*;

public class MemoryAllocator{
    static HashMap<Integer, Allocate> map = new HashMap<>();
    public static int[] memoAllocate(int[] a, int[][] queries){
        int[] res = new int[queries.length];
        int id = 1, i = 0;
        for(int[] query : queries){
            if(query[0] == 0){
                // allocate
                int idx = allocate(a, query[1]);
                System.out.println(i+" "+idx);
                if(idx != -1){
                    Arrays.fill(a, idx, idx+query[1], 1);
                    map.put(id++, new Allocate(idx, query[1]));
                    res[i++] = idx; 
                }else{
                    res[i++] = -1;
                }
            }else{
                // free
                if(map.containsKey(query[1])){
                    Allocate past = map.get(query[1]);
                    System.out.println(query[1]+" bb "+past.nums);
                    res[i++] = past.nums;
                    Arrays.fill(a, past.idx, past.idx+past.nums, 0);
                }else{
                    res[i++] = -1;
                }
            }
        }
        return res;
    }
    public static int allocate(int[] a, int nums){
        int count = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] == 0){
                count = 0;
                int j = i;
                while(i < a.length && count < nums && a[i] == 0){
                    i++;
                    count++;
                }
                if(count == nums)   return j;
            }
        }
        return -1;
    }
    public static void check(int[] a, int[] b){
        for(int i = 0; i < a.length; i++){
            if(a[i] != b[i]){
                System.out.println(false+" "+i+" "+a[i]+" "+b[i]);
            }
        }
    }
    static int[] memoryAllocator(int[] a, int[][] queries) {
        List<Integer> res = new LinkedList<>();
        if (a.length == 0 || queries.length == 0)
            return res.stream().mapToInt(k->k).toArray();
        int[] id = new int[a.length];
        int numq = 1;
        for (int[] q : queries) {
//            System.out.println(Arrays.toString(q));
            if (q[0] == 0) {    // alloc
                int len = 0;
                int con = q[1];
                int index = 0;
                while(index < a.length) {
//                    System.out.println(index);
                    if (a[index]!=0){
                        len = 0;
                    } else {
                        len++;
                    }
                    index++;
                    if (len == con) {
                        int start = index - con;
                        res.add(start);
                        for (int i = start; i<index; i++){
                            a[i] = 1;
                            id[i] = numq;
                        }
                        numq++;
                        break;
                    }
                }
                if (len!=con) {
                    res.add(-1);
                }
            } else {   // erase
                int eraseid = q[1];
                if (eraseid >= numq)
                    res.add(-1);
                else {
                    int len = 0;
                    for (int i = 0; i < a.length; i++) {
                        if (id[i] == eraseid) {
                            a[i] = 0;
                            len++;
                        }
                    }
                    res.add(len);
                }
            }
        }
        return res.stream().mapToInt(k->k).toArray();
    }
    public static void main(String[] args) {
        int[] a = new int[]{0,1,0,0,0,1,1,0,0,0,1,0,0};
        int[][] queries = new int[][]{{0,2},{0,1},{0,1},{1,2},{1,4},{0,4}};
        check(memoAllocate(a, queries), new int[]{2,0,4,1,-1,-1});
        check(memoryAllocator(a, queries), new int[]{2,0,4,1,-1,-1});
    }
}
class Allocate{
    int nums; // # of blocks allocate
    int idx;
    Allocate(int nums, int idx){
        this.nums = nums;
        this.idx = idx;
    }
}