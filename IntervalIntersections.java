package leetcode;

import java.util.LinkedList;
import java.util.List;

public class IntervalIntersections {


    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int len1 = firstList.length;
        int len2 = secondList.length;

        List<List<Integer>> list = new LinkedList<>();
        int i = 0;
        int j = 0;

        while (i < len1 && j < len2) {

            if (firstList[i][0] > secondList[j][secondList[j].length - 1]
                    || secondList[j][0] > firstList[i][firstList[i].length - 1]) {

            } else {
                List<Integer> innerList = new LinkedList<>();
                innerList.add(Math.max(firstList[i][0], secondList[j][0]));
                innerList.add(Math.min(firstList[i][firstList[i].length - 1], secondList[j][secondList[j].length - 1]));
                list.add(innerList);
            }

            if (firstList[i][firstList[i].length - 1] <= secondList[j][secondList[j].length - 1]) {
                i++;
            } else if (firstList[i][firstList[i].length - 1] >= secondList[j][secondList[j].length - 1]) {
                j++;
            } else {
                i++;
                j++;
            }

        }

        int[][] reducedans = new int[list.size()][];
        reducedans = list.stream().map(l -> l.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);

        return reducedans;

    }
    public static void main(String[] args) {
        
    }
    
}
