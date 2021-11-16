package leetcode;
import java.util.*;


// Important
// Usage Of 3 different data structures in the same problem(Map,List,Queue)
public class WC32P2 {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        LinkedList<Integer> ans = new LinkedList<>();

        int len = ppid.size();

        ArrayDeque<Integer> q = new ArrayDeque<>();

        Map<Integer,LinkedList<Integer>> map = new HashMap<>();// Contains indices of processes whose parent is the key

        for(int i = 0 ; i < len ; i++){
            int ppidthis = ppid.get(i);
            if(map.containsKey(ppidthis)){
                LinkedList<Integer> indices = map.get(ppidthis);
                indices.add(i);
                map.put(ppidthis,indices);
            }else{
                LinkedList<Integer> indices = new LinkedList<>();
                indices.add(i);
                map.put(ppidthis, indices);
            }
        }

        ans.add(kill);

        q.add(kill);

        while(!q.isEmpty()){

            int front = q.poll();

            if(map.containsKey(front)){
                List<Integer> indices = map.get(front);

                for(Integer index : indices){
                    int childprocess = pid.get(index);
                    ans.add(childprocess);
                    q.add(childprocess);
                }
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        
    }
}
