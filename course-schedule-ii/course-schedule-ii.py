class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        from collections import deque
        indegrees=defaultdict(int)
        graph=defaultdict(list)
        queue=deque()
        from collections import deque
        for i in prerequisites:
            indegrees[i[0]]+=1
            graph[i[1]].append(i[0])
        for i in range(numCourses):
            if indegrees[i]==0:
                queue.append(i)
                
        result=[]
        while queue:
            currNode=queue.popleft()
            result.append(currNode)
            for i in graph[currNode]:
                indegrees[i]-=1
                if indegrees[i]==0:
                    queue.append(i)
        if len(result)<numCourses:
            return []
        return result
                
            
                
        
        
        
