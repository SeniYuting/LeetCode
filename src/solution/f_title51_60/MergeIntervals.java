package solution.f_title51_60;


import helper.Interval;

import java.util.*;

/**
 * 合并重叠区间
 */
public class MergeIntervals {

    private static class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());

        LinkedList<Interval> merged = new LinkedList<>();
        for (Interval interval : intervals) {
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            } else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }
        return merged;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));
        List<Interval> list = merge(intervals);
        for (Interval l : list) {
            System.out.println(l.start + " " + l.end);
        }
    }

}
