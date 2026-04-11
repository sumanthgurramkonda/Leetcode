class Solution {
    public int compress(char[] chars) {
        int index = 0;
        int repeatingCharCount = 0;
        int pointer = 0;
        int res = 0;
        int n = chars.length;
        while(index<n){
            int freq = 1;
            int currentIndex = index;
            while(currentIndex<n-1 && chars[currentIndex]==chars[currentIndex+1]){
                freq++;
                currentIndex++;
            }
            chars[pointer] = chars[index];
            if(currentIndex==n-2 && chars[currentIndex]==chars[currentIndex+1]){
                index = currentIndex+2;
            }else{
                index = currentIndex+1;
            }
            res++;
            pointer++;
            if(freq==1) continue;
            String freqString = (""+freq);
            res += freqString.length();
            for(int i=0;i<freqString.length();i++){
                chars[pointer++]=freqString.charAt(i);
            }
        }
        return res;
    }
}