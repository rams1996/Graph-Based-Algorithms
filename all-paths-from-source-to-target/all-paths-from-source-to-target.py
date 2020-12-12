class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        # initialize an empty list to store the paths. Create a deque for BFS
        allPaths = []
        queue = collections.deque([(0, [0])]) #(node, currentPath)
        last = len(graph)-1 #last node
        
        while queue:
            curr, path = queue.popleft()
            if curr == last:
                allPaths.append(path)
            
            else:
                for node in graph[curr]:
                    queue.append((node, path + [node]))
                
        return allPaths
        
        
