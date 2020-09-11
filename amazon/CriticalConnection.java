// leetcode 1192 
// 找到关键连接，即删除这条线，有node就无法到达另一个node 【tarjan's algorithm】
class CriticalConnection {
    int time; // 时间戳
    int[] dfn; // 节点的访问时间
    int[] low; // 节点能回到的最早时间
    List<List<Integer>> ans;
    List<Integer>[] adj; 
    
    // find path which not in cycle
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        dfn = new int[n];
        low = new int[n];
        ans = new ArrayList<>();
        adj = new ArrayList[n];
        time = 1;
        for(int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        for(List<Integer> edge : connections){
            int n1 = edge.get(0), n2 = edge.get(1);
            adj[n1].add(n2);
            adj[n2].add(n1);
        }
        dfs(0, -1);
        return ans;
    }
    
    private void dfs(int cur, int pre){
        dfn[cur] = low[cur] = time++;
        for(int next : adj[cur]){
            if(next == pre) continue;
            // 未访问
            else if(dfn[next] == 0){
                dfs(next, cur);
                low[cur] = Math.min(low[cur], low[next]);
                if(low[next] > dfn[cur])
                    ans.add(Arrays.asList(cur, next));
            }
            // 访问过
            else{
                low[cur] = Math.min(low[cur], dfn[next]);
            }
        }
    }
}