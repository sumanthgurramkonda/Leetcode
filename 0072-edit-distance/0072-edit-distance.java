class Solution {
    int[][] count;
    public int minDistance(String word1, String word2) {
        if(word1.equals(word2))return 0;
        count = new int[word1.length()][word2.length()];
        for(int[] arr : count) Arrays.fill(arr,-1);
        return minDistance(word1, word2,0,0);
    }

    public int minDistance(String word1, String word2, int w1, int w2){
        int w1Len = word1.length(), w2Len = word2.length();
        if(w1==w1Len) return word2.length()-w2;
        if(w2==w2Len) return word1.length()-w1;

        if(count[w1][w2]!=-1)return count[w1][w2];

        char c1 = word1.charAt(w1), c2 = word2.charAt(w2);
        int minDistance = Integer.MAX_VALUE;
        if(c1==c2){
            minDistance = minDistance(word1, word2,w1+1,w2+1); 
        }else{
            int replace = minDistance(word1,word2,w1+1, w2+1); 
            int delete = minDistance(word1,word2,w1+1, w2);     
            int insert = minDistance(word1,word2,w1, w2+1);
            minDistance = Math.min(insert, Math.min(delete, replace))+1;
        }
        return count[w1][w2] = minDistance;
            
    }

}