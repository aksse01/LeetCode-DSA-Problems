class Solution:

    def check_index_match(self, s: str, p: str, i: int, j: int) -> bool:
        """Helper method to check if s[i] and p[j] are a match or not
        """
        if i < len(s) and j < len(p):
            if p[j] == s[i] or p[j] == '.':
                return True
        return False

    def hit_wildcard_pattern(self, p: str, j: int) -> bool:
        """Helper method to determine if p[j] is the start of a wildcard pattern or not
        e.g., p[j] = "a", p[j+1] = "*" -> we've hit the pattern "a*"
        """
        if j + 1 < len(p) and p[j + 1] == '*':
            return True
        return False

    def isMatch(self, s: str, p: str) -> bool:
        """Method to determine if pattern p matches the ENTIRETY of string s.

        * Time Complexity: O(m*n) -- at most (m+1)*(n+1) states, O(1) work each
        * Space Complexity: O(m*n) -- the `seen` set and the stack
        """
        # get boundaries
        S, P = len(s), len(p)

        # traversal vars
        stack = [(0,0)]
        seen = set()

        # starting from state (0,0)
        # do a DFS search with a seen set to skip already visited states
        while stack:
            # pop the stack
            i, j = stack.pop()
            # skip seen states
            if (i, j) in seen: 
                continue
            # add to seen states
            seen.add((i, j))

            ## Check Boundaries
            if i == S and j == P:
                # both spent -> SUCCESS
                return True
            elif i < S and j == P:
                # p spent, s left over -> path dies
                continue
            
            # remaining two conditions:
            # 1. s spent, p left over -> run processing block below
            # 2. both s and p left over -> run processing block below
            
            ## Processing
            # check for match at s[i] and p[j]
            is_match_at_index = self.check_index_match(s, p, i, j)
            # check for wildcard
            is_wildcard = self.hit_wildcard_pattern(p, j)
            
            # handle single point comparison
            if not is_wildcard:
                if is_match_at_index:
                    # match -> move to next index for both s and p
                    stack.append((i + 1, j+ 1))
                else:
                    # not match - path dies -> explore next viable state
                    continue
            # handle wildcards
            else:
                # always explore the option of stopping the current pattern
                # skip this wildcard pattern entirely [j, j+1] and hold s[i]
                stack.append((i, j + 2))
                # only if match, keep going down greedy path (LIFO)
                if is_match_at_index:
                    # greedily move onto next index s[i+1] and hold p[j]
                    stack.append((i + 1, j))
        
        return False
