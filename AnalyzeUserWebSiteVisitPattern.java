package leetcode;
import java.util.*;

// Works Fine until lexicographical sorting

// ["zkiikgv","zkiikgv","zkiikgv","zkiikgv"]
// [436363475,710406388,386655081,797150921]
// ["wnaaxbfhxp","mryxsjc","oz","wlarkzzqht"]

public class AnalyzeUserWebSiteVisitPattern {

    public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int len = username.length;
        List<Access> accesses = new LinkedList<>();

        HashMap<String, LinkedList<String>> userhmap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            Access access = new Access(username[i], website[i], timestamp[i]);
            userhmap.put(username[i], new LinkedList<String>());
            accesses.add(access);
        }

        Comparator<Access> comparator = new Comparator<Access>() {

            @Override
            public int compare(Access o1, Access o2) {
            // TODO Auto-generated method stub
                if(o2.timestamp < o1.timestamp)
                    return 1;
                return 0;
            }

        };

        Collections.sort(accesses, (access1, access2) -> {
            return access1.timestamp - access2.timestamp;
        });

        HashMap<LinkedList<String>, Integer> hmap = new HashMap<>();
        
        for(Access access : accesses){
            LinkedList<String> userCurrentPattern = new LinkedList<>(userhmap.get(access.user));

            if(userCurrentPattern.size() == 3){
                userCurrentPattern.removeFirst();
                userCurrentPattern.addLast(access.website);
            }else{
                userCurrentPattern.add(access.website);
            }

            if(userCurrentPattern.size() == 3){
                hmap.put(userCurrentPattern, hmap.getOrDefault(userCurrentPattern, 0) +1 );
            }

            userhmap.put(access.user, userCurrentPattern);

        }

        LinkedHashMap<LinkedList<String>, Integer> lhmap = new LinkedHashMap<>();
        hmap.entrySet().stream()
            .sorted(Map.Entry.<LinkedList<String>, Integer>comparingByValue().reversed())
            .forEachOrdered(x -> lhmap.put(x.getKey(),x.getValue()));

        Map.Entry<LinkedList<String>, Integer> entry = lhmap.entrySet().iterator().next();
        int value = entry.getValue();
        LinkedList<String> key = entry.getKey();

        List<LinkedList<String>> listOfPatterns = new LinkedList<>();

        // TreeMap<LinkedList<String>, Integer> treeMap = new TreeMap<>();

        for(Map.Entry<LinkedList<String>, Integer> pair : lhmap.entrySet()){
            if(pair.getValue() != value)
                break;
            listOfPatterns.add(pair.getKey());
        }

        Comparator<List<String>>  listComparator = new Comparator<List<String>>() {

            @Override
            public int compare(List<String> o1, List<String> o2) {
                // TODO Auto-generated method stub
                
                StringBuilder s1 = new StringBuilder();
                StringBuilder s2 = new StringBuilder();

                for(String s : o1)
                    s1.append(s);

                for(String s : o2)
                    s2.append(s);
                
                return s1.compareTo(s2);

                // if(!o1.get(0).equals(o2.get(0)))
                //     return o1.get(0).compareTo(o2.get(0));
                // if (!o1.get(1).equals(o2.get(1)))
                //     return o1.get(1).compareTo(o2.get(1));
                // if (!o1.get(2).equals(o2.get(2)))
                //     return o1.get(2).compareTo(o2.get(2));
                
                //return 0;
            }
            
        };
        Collections.sort(listOfPatterns, listComparator);

        System.out.println(listOfPatterns.size());

        return listOfPatterns.get(0);

    }

    public static void main(String[] args) {
        String[] username  = {"joe","joe","joe","james","james","james","james","mary","mary","mary"};
        int [] timestamp = {1,2,3,4,5,6,7,8,9,10};
        String [] website = {"home","about","career","home","cart","maps","home","home","about","career"};

        System.out.println(mostVisitedPattern(username, timestamp, website));

    }
    
}

class Access {

    String user;
    String website;
    int timestamp;

    public Access(String user, String website, int timestamp) {
        this.user = user;
        this.website = website;
        this.timestamp = timestamp;
    }

}
