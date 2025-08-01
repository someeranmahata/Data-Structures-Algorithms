package Dyanamic_Programming;
import java.util.*;

public class TragetSum{
    // Method to find the number of combinations using dynamic programming
    public static int countCombinations(int[] nums, int target) {
        // Create a DP array to store the number of ways to achieve each sums
        int[] dp = new int[target + 1];
        dp[0] = 1; // There's one way to make sum 0 (by choosing nothing)

        // Iterate over each number in the array
        for (int num : nums) {
            // Update the DP array from back to front
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[target]; // The number of ways to achieve the target sum
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Input array size and elements
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Input target sum
        System.out.println("Enter the target sum:");
        int target = scanner.nextInt();

        // Calculate and print the result
        int result = countCombinations(nums, target);
        System.out.println("Number of ways to make the sum: " + result);


    }
}
