class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        res = []
        if not digits:
            return res
        mappings = ["", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]
        def f(idx, curr):
            if idx == len(digits):
                res.append(curr)
                return

            mpp = mappings[int(digits[idx])]
            for i in range(len(mpp)):
                f(idx + 1, curr + mpp[i])


        f(0, "")
        return res
        