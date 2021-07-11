package leetcode;

import java.util.Stack;

// Note Here the stack.get() method is used to get an element of a stack by index 
public class BrowserHistoryStack {
    private Stack<String> urlStackTrace;
    private int currPtr;

public BrowserHistoryStack(String homepage) {
    this.urlStackTrace = new Stack<>();
    urlStackTrace.add(homepage);
    this.currPtr = 1;
}

    public void visit(String url) {
        while (currPtr != urlStackTrace.size()) {
            urlStackTrace.pop();
        }
        urlStackTrace.add(url);
        currPtr++;
    }

    public String back(int steps) {
        if (!urlStackTrace.isEmpty()) {
            currPtr = ((currPtr - steps) > 0) ? currPtr - steps : 1;
            return urlStackTrace.get(currPtr - 1);
        }
        return null;
    }

    public String forward(int steps) {
        if (!urlStackTrace.isEmpty()) {
            currPtr = ((currPtr + steps) < urlStackTrace.size()) ? currPtr + steps : urlStackTrace.size();
            return urlStackTrace.get(currPtr - 1);
        }
        return null;
    }
}
