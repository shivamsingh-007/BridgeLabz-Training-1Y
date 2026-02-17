class Solution:
    def canBeTypedWords(self, text, brokenLetters):
        broken = set(brokenLetters)
        count = 0

        for word in text.split():
            for ch in word:
                if ch in broken:
                    break
            else:
                count += 1

        return count
