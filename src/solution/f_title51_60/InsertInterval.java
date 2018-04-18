package solution.f_title51_60;

import helper.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定非重叠区间集合，将新区间插入，如果必要则合并已有区间
 * 区间根据起始值排序
 * <p>
 * 思路：
 * 若当前interval的end小于newInterval的start，则新的区间在当前遍历到的区间的后面，并且没有重叠
 * 所以res添加当前的interval；
 * 若当前interval的start大于newInterval的end，则新的区间比当前遍历到的区间要前面，并且没有重叠
 * 所以把newInterval添加到res里，并更新newInterval为当前的interval；
 * 若当前interval与newInterval有重叠，merge interval并更新新的newInterval为merge后的。
 */
public class InsertInterval {
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        for (Interval each : intervals) {
            if (each.end < newInterval.start) {
                res.add(each);
            } else if (each.start > newInterval.end) {
                res.add(newInterval);
                newInterval = each;
            } else if (each.end >= newInterval.start || each.start <= newInterval.end) {
                int nStart = Math.min(each.start, newInterval.start);
                int nEnd = Math.max(each.end, newInterval.end);
                newInterval = new Interval(nStart, nEnd);
            }
        }
        res.add(newInterval);
        return res;
    }

    public static void main(String[] args) {
        Interval i11 = new Interval(1, 3);
        Interval i12 = new Interval(6, 9);
        List<Interval> list1 = new ArrayList<>();
        list1.add(i11);
        list1.add(i12);
        Interval i13 = new Interval(2, 5);
        List<Interval> listResult1 = insert(list1, i13);
        for (Interval i : listResult1) {
            System.out.print("[" + i.start + ", " + i.end + "],");
        }
        System.out.println();

        Interval i21 = new Interval(1, 2);
        Interval i22 = new Interval(3, 5);
        Interval i23 = new Interval(6, 7);
        Interval i24 = new Interval(8, 10);
        Interval i25 = new Interval(12, 16);
        List<Interval> list2 = new ArrayList<>();
        list2.add(i21);
        list2.add(i22);
        list2.add(i23);
        list2.add(i24);
        list2.add(i25);
        Interval i26 = new Interval(4, 9);
        List<Interval> listResult2 = insert(list2, i26);
        for (Interval i : listResult2) {
            System.out.print("[" + i.start + ", " + i.end + "],");
        }
        System.out.println();
    }

}
