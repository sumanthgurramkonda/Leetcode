class Solution {

    // class Node{
    //     Node left, right;
    //     int val=0, sum=0, dup=1; 
    // }

    public List<Integer> countSmaller(int[] nums) {
        
        int n = nums.length;

        List<Integer> res = new ArrayList<>();
        List<Integer> sorted = new ArrayList<>();
        for(int i=n-1;i>=0;i--){
            int ind = binarySearch(sorted,nums[i]);
            res.add(ind);
            sorted.add(ind, nums[i]);
        }
        Collections.reverse(res);
        return res;

        // Integer[] res = new Integer[n];
        // Node root = null;
        // for(int i=n-1;i>=0;i--){
        //     root = dfs(root,nums[i],res,i,0);
        // }
        // return Arrays.asList(res);
    }

    public int binarySearch(List<Integer> sorted,int target){
        int start = 0, end = sorted.size()-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(sorted.get(mid)<target){
                start = mid+1;
            }else end = mid-1;
        }
        return start;
    }

    // public Node dfs(Node root, int val, Integer[] res, int index,int count){
    //     if(root==null){
    //         root = new Node();
    //         root.val = val;
    //         res[index]=count;

    //     }else if(root.val==val){
    //         root.dup++;
    //         res[index]=count+root.sum;
    //     }else if(root.val>val){
    //         root.sum++;
    //         root.left = dfs(root.left,val,res,index,count);
    //     }else{
    //         root.right = dfs(root.right,val,res,index,count+root.dup+root.sum);
    //     }
    //     return root;
    // }
}




