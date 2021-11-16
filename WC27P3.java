package leetcode;
import java.util.*;

// 2^31 - 1 = 2147483647 // Maximum value of 32 bit signed integer is this
// 2^32 - 1 = 4294967295 // Maximum value of 32 bit unsigned integer is this
// IMPORTANT -- Bubble sort
// Note Array to List and Array to List are not straightforward in JAVA.
// use List<String> list = ArrayToListConversion(array);  wherethis function is a generic custom function
// Next Greater element
//https://www.geeksforgeeks.org/list-array-java/
//String[] arr = list.stream().toArray(String[] ::new);
//String[] arr = list.toArray(new String[0]);
// https://www.geeksforgeeks.org/program-to-convert-array-to-list-in-java/

// below code from above does not work


// public static<T> List<T> convertArrayToList(T array[]){

// // Create the List by passing the Array
// // as parameter in the constructor
// List<T>list=new ArrayList<>();

// // Add the array to list
// Collections.addAll(list,array);


// // Return the converted List
// return list;}

public class WC27P3 {

    public static boolean isGreaterThanMax(ArrayList<Integer> num){

        List<Integer> max = new LinkedList<>();
        max.add(2);
        max.add(1);
        max.add(4);
        max.add(7);
        max.add(4);
        max.add(8);
        max.add(3);
        max.add(6);
        max.add(4);
        max.add(7);

        if(num.size() < max.size())
            return false;
        for(int i = 0; i < num.size(); i++){
            if(max.get(i) > num.get(i))
                return false;
            else if(max.get(i) < num.get(i))
                return true;
        }

        return false;

    }


    public static int nextGreaterElement(int n) {

        int ans = -1;

        ArrayList<Integer> nlist = new ArrayList<>();

        if(n / 10  == 0)
            return -1;

        int prevdigit = n%10;
        nlist.add(0, prevdigit);
        n = n/10;
        int flag = 0;

        int[] arr = new int[1];
    

        while(n > 0){
            int curdigit = n%10;

            if(curdigit < prevdigit){
                flag = 1;
                nlist.remove(0);
                nlist.add(0,curdigit);
                nlist.add(0,prevdigit);
                int cursize = nlist.size();

                int i = 1;

                int minindex = -1;

                for(int j = 1 ; j < cursize; j++){
                    if(nlist.get(j) > curdigit && nlist.get(j) < prevdigit)
                        {
                            if(minindex == -1)
                                minindex = j;
                            else{
                                if(nlist.get(j) < nlist.get(minindex))
                                    minindex = j;
                            }
                        }
                }

                if(minindex != -1){
                    int temp = nlist.get(0);
                    nlist.set(0, nlist.get(minindex));
                    nlist.set(minindex, temp);
                }

                for(i = 1; i < cursize; i++){
                    for(int j= 1; j < cursize-1 ; j++){
                        if(nlist.get(j) >= nlist.get(j+1)){
                            int temp = nlist.get(j);
                            nlist.set(j, nlist.get(j+1));
                            nlist.set(j+1, temp);
                        }
                    }
                }

                n /= 10;
                break;

            }else{
                nlist.add(0, curdigit);
                prevdigit = curdigit;
            }
            n /= 10;

        }

        if(flag == 0)
            return -1;
        else{
            while(n > 0){
                nlist.add(0, n%10);
                n/=10;
            }
        }

        if(isGreaterThanMax(nlist))
            return -1;
        else{
            int sum = 0;
            for(int i = 0; i < nlist.size(); i++){
                sum = sum*10 + nlist.get(i);
            }
            return sum;
        }

        
    }

    public static <T> List<T> ArrayToListConversion(T array[]) {
        // creating the constructor of the List class
        List<T> list = new ArrayList<>();
        // using for-each loop to iterate over the array
        for (T t : array) {
            // adding each element to the List
            list.add(t);
        }
        // returns the list converted into Array
        return list;
    }

    public static void main(String[] args) {
        int n = 2147483486;
        System.out.println(nextGreaterElement(n));
    }
}
