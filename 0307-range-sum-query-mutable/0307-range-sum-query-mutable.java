class NumArray {
    int[] tree;
    int n ;
    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;
        int h = (int)(Math.log(n)/Math.log(2)) + 1;
        int len = (int)Math.pow(2,h+1);
        tree = new int[len];
        build(0,0,n-1);
    }
    
    public void update(int index, int val) {
        update(index, val, 0,0,n-1);
    }
    
    public int sumRange(int left, int right) {
        return query(0,0,n-1,left,right);
    }

    public int query(int node,int start, int end,int left, int right){
        if(right < start || end < left){
            return 0;
        }
        if(left <= start && end <= right){
            return tree[node];
        }
        int mid = (start + end)/2;
        int p1 = query(2*node + 1, start, mid, left, right);
        int p2 = query(2*node + 2, mid + 1, end, left, right);
        return p1 + p2;
    }

    public void update(int index,int val,int node,int start,int end){
        if(start==end){
            nums[index]=val;
            tree[node]=val;
        }else{
            int mid = (start+end)/2;
            if(start<=index && index<=mid){
                update(index, val,node*2+1,start, mid);
            }else{
                update(index, val,node*2+2,mid+1, end);
            }
            tree[node] = tree[node*2+1]+tree[node*2+2];
        }
    }

    public void build(int node, int start, int end){
        if(start==end){
            tree[node] = nums[start];
        }else{
            int mid = (start+end)/2;
            build(node*2+1,start,mid);
            build(node*2+2,mid+1,end);
            tree[node] = tree[node*2+1]+tree[node*2+2];
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */