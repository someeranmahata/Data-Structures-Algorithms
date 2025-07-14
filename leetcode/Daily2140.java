package leetcode;

public class Daily2140 {
    static int ans = 0;

    public static int matchPlayersAndTrainers(int[] players, int[] trainers) {
        ans = 0;
        solve(players, trainers, 0);
        return ans;
    }

    public static void solve(int[] p, int[] t, int sum) {
        ans = Math.max(ans, sum);

        for (int i = 0; i < p.length; i++) {
            if (p[i] == 0) continue;
            for (int j = 0; j < t.length; j++) {
                if (t[j] == 0) continue;
                if (p[i] <= t[j]) {
                    int[] ptemp = p.clone();
                    int[] ttemp = t.clone();

                    ptemp[i] = 0;
                    ttemp[j] = 0;

                    solve(ptemp, ttemp, sum + 1);
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] p = {4,7,9};
        int[] t = {8,2,5,8};
        System.out.println(matchPlayersAndTrainers(p, t));

    }
}
