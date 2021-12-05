package leetcode;
import java.util.*;

//https://leetcode.com/problems/search-suggestions-system/submissions/
public class SuggestedProducts {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        List<List<String>> ans = new LinkedList<>();

        Arrays.sort(products);

        int len = searchWord.length();

        for (int i = 1; i <= len; i++) {
            String searchsubstr = searchWord.substring(0, i);
            List<String> matches = new LinkedList<>();
            for (int j = 0; j < products.length; j++) {
                if (matches.size() == 3)
                    break;
                String product = products[j];
                if (product.length() >= i && product.substring(0, i).equals(searchsubstr)) {
                    matches.add(product);
                }
            }

            ans.add(matches);
        }

        return ans;

    }
    public static void main(String[] args) {
        
    }
}
