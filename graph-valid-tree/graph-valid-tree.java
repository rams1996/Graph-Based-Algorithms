class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n != edges.length + 1){
            return false;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            int parent = edges[i][0], child = edges[i][1];
            graph.get(parent).add(child);
            graph.get(child).add(parent);
        }
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            set.add(cur);
            for(int num: graph.get(cur)){
                if(!set.contains(num)){
                    set.add(num);
                    queue.add(num);
                }
            }
        }
        return set.size() == n;
    }
}
