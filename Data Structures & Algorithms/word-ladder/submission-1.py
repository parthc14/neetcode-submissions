class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if not endWord:
            return 0
        
        if endWord not in wordList:
            return 0
        
        queue = deque([])
        seen = set()

        for word in wordList:
            seen.add(word)
        
        res = 0
        queue.append(beginWord)

        while queue:
            res += 1
            
            for _ in range(len(queue)):
                word = queue.popleft()

                if word == endWord:
                    return res
                
                for i in range(len(word)):
                    for c in range(97, 123):
                        if chr(c) == word[i]:
                            continue
                        nei = word[:i] + chr(c) + word[i+1:]

                        if nei in seen:
                            queue.append(nei)
                            seen.remove(nei)
        
        return 0



