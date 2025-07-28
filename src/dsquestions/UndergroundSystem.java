package dsquestions;

import java.util.HashMap;

public class UndergroundSystem {
    private HashMap<Integer, HashMap<String, Integer>> checkIn;
    private HashMap<String, HashMap<String, int[]>> average;

    public UndergroundSystem() {
        checkIn = new HashMap<>();
        average = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        HashMap<String, Integer> temp = new HashMap<>();
        temp.put(stationName, t);
        checkIn.put(id, temp);
    }

    public void checkOut(int id, String stationName, int t) {
        if (checkIn.containsKey(id)) {
            HashMap<String, Integer> checkOut = checkIn.get(id);
            checkIn.remove(id);
            String startStation = (String) checkOut.keySet().toArray()[0];
            int startTime = checkOut.get(startStation);
            HashMap<String, int[]> hm = average.getOrDefault(startStation, new HashMap<>());
            int[] temp = hm.getOrDefault(stationName, new int[2]);
            temp[0]++;
            temp[1] += t - startTime;
            hm.put(stationName, temp);
            average.put(startStation, hm);
        }

    }

    public double getAverageTime(String startStation, String endStation) {
        HashMap<String, int[]> hm = average.get(startStation);
        int[] temp = hm.get(endStation);
        return temp[1] / temp[0];

    }

    public static void main(String[] args) {

    }
}
