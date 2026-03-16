class Solution {

    Boolean[] visited;
    public boolean canJump(int[] nums) {
        // visited = new Boolean[nums.length];

        int max = 0;
        for(int i=0;i<nums.length-1;i++){
            max = Math.max(max,nums[i]+i);
            if(max==i)return false;
            if(max>=nums.length)return true;
        }
        return max>=nums.length-1;
        // return canJump(nums,0);
    }

    public boolean canJump(int[] nums, int index){
        if(index>=nums.length-1) return true;
        if(visited[index]!=null)return visited[index];
        boolean canReachEnd = false;
        for(int i=index;i<index+nums[index];i++){
            canReachEnd |= canJump(nums, i+1);
            if(canReachEnd)return true;
        }
        return visited[index] = canReachEnd;
    }
}