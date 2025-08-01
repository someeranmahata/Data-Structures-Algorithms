package Dyanamic_Programming;

public class Kpartitionwithsubsetsum {
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % k != 0) {
            return false;
        }

        int targetSum = totalSum / k;
        boolean[] visited = new boolean[nums.length];

        return backtrack(nums, k, 0, 0, targetSum, visited);
    }

    public static boolean backtrack(int[] nums, int k, int startIndex, int currentSum, int targetSum, boolean[] visited) {
        if (k == 0) {
            return true;
        }

        if (currentSum == targetSum) {
            return backtrack(nums, k - 1, 0, 0, targetSum, visited);
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (!visited[i] && currentSum + nums[i] <= targetSum) {
                visited[i] = true;
                if (backtrack(nums, k, i + 1, currentSum + nums[i], targetSum, visited)) {
                    return true;
                }
                visited[i] = false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] ar = {4,3,2,3,5,2,1};
        System.out.println(canPartitionKSubsets(ar, 4));
    }
}
