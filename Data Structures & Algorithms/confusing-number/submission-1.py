class Solution:
    def confusingNumber(self, n: int) -> bool:
        rev = 0;
        c = n;
        while n > 0:
            cur = n % 10;
            rev *= 10 
            if cur == 6:
                rev += 9
            elif cur == 9:
                rev += 6
            else:
                rev += cur
            if cur in [2, 3, 4, 5, 7]:
                return False
            n = n // 10;
            
        return c != rev;

        