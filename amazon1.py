import sys

def heapify(arr, n, i):
    min = i  
    l = 2 * i + 1     
    r = 2 * i + 2     
 
    if l < n-1 and arr[min] > arr[l]:
        min = l
 
    if r < n-1 and arr[min] > arr[r]:
        min = r
 
    if min != i:
        arr[i], arr[min] = arr[min], arr[i]
 
        heapify(arr, n, min)


def solution(parts):
    
    if len(parts) == 0 or len(parts)==1:
        return 0
    
    res = 0
    while True:

        if len(parts)==1:
            break


        n = len(parts)

        for i in range(n//2-1, -1, -1):
            heapify(parts, n, i)

        f = parts[0]
        parts.pop(0)

        for i in range(n//2-1, -1, -1):
            heapify(parts, n, i)
        
        s = parts[0]
        parts.pop(0)
        sum = f + s
        res += sum
        parts.append(sum)

    return res


# 1. First we will sort the array so that the parts with the smaller sizes can be added first.
# 2. We will then start adding 2 elements at a time and store the value in the sperate list time.
# 3. The final move will be to sum all the elements of the time list

# Time Complexity:

# O(nlogn)

# Space Complexity:

# O(n)
#  
p = [2, 2, 2, 2, 2, 2, 2, 2, 2, 2]
# p = [8, 4 , 6, 12]
print(solution(p))