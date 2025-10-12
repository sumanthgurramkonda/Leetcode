class Solution {

    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        int[] charArray = new int[26];
        for(int i=0;i<len;i++){
            charArray[tasks[i]-'A']++;
        }
        Arrays.sort(charArray);
        int maxFreq = charArray[25];
        int count = 0;
        for(int i=25;i>=0;i--){
            if(charArray[i]==maxFreq)count++;
            else break;
        }
        int res = ((maxFreq-1)*(n+1)) + count;
        return Math.max(res,tasks.length);
    }
}

/*
 AAA -> 3 BBB -> 3 n = 2  res = 8

 A->B->idle->A->B->idle->A->
 AAA -> 3 BB-> 2 n=2  res = 7


*/


