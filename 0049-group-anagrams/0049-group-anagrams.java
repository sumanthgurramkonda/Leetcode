class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    
        Map<String, List<String>> map = new HashMap();

        for(String s : strs){
            String sortedString  = getSortedString(s);
            map.putIfAbsent(sortedString, new ArrayList());
            map.get(sortedString).add(s);
        }
        List<List<String>> resList = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            resList.add(entry.getValue());
        }
        return resList;
    }

    public String getSortedString(String word){
        StringBuilder str = new StringBuilder();
        char[] ch = word.toCharArray();
        Arrays.sort(ch);
        for(char c : ch){
            str.append(c);
        }
        return str.toString();
    }
}