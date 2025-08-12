import java.util.*;
public class Solutions{
	public static int totalFruit(int[] fruits) {
		if(fruits.length <= 2)  return 2;

		int max = Integer.MIN_VALUE;
		int count =0;

		for(int i = 0; i < fruits.length; i++){
			if(fruits.length - i <= max)
				break;
			count = 0;
			List<Integer> list = new ArrayList<>();
			for(int j = i; j < fruits.length && list.size() < 3; j++){
				if(!list.contains(fruits[j])){
					list.add(fruits[j]);
					if(list.size() >= 3)
						break;
					count++;
				}
				else if(list.contains(fruits[j]))
					count++;

			}

			max = Math.max(max, count);
		}
		return max;
	}
	public static int maxScore(int[] cardPoints, int k) {
		int sum = 0;
		int sumst = 0;

		int len = cardPoints.length - k;

		for(int i = 0; i < cardPoints.length; i++){
			if(i < len)
				sumst += cardPoints[i];
			sum += cardPoints[i];
		}

		if(k == cardPoints.length)   return sum;

		int ans = Integer.MIN_VALUE;
		for(int i = 0; i < len - k; i++){
			ans = Math.max(ans, sum - sumst);
			sumst  = sumst - cardPoints[i] + cardPoints[len + i];
		}
		ans = Math.max(ans, sum - sumst);
		return ans;

	}

	public static int numberOfSubstrings(String s) {
		int count = 0;
		List<String> dp = new ArrayList<>();

		for(int i = 3; i < s.length(); i++){

			for(int j = 0; j <= s.length() - i; j++){
				String temp = s.substring(j, j + i);

				if(dp.contains(temp))
					count++;

				else if(valid(temp)){
					dp.add(temp);
					count++;
				}
			}
		}
		if(count > 0)	return count + 1;
		return valid(s) ? count + 1 : count;
	}
	public static boolean valid(String s){
		boolean a = false;
		boolean b = false;
		boolean c = false;

		for(int i = 0; i < s.length(); i++){
			if(a && b && c)
				return true;
			else if(s.charAt(i) == 'a')  a = true;
			else if(s.charAt(i) == 'b')  b = true;
			else if(s.charAt(i) == 'c')  c = true;
		}
		return a && b && c;
	}
	public static int numberOfSubarrays(int[] nums, int k) {
		int count = 0;
		int i = 0;
		int j = 0;
		int temp = 0;

		while(i <= nums.length - k && j != nums.length){
			while(temp != k && j != nums.length){
				if(nums[j] % 2 != 0)
					temp++;
				j++;
			}
			while(temp == k && j != nums.length){
				count++;
				if(nums[j] % 2 != 0)
					temp++;
				j++;
			}
			while(temp != k && i != nums.length - k){
				if(nums[i] % 2 != 0)
					temp--;
				i++;
			}
		}
		return count;
	}
	public static List<String> addOperators(String num, int target) {
		char[] ar = num.toCharArray();
		List<String> ans = new ArrayList<>();
		solve(ans, ar, target, "" + ar[0], Integer.parseInt("" + ar[0]), 1);
		return ans;
	}
	public static void solve(List<String> ans, char[] num, int target, String temp, int sum, int i){
		if(i == num.length){
			if(target == sum)
				ans.add(temp);
			return;
		}
		solve(ans, num, target, temp + "+" + num[i], sum + Integer.parseInt(num[i] + ""), i + 1);
		solve(ans, num, target, temp + "-" + num[i], sum - Integer.parseInt(num[i] + ""), i + 1);
		solve(ans, num, target, temp + "*" + num[i], sum * Integer.parseInt(num[i] + ""), i + 1);

	}

	public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int[] seg = new int[4*n];
        int ans = 0;
        buildTree(baskets, seg, 0, 0, n - 1);
        System.out.println(Arrays.toString(seg));
        for (int i = 0; i < n; i++) {
            if (fruits[i] > seg[0])
                ans++;
            else {
                if (!solve(seg, 0, 0, n - 1, fruits[i]))
                    ans++;
            }
        }
        return ans;
    }

    private static int buildTree(int[] nums, int[] seg, int idx, int l, int r) {
        if (l == r) {
            seg[idx] = nums[l];
            return seg[idx];
        }
        int mid = l + (r - l) / 2;
        seg[idx] = Math.max(buildTree(nums, seg, 2 * idx + 1, l, mid),
                buildTree(nums, seg, 2 * idx + 2, mid + 1, r));
        return seg[idx];
    }

    private static boolean solve(int[] seg, int idx, int l, int r, int val) {
        if (l == r) {
            seg[idx] = -1;
            return true;
        }
        int mid = l + (r - l) / 2;
        boolean left = false;
        boolean right = false;
        if(seg[2*idx+1]>=val){
            left = solve(seg, 2*idx+1, l, mid, val);
        }else{
            right = solve(seg, 2*idx+2, mid+1, r, val);
        }
        seg[idx] = Math.max(seg[2 * idx + 1], seg[2 * idx + 2]);
        return left || right;
    }
	public static void main(String[] args){
		int[] fr = {4,2,5};
		int[] c = {3,5,4};
		System.out.println(numOfUnplacedFruits(fr, c));	
	}
}