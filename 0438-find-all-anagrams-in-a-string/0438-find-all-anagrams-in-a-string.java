class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> indicesList = new ArrayList();
        if (s.length() < p.length()) return indicesList;
        int[] pFrequency = new int[26];
        int[] sFrequency = new int[26];
        Arrays.fill(pFrequency, 0);
        Arrays.fill(sFrequency, 0);
        int pLength = p.length();

        for(int i=0;i<pLength;i++){
            pFrequency[p.charAt(i)-'a']+=1;
            sFrequency[s.charAt(i)-'a']+=1;
        }

        for(int i=0;i<=s.length()-pLength;i++){
            if(Arrays.equals(pFrequency,sFrequency)){
                indicesList.add(i);
            }
            if(i+pLength < s.length()){
                sFrequency[s.charAt(i)-'a']--;
                sFrequency[s.charAt(i+pLength)-'a']++;
            }
        }

        return indicesList;
    }
}