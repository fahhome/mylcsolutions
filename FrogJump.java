package leetcode;
import java.util.*;

class FrogJump {

    public boolean canCross(int[] stones) {
        int len = stones.length;
        Queue<Jump> q = new LinkedList<>();

        HashSet<Jump> visited = new HashSet<>();

        q.add(new Jump(stones[0], 0));

        HashSet<Integer> hset = new HashSet<>();
        int dest = stones[len - 1];

        for (int i = 0; i < len; i++) {
            hset.add(stones[i]);
        }

        for (int i = 1; i < len; i++) {
            if (q.isEmpty())
                return false;
            while (!q.isEmpty() && (q.peek().pos + q.peek().lj + 1 < stones[i]))
                q.poll();

            if (q.isEmpty())
                return false;

            int cursize = q.size();

            for (int z = 0; z < cursize; z++) {
                Jump front = q.poll();
                int k = front.lj;
                int pos = front.pos;

                for (int l = k - 1; l <= k + 1; l++) {
                    if (l > 0 && hset.contains(pos + l) && pos + l <= dest && !visited.contains(new Jump(pos + l, l))) {
                        if (pos + l == dest)
                            return true;

                        Jump newjump = new Jump(pos + l, l);
                        q.add(newjump);
                        visited.add(newjump);
                    }
                }
            }

        }

        return false;

    }

}

class Jump {
    int pos;
    int lj;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + lj;
        result = prime * result + pos;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Jump other = (Jump) obj;
        if (lj != other.lj)
            return false;
        if (pos != other.pos)
            return false;
        return true;
    }

    Jump(int pos, int lj) {
        this.pos = pos;
        this.lj = lj;
    }
}