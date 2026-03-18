class Solution {
    Map<String, Integer> memo = new HashMap<>();

    public int minStickers(String[] stickers, String target) {
        int n = stickers.length;
        int[][] stickersFreq = new int[n][26];
        for(int i=0;i<n;i++){
            for(char c : stickers[i].toCharArray()){
                stickersFreq[i][c-'a']++;
            }
        }
        memo.put("",0);
        int res = dfs(stickersFreq,target);
        return res==Integer.MAX_VALUE ? -1 : res;
    }

    public int dfs(int[][] stickersFreq, String target){
        if(memo.containsKey(target))return memo.get(target);

        int[] targetFreq = new int[26];
        for(char c : target.toCharArray()) targetFreq[c-'a']++;

        int minCount = Integer.MAX_VALUE;
        for(int[] stickers : stickersFreq){
            if(stickers[target.charAt(0)-'a']==0)continue;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;i++){
                if(targetFreq[i]>0){
                    int freq = targetFreq[i]-stickers[i];
                    while(freq-->0) sb.append((char)('a'+i));
                }
                
            }
            int count = dfs(stickersFreq,sb.toString());
            if(count!=Integer.MAX_VALUE) count+=1;
            minCount = Math.min(minCount,count);
        }
        memo.put(target,minCount);
        return minCount;
    }
}