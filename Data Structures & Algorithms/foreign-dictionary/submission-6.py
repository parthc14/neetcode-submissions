class Solution:
    def foreignDictionary(self, words: List[str]) -> str:
        adj_map = {c: set() for w in words for c in w}

        for i in range(len(words)-1):
            w1 = words[i]
            w2 = words[i+1]
            min_len = min(len(w1), len(w2))
            if len(w1) > len(w2) and w1[:min_len] == w2[:min_len]:
                return ""
            
            for j in range(min_len):
                if w1[j] != w2[j]:
                    adj_map[w1[j]].add(w2[j])
                    break
        
        visited = {}
        res = []

        def dfs(c):
            if c in visited:
                return visited[c]

            visited[c] = True
            for nei in adj_map[c]:
                if dfs(nei):
                    return True
            
            visited[c] = False
            res.append(c)

        for c in adj_map:
            if dfs(c):
                return ""
        
        res.reverse()
        return "".join(res)


