"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = []):
        self.val = val
        self.neighbors = neighbors
"""
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return node
        hashMap={}
        from collections import deque
        queue=deque()
        queue.append(node)
        hashMap[node.val]=Node(node.val,[])
        visited=set()
        while queue:
            currNode=queue.popleft()
            if currNode.val not in visited:
                for i in currNode.neighbors:
                    if i.val not in hashMap:
                        hashMap[i.val]=Node(i.val,[])
                    # hashMap[currNode.val].neighbors.append(hashMap[i.val])
                    hashMap[i.val].neighbors.append(hashMap[currNode.val])
                    queue.append(i)
                visited.add(currNode.val)
        return hashMap[node.val]
