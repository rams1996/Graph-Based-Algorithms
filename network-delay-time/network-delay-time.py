class Solution:
    def networkDelayTime(self, times: List[List[int]], N: int, K: int) -> int:
        import heapq
        from collections import defaultdict
        createGraph=defaultdict(list)
        for i in times:
            createGraph[i[0]].append((i[2],i[1]))
        heap=[]
        heapq.heapify(heap)
        time=float('-inf')
        visited=set()
        visited.add(K)
        for edge in createGraph[K]:
            heapq.heappush(heap,edge)
        while heap:
            currEdge=heapq.heappop(heap)
            # print(currEdge)
            if currEdge[1] not in visited:
                for edge in createGraph[currEdge[1]]:
                    heapq.heappush(heap,(edge[0]+currEdge[0],edge[1]))
                visited.add(currEdge[1])
                time=max(time,currEdge[0])
        if len(visited)!=N:
            return -1
        return time
            
        
​
        
