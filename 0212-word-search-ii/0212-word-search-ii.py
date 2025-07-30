class Solution:

    class TrieNode:
        def __init__(self):
            self.children = {}
            self.isEndofWord = False

    class Trie:
        def __init__(self):
            self.root = Solution.TrieNode()
        
        def insert(self,word):
            node = self.root
            for ch in word:
                if ch not in node.children:
                    node.children[ch]= Solution.TrieNode()
                node = node.children[ch]
            node.isEndofWord=True

    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        trie = Solution.Trie()
        for word in words:
            trie.insert(word)
        resultList = set()
        n = len(board)
        m = len(board[0])
        visited = set()
        def findWords(node,i,j,word):
            ch = board[i][j]
            if ch not in node.children:
                return
            visited.add((i,j))
            node = node.children[ch]
            word=word+ch
            if node.isEndofWord:
                resultList.add(word)
            arr = [[1,0],[-1,0],[0,1],[0,-1]]
            for ind in arr:
                i1,j1 = i+ind[0],j+ind[1]
                if i1>=0 and i1<n and j1>=0 and j1<m and (i1,j1) not in visited:
                    findWords(node,i1,j1,word)
            visited.remove((i,j))

        for i in range(n):
            for j in range(m):
                    findWords(trie.root,i,j,"")
        return list(resultList)


        # # adjList = {}
        # # for word in words:
        # #     if word[0] in adjList:
        # #         adjList[word[0]].append(word)
        # #     else:
        # #         adjList[word[0]]=list()
        # #         adjList[word[0]].append(word)
        # adjList = defaultdict(list)
        # for word in words:
        #     adjList[word[0]].append(word)

        # visited=set()
        
        
        # def dfs(i, j, index,word):
            
        #     if index==len(word):
        #         return True
        #     visited.add((i,j))
        #     isExists = False
        #     if i-1>=0 and board[i-1][j]==word[index] and (i-1,j) not in visited:
        #         isExists = isExists or dfs(i-1,j,index+1,word)  
        #     if i+1<len(board) and board[i+1][j]==word[index] and (i+1,j) not in visited:
        #         isExists = isExists or dfs(i+1,j,index+1,word)
        #     if j-1>=0 and board[i][j-1]==word[index] and (i,j-1) not in visited:
        #         isExists = isExists or dfs(i,j-1,index+1,word)
        #     if j+1<len(board[i]) and board[i][j+1]==word[index] and (i,j+1) not in visited:
        #         isExists = isExists or dfs(i,j+1,index+1,word)
        #     visited.remove((i,j))
        #     return isExists
        # resultList=set()
        # for i in range(len(board)):
        #     for j in range(len(board[i])):
        #         if board[i][j] in adjList:
        #             for word in adjList[board[i][j]]:
        #                 if dfs(i,j,1,word):
        #                     resultList.add(word)
        # return list(resultList)
        
