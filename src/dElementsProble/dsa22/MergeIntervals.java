package dsa22;

import java.util.*;

public class MergeIntervals {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // number of intervals
        System.out.print("Enter number of intervals: ");
        int n = sc.nextInt();

        int intervals[][] = new int[n][2];

        // input intervals
        System.out.println("Enter intervals (start end):");
        for(int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }

        // sort intervals based on start time
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> result = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i = 1; i < n; i++) {

            // overlapping interval
            if(intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            }

            else {
                result.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        // add last interval
        result.add(new int[]{start, end});

        // output
        System.out.println("Merged Intervals:");

        for(int interval[] : result) {
            System.out.println(interval[0] + " " + interval[1]);
        }

        sc.close();
    }
}
