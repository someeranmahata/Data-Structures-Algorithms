package leetcode;
import java.util.*;
public class daily1353 {
    static int ans = 0;

    public static int maxEvents(int[][] events) {

        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int lastDay = 0;
        for (int[] e : events) lastDay = Math.max(lastDay, e[1]);
        int[] visit = new int[lastDay + 1];
        maxEvents(events, visit, 0, 0);
        return ans;
    }

    public static void maxEvents(int[][] nums, int[] visit, int idx, int count) {
        if (idx == nums.length) {
            ans = Math.max(ans, count);
            return;
        }

        for (int day = nums[idx][0]; day <= nums[idx][1]; day++) {
            if (visit[day] == 0) {
                int[] temp = visit.clone();
                temp[day] = 1;
                maxEvents(nums, temp, idx + 1, count + 1);
                break;
            }
        }
        maxEvents(nums, visit, idx + 1, count);
    }

    public static void main(String[] args) {
        int[][] temp= {{1,1},{5,5},{1,2},{2,2}};
        System.out.println(maxEvents(temp));
    }
}
