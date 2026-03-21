import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            long c = sc.nextLong();
            long k = sc.nextLong();

            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            Arrays.sort(a);

            PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());

            int i = 0;

            while (true) {

                // push all killable monsters
                while (i < n && a[i] <= c) {
                    pq.add(a[i]);
                    i++;
                }

                if (pq.isEmpty()) break;

                long best = pq.poll();

                // use flips on this monster
                if (k > 0) {
                    best += k;
                    k = 0;
                }

                c += best;
            }

            sb.append(c).append("\n");
        }

        System.out.print(sb);
    }
}