class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        //DFS
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            int node1 = edge[0];
            int node2 = edge[1];
            graph[node1].add(node2);
            graph[node2].add(node1);
        }
        int[] componentCount = new int[1];
        dfs(0, -1, graph, values, k, componentCount);
        return componentCount[0];
    }
    private int dfs(int currentNode, int parentNode, List<Integer>[] graph, int[] values, int k, int[] componentCount){
        int sum = 0;
        for(int neighbor : graph[currentNode]){
            if(neighbor != parentNode){
                sum += dfs(neighbor, currentNode, graph, values, k, componentCount);
                sum %= k;
            }
        }
        sum += values[currentNode];
        sum %= k;
        if(sum == 0){
            componentCount[0]++;
        }
        return sum;
    }
}