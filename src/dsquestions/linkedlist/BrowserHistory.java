package dsquestions.linkedlist;

import java.util.LinkedList;
import java.util.List;

public class BrowserHistory {

    String homepage;
    List<String> pages;
    int current;
    int size;

    public BrowserHistory(String homepage) {

        this.homepage = homepage;
        pages = new LinkedList<>();
        pages.add(homepage);
        current = 0;
        size = 1;
    }

    public void visit(String url) {

        current++;
        pages.add(current, url);
        size = current + 1;

    }

    public String back(int steps) {

        while (current > 0 && steps-- > 0) {
            current--;
        }
        return pages.get(current);
    }

    public String forward(int steps) {

        while (current + 1 < size && steps-- > 0) {
            current++;
        }
        return pages.get(current);

    }

    public static void main(String[] args) {

        BrowserHistory browserHistory = new BrowserHistory("zav");
        browserHistory.visit("kni");
        System.out.println(browserHistory.back(7));
        System.out.println(browserHistory.back(7));
        System.out.println(browserHistory.forward(5));
        System.out.println(browserHistory.forward(1));
        browserHistory.visit("pwrrbnw");
        browserHistory.visit("mosohif");
        System.out.println(browserHistory.back(9));
    }

}
