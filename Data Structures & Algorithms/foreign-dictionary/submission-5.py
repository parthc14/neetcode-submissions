class Solution:
    def foreignDictionary(self, words: List[str]) -> str:
        adj_map = {}
        indegree_map = {}

        for word in words:
            for ch in word:
                if ch not in adj_map:
                    adj_map[ch] = set()
                if ch not in indegree_map:
                    indegree_map[ch] = 0

        for i in range(len(words) - 1):
            first_word = words[i]
            second_word = words[i+1]

            minLen = min(len(first_word), len(second_word))

            if len(first_word) > len(second_word) and first_word[:minLen] == second_word[:minLen]:
                return ""

            for j in range(minLen):
                if first_word[j] == second_word[j]:
                    continue
                if second_word[j] not in adj_map[first_word[j]]:
                    adj_map[first_word[j]].add(second_word[j])
                    indegree_map[second_word[j]] += 1
                break
                

        queue = deque([])

        for key, value in indegree_map.items():
            if value == 0:
                queue.append(key)
        res = ""
        while queue:
            node = queue.popleft()
            res += node

            for nei in adj_map[node]:
                indegree_map[nei] -= 1
                if indegree_map[nei] == 0:
                    queue.append(nei)
        
        return res if len(res) == len(indegree_map) else ""


