from collections import deque
def solution(s):
    answer = []
    if len(s) == 1:
        return 1
    for i in range(1, len(s)):
        dq = deque()
        fin = 0
        for j in range(0, len(s)-i, i):
            dq.appendleft(s[j:j+i])
            fin = j
        dq.appendleft(s[fin + i:])
        result = ""
        while dq:
            x = dq.pop()
            cnt = 1
            while dq and dq[-1] == x:
                dq.pop()
                cnt+=1
            result += str(cnt) + x if cnt > 1 else x
        answer.append(len(result))
    return min(answer)