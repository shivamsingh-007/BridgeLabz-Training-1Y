class Solution {
    public int singleNumber(int[] nums) {
        int d = 0;
        for (int i = 0; i < nums.length; i++) {
            int k = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    k += 1; 
                }
            }
            if (k == 1) {
                d = nums[i];
                break;
            }
        }
        return d;
    }
}