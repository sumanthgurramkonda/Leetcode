class Solution {
    List<List<String>> res = new ArrayList();
    public List<List<String>> partition(String s) {
        partitions(s,0,new LinkedList<>());
        return res;
    }

    public void partitions(String s, int index,List<String> list){
        if(index>=s.length()){
            res.add(new LinkedList<>(list));
            return;
        }
        for(int j=index;j<s.length();j++){
            if(isPalinDrome(s,index,j)){
                list.add(s.substring(index,j+1));
            }else continue;
            partitions(s,j+1,list);
            if(list.size()>0)list.remove(list.size()-1);
        }
        
    }

    public boolean isPalinDrome(String s, int l ,int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r))return false;
            l++;
            r--;
        }
        return true;
    }
     
}