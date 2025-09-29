class Solution {
    public int longestConsecutive(int[] nums) {
        // int count=1;
		// int maxCount = 0;
		// Set<Integer> set = new HashSet<Integer>();
		// for(int i : nums)set.add(i);
		// Set<Integer> set1 = new HashSet<Integer>();
		// Iterator iterator = set.iterator();	
		
		// while(iterator.hasNext()) {
		// 	int val = (int) iterator.next();
		// 	if(!set1.contains(val-1)) {
		// 		set1.add(val);
		// 		while(set.contains(++val)) {
		// 			count++;
		// 			set1.add(val);
		// 		}
		// 	}
		// 	maxCount = Math.max(maxCount, count);
		// 	count=1;
		// }
		// return maxCount;
        return sol(nums);
    }

    public int sol(int[] nums){

        Set<Integer> set = new HashSet();
        for(int n : nums)set.add(n);
        int res = 0;
        for(int num : nums){
            int count = 0;
            if(set.contains(num)){
                int n = num;
                while(set.contains(n)){
                    set.remove(n);
                    n++;
                    count++;
                }
                n = num-1;
                while(set.contains(n)){
                    set.remove(n);
                    n--;
                    count++;
                }
            }
            res = Math.max(res,count);
        }
        return res;
    }
}