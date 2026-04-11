class Solution {
    public int minDeletions(String s) {
        Integer[] freq = new Integer[26];
        Arrays.fill(freq,0);
        for(char c : s.toCharArray()) freq[c-'a']++;
        // // Arrays.sort(freq, Collections.reverseOrder());
        // int count = 0;
        // for(int i=1;i<26;i++){
        //     if(freq[i]==0)break;
        //     if(freq[i]>=freq[i-1]){
        //         int temp = freq[i];
        //         freq[i] = Math.max(0,freq[i-1]-1);
        //         count += (temp-freq[i]);
        //     }
        // }
        // return count;
        Set<Integer> set = new HashSet<>();
        int deletionCount = 0;
        for(int f : freq){
            while(f>0 && set.contains(f)){
                deletionCount++;
                f--;
            }
            if(f>0){
                set.add(f);
            }
        }
        return deletionCount;
    }
}

/*
a - 2
b - 2
c - 2;
*/

