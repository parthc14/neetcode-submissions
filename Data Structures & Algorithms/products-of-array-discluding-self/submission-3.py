class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        """
        1. Count all zeros by iterating and also multiplying the product
        2. If count > 1 : all elements in array will be zero
        3. Loop again 
            a. if element is zero, product will product itself
            b. else if zeros is 0, product will be product / num itself
        """
        product = 1
        no_of_zeros = 0
        for num in nums:
            if num != 0:
                product *= num
            else :
                no_of_zeros += 1
        
        res = [ 0 for _ in range(len(nums))]
        if no_of_zeros > 1:
            return res
        
        for i, n in enumerate(nums):
            if n == 0:
                res[i] = product
            elif no_of_zeros == 0:
                res[i] = product // n
        return res


        
    

        