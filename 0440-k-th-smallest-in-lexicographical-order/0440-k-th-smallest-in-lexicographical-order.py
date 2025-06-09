class Solution:
    def findKthNumber(self, n: int, k: int) -> int:
        curr=1
        k-=1
        def findstep(curr,n):
            steps=0
            first=curr
            last=curr
            while first<=n:
                steps+=min(last,n)-first+1
                first*=10
                last=last*10+9
            return steps
        while k>0:
            steps=findstep(curr,n)
            if steps<=k:
                curr+=1
                k-=steps
            else:
                curr*=10
                k-=1
        return curr