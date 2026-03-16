class Solution {

    Boolean[] visited;
    public boolean canJump(int[] nums) {
        if(nums.length<=1)return true;
        visited = new Boolean[nums.length];
        return canJump(nums,0);
    }

    public boolean canJump(int[] nums, int index){
        if(index==nums.length-1) return true;
        if(index>=nums.length) return false;
        if(visited[index]!=null)return visited[index];
        boolean canReachEnd = false;
        for(int i=index;i<index+nums[index];i++){
            canReachEnd |= canJump(nums, i+1);
            if(canReachEnd)return true;
        }
        return visited[index] = canReachEnd;
    }
}