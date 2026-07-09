class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        ana={}
        for word in strs:
            st = tuple(sorted(word))
            if st in ana:
                ana[st].append(word)
            else:
                ana[st]=[word]

        return list(ana.values())