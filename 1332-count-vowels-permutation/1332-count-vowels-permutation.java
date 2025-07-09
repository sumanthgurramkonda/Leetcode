class Solution {
    List<String> list = new ArrayList();
    int l = 0;
    public int countVowelPermutation(int n) {
        
        // return permutations(n);
        return permutationCount(n);
    }

    public int permutationCount(int n){

        int mod = 1000000007;

        long a=1,e=1,i=1,o=1,u=1;
        for(int j=1;j<n;j++){

            long aNext = e;
            long eNext = (a+i)%mod;
            long iNext = (a+e+o+u)%mod;
            long oNext = (i+u)%mod;
            long uNext = a;
            a = aNext;
            e = eNext;
            i = iNext;
            o = oNext;
            u = uNext;
        }
        return (int)((a+e+i+o+u)%mod);
    }

    public int permutations(int n){
        l=n;
        countVowelPerm("a",n);
        countVowelPerm("e",n);
        countVowelPerm("i",n);
        countVowelPerm("o",n);
        countVowelPerm("u",n);
        return list.size();
    }


    public void countVowelPerm(String s,int n){
        int len = s.length();
        if(n==0) {
            return;
        }
        if(s.length()==l) list.add(s);
        char c = s.charAt(len-1);
        if(c=='a'){
            countVowelPerm(s+"e",n-1);
        }else if(c=='e'){
            countVowelPerm(s+"a",n-1);
            countVowelPerm(s+"i",n-1);
        }else if(c=='i'){
            countVowelPerm(s+"a",n-1);
            countVowelPerm(s+"e",n-1);
            countVowelPerm(s+"o",n-1);
            countVowelPerm(s+"u",n-1);
        }
        else if(c=='o'){
            countVowelPerm(s+"i",n-1);
            countVowelPerm(s+"u",n-1);
        }else if(c=='u'){
            countVowelPerm(s+"a",n-1);
        }
    
    }
}



