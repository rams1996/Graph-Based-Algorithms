from collections import defaultdict
from collections import deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph=defaultdict(list)
        indegrees={}
        for i in prerequisites:
            graph[i[1]].append(i[0])
            if i[0] not in indegrees:
                indegrees[i[0]]=1
            else:
                indegrees[i[0]]+=1
        queue=deque()
        for temp in range(numCourses):
            if (temp not in indegrees) or (indegrees[temp]==0):
                queue.append(temp)
        while(queue):
            currValue=queue.popleft()
            for i in graph[currValue]:
                indegrees[i]-=1
                if indegrees[i]==0:
                    queue.append(i)
        for i in indegrees.values():
            if i!=0:
                return False
        return True
        
            
            
        
