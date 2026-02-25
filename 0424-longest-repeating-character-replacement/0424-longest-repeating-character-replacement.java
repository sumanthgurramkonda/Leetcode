class Solution {
    public int characterReplacement(String s, int k) {

        int[] charCount = new int[26];

        int left = 0, maxLength = 0, maxCount = 0;

        for(int right = 0;right<s.length();right++){
            int index = s.charAt(right)-'A';
            charCount[index]++;
            maxCount = Math.max(maxCount, charCount[index]);

            while((right-left+1-maxCount) > k){
                charCount[s.charAt(left)-'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }
}

