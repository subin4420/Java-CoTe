import heapq

def solution(scoville, K):
    answer = 0
    heap = []
    for i in scoville:
        heapq.heappush(heap, i)
        
    while heap[0] < K and len(heap) >= 2:
        heapq.heappush(heap, heapq.heappop(heap) + (heapq.heappop(heap) * 2))
        answer += 1
        
    return answer if heap[0] >= K else -1