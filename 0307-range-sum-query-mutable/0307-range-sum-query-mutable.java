class NumArray {
    private int[] tree;
    private int n;
    public NumArray(int[] nums) {
        this.n = nums.length;
        this.tree = new int[4*n];
        buildTree(nums,0,n-1,0);
    }

    public void buildTree(int[] nums, int l, int r, int node){
        if(l==r){
         tree[node]=nums[l];
         return;
        }
        int mid = (l+r)/2;
        buildTree(nums,l,mid, node*2+1);
        buildTree(nums,mid+1,r, node*2+2);
        tree[node] = tree[node*2+1]+tree[node*2+2];
    }
    
    public void update(int index, int val) {
        update(index,val,0,n-1,0);
    }

    public void update(int index, int val, int l, int r,int node){
        if(l==r){
            tree[node]=val;
            return;
        }
        int mid = (l+r)/2;
        if(index<=mid){
            update(index, val, l, mid, node*2+1);
        }else{
            update(index, val, mid+1, r, node*2+2);
        }
        tree[node] = tree[node*2+1] + tree[node*2+2];

    }
    
    public int sumRange(int left, int right) {
        return sumRange(left,right,0,n-1,0);
    }

    public int sumRange(int left, int right, int l, int r, int node){
        if(r<left || l>right)return 0;
        if (left <= l && r <= right) return tree[node];
        int mid = (l+r)/2;
        return sumRange(left,right,l,mid,node*2+1)
                + sumRange(left,right,mid+1,r,node*2+2);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */