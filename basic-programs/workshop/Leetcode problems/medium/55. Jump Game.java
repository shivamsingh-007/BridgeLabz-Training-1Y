class Solution {
    public boolean canJump(int[] nums) {
        int j = 0; // farthest reachable index
        for (int i = 0; i < nums.length; i++) {
            if (i > j) return false; // can't reach this index
            int c = nums[i];
            if (i + c > j) {
                j = i + c; // update farthest reachable
            }
        }
        if (j >= nums.length - 1) {
            return true;
        } else {
            return false;
        }
    }
}