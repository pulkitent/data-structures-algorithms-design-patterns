package com.pulkit.datastructures_algorithms.done.arrays;

import java.util.*;

import static java.lang.System.out;

public class MergeIntervals {
    public static void main(String[] args) {
        Interval interval1 = new Interval(1, 5);
        List<Interval> intervals = Arrays.asList(interval1, new Interval(3, 7), new Interval(4, 6),
                new Interval(6, 8));

        //Another Test case
        //Interval interval1 = new Interval(1, 5);
        //List<Interval> intervals = Arrays.asList(interval1, new Interval(3, 7), new Interval(6, 8),
        // new Interval(10, 12), new Interval(11, 15));

        //Another Test case
        //Interval interval1 = new Interval(2, 10);
        //Interval interval2 = new Interval(4, 12);
        //Interval interval3 = new Interval(13, 16);
        //Interval interval4 = new Interval(19, 20);
        //Interval pair5 = new Interval(20, 24);
        //List<Interval> intervals = Arrays.asList(interval1, interval2, interval3, interval4, pair5);

        //Another Test case
        //Interval interval1 = new Interval(1, 10);
        //Interval interval2 = new Interval(2, 9);
        //Interval interval3 = new Interval(3, 8);
        //Interval interval4 = new Interval(4, 7);
        //Interval interval5 = new Interval(5, 6);
        //Interval interval6 = new Interval(6, 6);
        //List<Interval> intervals = Arrays.asList(interval1, interval2, interval3, interval4, interval5, interval6);

        intervals.sort(new IntervalComparator());
        ArrayList mergedList = new ArrayList();

        int mergedIntervalStart = interval1.start;
        int mergedIntervalEnd = interval1.end;

        for (Interval interval : intervals) {
            if (mergedIntervalEnd >= interval.start) {
                if (mergedIntervalEnd < interval.end) {
                    mergedIntervalEnd = interval.end;
                }
            } else {
                mergedList.add(new Interval(mergedIntervalStart, mergedIntervalEnd));
                mergedIntervalStart = interval.start;
                mergedIntervalEnd = interval.end;
            }
        }

        mergedList.add(new Interval(mergedIntervalStart, mergedIntervalEnd));
        mergedList.forEach(out::println);
    }
}

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return start + " " + end;
    }
}

class IntervalComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval o1, Interval o2) {
        if (o1.start > o2.start) {
            return 1;
        }
        return -1;
    }
}