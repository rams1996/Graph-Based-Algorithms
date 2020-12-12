    
    // Perform a DFS from src coloring the neighbors as you go
    // (in a top down approach)
    private void dfs(List<Integer>[] graph, int src, int[] gardenToColorMap) {
        
        for (int neighbor : graph[src]) {
            
            if (gardenToColorMap[neighbor] == 0) {
                gardenToColorMap[neighbor] = chooseNextColor(graph, neighbor, gardenToColorMap);
                dfs(graph, neighbor, gardenToColorMap);
            }
            
        }
        
    }
    
    // Somewhat complicated method for finding the next available color
    private int chooseNextColor(List<Integer>[] graph, int src, int[] gardenToColorMap) {
        
        int[] colorToGardenMap = new int[5];
        // Some of the gardens might not have been set (i.e., gardenToColorMa[i] == 0) so we
        // use -1 to denote that a color has not been used
        Arrays.fill(colorToGardenMap, -1);
        
        for (int neighbor : graph[src]) {
            int color = gardenToColorMap[neighbor];
            colorToGardenMap[color] = neighbor;
        }
        
        for (int i = 1; i <= 4; ++i) {
            if (colorToGardenMap[i] == -1) // color has not been assigned to garden
                return i;
        }
        
        // This path should not be taken happen
        return 1;
    }
    
    private List<Integer>[] makeGraph(int numberOfVertices) {
        
        List<Integer>[] graph = (LinkedList<Integer>[]) new LinkedList[numberOfVertices];
        
        for (int i = 0; i < numberOfVertices; ++i) {
            graph[i] = new LinkedList<>();
        }
        
        return graph;
        
    }
}
