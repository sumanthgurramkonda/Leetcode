import heapq

class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        N = len(points)
        visited = set()
        min_heap = [(0, 0)]  # (cost, point_index)
        total_cost = 0

        while len(visited) < N:
            cost, i = heapq.heappop(min_heap)
            if i in visited:
                continue
            visited.add(i)
            total_cost += cost

            for j in range(N):
                if j not in visited:
                    x1, y1 = points[i]
                    x2, y2 = points[j]
                    dist = abs(x1 - x2) + abs(y1 - y2)
                    heapq.heappush(min_heap, (dist, j))

        return total_cost
