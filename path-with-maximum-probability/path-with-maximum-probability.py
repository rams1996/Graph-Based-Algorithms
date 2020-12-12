class Solution:
    def maxProbability(self, n: int, edges: List[List[int]], succProb: List[float], start: int, end: int) -> float:
        import heapq
        from collections import defaultdict
        hp=[]
        graph=defaultdict(list)
        for x,(i,j) in enumerate(edges):
            graph[i].append((j,succProb[x]))
            graph[j].append((i,succProb[x]))
        heapq.heappush(hp,(-1,start))
        visited=set()
        while hp:
            negProb,currNode=heapq.heappop(hp)
            prob=-negProb
            if currNode==end:
                return prob
            if currNode not in visited:
                visited.add(currNode)
                for nei,wei in graph[currNode]:
                    heapq.heappush(hp,(-wei*prob,nei))
        return 0
            
