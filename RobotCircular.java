package leetcode;

import java.util.*;


// Queue is actually not needed here
public class RobotCircular {

    public static String isCircular(String s) {
        // code here
        Queue<Tripletthis> q = new LinkedList<>();
        int len = s.length();

        q.add(new Tripletthis(0, 0, 0));

        for (int i = 0; i < len; i++) {

            Tripletthis popped = q.poll();
            char nextInst = s.charAt(i);
            int curdir = popped.dir;
            int curx = popped.x;
            int cury = popped.y;

            if (nextInst == 'G') {

                int nxtx = curx;
                int nxty = cury;
                int nxtdir = curdir;

                if (curdir == 0) {
                    nxty = cury + 1;
                } else if (curdir == 1) {
                    nxtx = curx + 1;
                } else if (curdir == 2) {
                    nxtx = curx - 1;
                } else {
                    nxty = cury - 1;
                }

                q.add(new Tripletthis(nxtx, nxty, nxtdir));

            } else if (nextInst == 'L') {

                int nxtdir = -1;
                if (curdir == 0) {
                    nxtdir = 2;
                } else if (curdir == 1) {
                    nxtdir = 0;
                } else if (curdir == 2) {
                    nxtdir = 3;
                } else {
                    nxtdir = 1;
                }

                q.add(new Tripletthis(curx, cury, nxtdir));
            } else {
                int nxtdir = -1;
                if (curdir == 0) {
                    nxtdir = 1;
                } else if (curdir == 1) {
                    nxtdir = 3;
                } else if (curdir == 2) {
                    nxtdir = 0;
                } else {
                    nxtdir = 2;
                }

                q.add(new Tripletthis(curx, cury, nxtdir));

            }

        }

        Tripletthis popped = q.peek();
        if (popped.x == 0 && popped.y == 0)
            return "Circular";
        else
            return "Not Circular";

    }

    public static void main(String[] args) {
        System.out.println(isCircular("GLGLGLG"));
    }
    
}

class Tripletthis {
    public int x;
    public int y;
    public int dir;

    public Tripletthis(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}