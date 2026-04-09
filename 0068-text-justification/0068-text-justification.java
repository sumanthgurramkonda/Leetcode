class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> res = new ArrayList<>();
        int left = 0;
        int len = words[0].length();
        for(int right=1;right<words.length;right++){
            if(len+words[right].length()+1 <= maxWidth){
                len += words[right].length()+1;
            }else{
                res.add(generateWord(words, maxWidth, left, right-1));
                len = words[right].length();
                left=right;
            }
        }
        String lastWord = generateWord(words,maxWidth,left,words.length-1);
        String lastWords[] = lastWord.split(" ");
        StringBuilder last = new StringBuilder();
        for(String s : lastWords){
            if(s!=""){
                last.append(s);
                if(last.length()<maxWidth) last.append(" ");
            }
        }
        while(last.length()<maxWidth) last.append(" ");
        res.add(last.toString());
        return res;
    }

    public String generateWord(String[] words, int maxWidth,int left, int right){
        
        int len = 0;
        for(int i=left;i<=right;i++){
            len += words[i].length();
        }

        int remLen = maxWidth-len;
        int spaceCount = right-left;
        int midSpaces = spaceCount==0 ? 0 : remLen/spaceCount;
        int remSpaces = spaceCount==0 ? remLen : remLen%spaceCount;

        StringBuilder space = new StringBuilder();
        StringBuilder res = new StringBuilder();

        for(int i=0;i<midSpaces;i++){
            space.append(" ");
        }

        for(int i=left;i<right;i++){
            res.append(words[i]);
            res.append(space.toString());
            if(remSpaces>0){
                res.append(" ");
                remSpaces--;
            }
        }
        res.append(words[right]);
        while(remSpaces>0){
            res.append(" ");
            remSpaces--;
        }
        return res.toString();
    }

}




