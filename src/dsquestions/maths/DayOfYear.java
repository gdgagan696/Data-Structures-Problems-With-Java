package dsquestions.maths;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DayOfYear {
    public static int dayOfYear(String date) {
        int days[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int y=Integer.parseInt(date.substring(0,4));
        int m=Integer.parseInt(date.substring(5,7));
        int d=Integer.parseInt(date.substring(8));
        if(m>2 && (y%4==0 && (y%100!=0 || y%400==0))){
            d++;
        }
        while (--m>0){
            d+=days[m-1];
        }
        return d;
    }

    public static void main(String[]args){
        System.out.println(dayOfYear("2004-03-01"));
    }
}
