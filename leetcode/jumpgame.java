package leetcode;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class jumpgame {
    public static int jump(int[] nums) {
        int near = 0, far = 0, jumps = 0;

        while (far < nums.length - 1) {
            int farthest = 0;
            for (int i = near; i <= far; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            near = far + 1;
            far = farthest;
            jumps++;
        }

        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        System.out.println(jump(nums));
    }
}
