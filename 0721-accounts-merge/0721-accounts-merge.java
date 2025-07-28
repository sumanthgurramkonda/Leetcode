class Solution {
    Map<String,String> mailToName = new HashMap();
    Map<String,String> childToParent = new HashMap();
    Map<String,Integer> ranks = new HashMap();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        for(List<String> mails : accounts){
            String name = mails.get(0);
            for(int i=1;i<mails.size();i++){
                childToParent.put(mails.get(i),mails.get(i));
                mailToName.put(mails.get(i),name);
                ranks.put(mails.get(i),1);
            }
        }
        
        for(List<String> mails : accounts){
            String firstMail = mails.get(1);
            for(int i=2;i<mails.size();i++){
                union(firstMail,mails.get(i));
            }
        }
        Map<String, Set<String>> result = new HashMap();
        childToParent.forEach((child,parent)->{
            parent = find(child);
            result.putIfAbsent(parent,new TreeSet());
            result.get(parent).add(child);
        });
        List<List<String>> resultList = new ArrayList();
        result.forEach((mail,set)->{
            List<String> list = new  ArrayList();
            list.add(mailToName.get(mail));
            for(String mail1 : set){
                list.add(mail1);
            }
            resultList.add(list);
        });
        return resultList;
    }


    public String find(String email){
        String parent = childToParent.get(email);
        if(!parent.equals(email)){
            childToParent.put(email,find(parent));
        }
        return childToParent.get(email);
    }

    public void union(String firstMail,String mail){
        String parent1 = find(firstMail);
        String parent2 = find(mail);
        if(!parent1.equals(parent2)){
            int rank1 = ranks.get(parent1);
            int rank2 = ranks.get(parent2);

            if (rank1 > rank2) {
                childToParent.put(parent2, parent1);
            } else if (rank2 > rank1) {
                childToParent.put(parent1, parent2);
            } else {
                childToParent.put(parent2, parent1);
                ranks.put(parent1, rank1 + 1); 
            }
        }
    }
}

