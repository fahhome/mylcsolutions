package leetcode;

public class WC18BP1 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;

        int[] ans = new int[l1];


        for(int i = 0 ; i < l1; i++){
            int n1 = nums1[i];
            int flag = -1;
            for(int j = 0 ; j < l2; j++){
                if(nums2[j] == n1){
                    int k = j+1;
                    while(k < l2){
                        if(nums2[k] > n1){
                            flag =nums2[k];
                            break;
                        }
                        k++;
                    }
                }
            }
            ans[i] = flag;
        }

        return ans;
    }

    public static void main(String[] args) {
        
    }
}
