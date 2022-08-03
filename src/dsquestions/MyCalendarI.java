package dsquestions;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarI {

    TreeMap<Integer, Integer> calendar;

    public MyCalendarI() {
        calendar = new TreeMap<>();
        calendar.put(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> pair = calendar.higherEntry(start);
        boolean res = end <= pair.getValue();
        if (res) {
            calendar.put(end, start);
        }
        return res;
    }

    public static void main(String[] args) {
        MyCalendarI myCalendarI = new MyCalendarI();
        System.out.println(myCalendarI.book(47, 50));
        System.out.println(myCalendarI.book(15, 25));
        System.out.println(myCalendarI.book(20, 30));
    }
}
