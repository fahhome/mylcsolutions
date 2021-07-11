package leetcode;

import java.util.LinkedList;
import java.util.List;

public class BrowserHistory {
    private List<String>  urls;
    private int currentptr ; 
    public BrowserHistory(String homepage) {
        this.urls = new LinkedList<>();
        this.currentptr = 0 ;
        this.urls.add(homepage);
    }

    public void visit(String url) {
        int currentsize  = urls.size();
        int i = currentptr + 1 ;
        while(i < currentsize)
            {
                urls.remove(currentptr + 1); //NOTE: That using LinkedList on remove() the elements are shifted by index so you have to use this approach 
                i++;
            }
        urls.add(url);
        currentptr++;
    }

    public String back(int steps) {
        int i = 0;
        while(currentptr > 0 && i<steps){
            i++;
            currentptr--;
        }
        return  urls.get(currentptr);
    }

    public String forward(int steps) {
        int i = 0 ; 
        while(currentptr < urls.size()-1 && i < steps){
            i++;
            currentptr++;
        }

        return urls.get(currentptr);
    }
    public static void main(String[] args) {
        BrowserHistory obj = new BrowserHistory("leetcode.com");
        obj.visit("url1.com");
        obj.visit("url2.com");
        System.out.println(obj.back(1));
        System.out.println(obj.forward(1));
        System.out.println(obj.back(2));
        obj.visit("google.com");
        obj.visit("arsenal.com");
        System.out.println(obj.back(1));
    }
}
