class Solution:
    def maxArea(self, h: int, w: int, horizontalCuts: List[int], verticalCuts: List[int]) -> int:
        
        
        horizontalCuts.append(h)
        verticalCuts.append(w)
        
        horizontalCuts.append(0)
        verticalCuts.append(0)
        
        horizontalCuts.sort()
        verticalCuts.sort()
        
        h1 = 0
        h2 = 0
        v1 = 0
        v2 = 0
        
        hmax = 0
        vmax = 0
        for i in range(len(horizontalCuts)-1):
            
            temp = horizontalCuts[i+1] - horizontalCuts[i]
            
            if hmax < temp:
                hmax = temp
        
        for i in range(len(verticalCuts)-1):
            
            temp  = verticalCuts[i+1] - verticalCuts[i]
            
            if vmax < temp:
                vmax = temp
        return (hmax * vmax) % 1000000007