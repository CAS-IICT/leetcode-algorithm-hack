using System;
public class Solution {
    static void Main(string[] args) {
        int[] nums = {2,7,11,15};
        var target = 9;
        var result = new Solution().TwoSum(nums,target);
        Console.WriteLine("[{0}]", string.Join(", ", result));
    }
    public int[] TwoSum(int[] nums, int target) {
        for(int i=0; i<nums.Length;i++){
            for(int j=i+1;j<nums.Length;j++){
                if(nums[i]+nums[j]==target) return new int[]{i,j};
            }
        }
        return null;
    }
}
