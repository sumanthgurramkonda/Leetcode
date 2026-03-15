class NumArray {

    Node root;
    int n = 0;
    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;
        root = constructTree(0, n-1, nums);
    }
    
    public void update(int index, int val) {
        update(index,val,root);
    }

    public void update(int index, int val, Node root){
       if(root.start==root.end){
        root.val = val;
        this.nums[root.start]=val;
        return;
       }
       int mid = (root.start + root.end)/2;
       if(index<=mid){
            update(index,val,root.left);
       }else{
            update(index,val,root.right);
       }
       root.val = root.left.val+root.right.val;
    }
    
    public int sumRange(int left, int right) {
       return sumRange(left,right,root);
    }

    public int sumRange(int left, int right, Node root){
        if(root.start==left && root.end == right)
            return root.val;
        int mid = (root.start + root.end)/2;

        if(right<=mid){
            return sumRange(left,right,root.left);
        }else if(left>mid){
            return sumRange(left,right,root.right);
        }else{
            return sumRange(left,mid,root.left)+sumRange(mid+1,right,root.right);
        }
    }

    public Node constructTree(int left, int right, int [] nums){
        if(left>right) return null;
        if(left==right){
            return new Node(left,right,nums[left]);
        }
        int mid = left + (right-left)/2;
        Node leftNode = constructTree(left, mid, nums);
        Node rightNode = constructTree(mid+1,right,nums);
        int sum = (leftNode != null ? leftNode.val : 0) + (rightNode != null ? rightNode.val : 0);
        Node root = new Node(left, right, sum);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }


    public class Node{
        Node left;
        Node right;
        int start;
        int end;
        int val;
        public Node(int start, int end, int val){
            this.start = start;
            this.end = end;
            this.val = val;
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */