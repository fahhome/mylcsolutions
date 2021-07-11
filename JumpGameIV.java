package leetcode;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// O(2n)
public class JumpGameIV {

    public static int minJumps(int[] arr) {
        int ans = 0;
        int len = arr.length;
        int[] minjumps = new int[len];
        int[] visited = new int[len];
        minjumps[0] = 0;

        if (len == 1)
            return 0;


        Map<Integer,List<Integer> > invertedmap = new LinkedHashMap<>(); // 100-> [0,4] , 404 -> [3,4]

        for(int i = 0 ; i < len ; i++ ){
            if(invertedmap.containsKey(arr[i]))
                {
                    List<Integer> indices = invertedmap.get(arr[i]);
                    indices.add(i);
                    invertedmap.put(arr[i], indices);
                }
            else{
                List<Integer> indices = new LinkedList<>();
                indices.add(i);
                invertedmap.put(arr[i], indices);
            }
        }

        Queue<JumpGameIVPair> q = new LinkedList<>();
        q.add(new JumpGameIVPair(arr[0], 0));
        visited[0] =1 ;

        while(!q.isEmpty()){
            JumpGameIVPair front = q.poll();
            int curval = front.value;
            int curindex = front.index;
            int curjumps = minjumps[curindex];

            if(curindex + 1 == len-1 || invertedmap.get(curval).contains(len-1))
            {
                ans = minjumps[curindex] + 1 ;
                break;
            }

            else{
                if(curindex -1 >=0 && visited[curindex-1] == 0){
                    q.add(new JumpGameIVPair(arr[curindex-1], curindex-1));
                    visited[curindex-1] =1 ;
                    minjumps[curindex - 1] = curjumps + 1;
                }

                if (curindex + 1 >= 0 && visited[curindex + 1] == 0) {
                    q.add(new JumpGameIVPair(arr[curindex + 1], curindex + 1));
                    minjumps[curindex + 1 ] = curjumps + 1;
                    visited[curindex + 1] = 1;
                }

                for(int index : invertedmap.get(curval)){
                    if(visited[index] == 0){
                        q.add(new JumpGameIVPair(curval, index));
                        visited[index] = 1;
                        minjumps[index] = curjumps + 1;
                    }
                    invertedmap.put(curval, new LinkedList<Integer>());
                }

            }

        }

        return ans;
    }

    public static void main(String[] args) {
        int [] arr = { 11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13};
        System.out.println(minJumps(arr));
    }
}

class JumpGameIVPair{
    public int value;
    public int index;

    public JumpGameIVPair(int value,int index){
        this.value = value;
        this.index = index ;
    }
}
