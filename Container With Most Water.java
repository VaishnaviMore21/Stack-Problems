class Solution {
    public int maxWater(int nums[]) {
        // Code Here
            if (nums == null || nums.length < 2) return 0;
        int i=0;
        int j=nums.length-1;
        int mx = Integer.MIN_VALUE;
        while(i<j)
        {
            int water=(j-i)*Math.min(nums[i],nums[j]);
            mx=Math.max(water,mx);
            if(nums[i]<nums[j])
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        return mx;
    }
}
