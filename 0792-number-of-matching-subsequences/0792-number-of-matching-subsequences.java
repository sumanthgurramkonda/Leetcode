class Solution {
    public int numMatchingSubseq(String s, String[] words) {

        Map<Character, List<Integer>> map = new HashMap();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, new ArrayList());
            }
            map.get(c).add(i);
        }

        int res=0;
        for(int i=0;i<words.length;i++){
            if(isValidSubSequence(words[i], map)){
                res+=1;
                System.out.println(words[i]);
            }
        }
        return res;
    }

    public boolean isValidSubSequence(String word, Map<Character, List<Integer>> map){

        int lastIndex = -1;
        for(char c : word.toCharArray()){
            List<Integer> indexes = map.get(c);
            if(indexes!=null){
                    int nextIndex = findNextGreaterIndex(indexes,lastIndex);
                    if(nextIndex==-1) return false;
                    lastIndex = nextIndex;
            }else{
                return false;
            }
        }
        return true;
    }

    public int findNextGreaterIndex(List<Integer>list, int target){
        int left=0, right=list.size()-1;
        int ans = -1;

        while(left<=right){
            int mid = (left+right)/2;
            if(list.get(mid)>target){
                ans = list.get(mid);
                right=mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }
}