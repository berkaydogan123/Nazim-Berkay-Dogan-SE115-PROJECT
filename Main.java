// Main.java — Students version
import java.io.*;
import java.util.*;

public class Main {
    static final int MONTHS = 12;
    static final int DAYS = 28;
    static final int COMMS = 5;
    static String[] commodities = {"Gold", "Oil", "Silver", "Wheat", "Copper"};
    static String[] months = {"January","February","March","April","May","June",
                              "July","August","September","October","November","December"};
    

    // ======== REQUIRED METHOD LOAD DATA (Students fill this) ========
    public static void loadData() {

    }

    // ======== 10 REQUIRED METHODS (Students fill these) ========

    public static String mostProfitableCommodityInMonth(int month) {
        if (month < 0 || month >= MONTHS) return "INVALID_MONTH";

        int maxProfit = -999999999;
        String winner = "";

        for (int c = 0; c < COMMS; c++) {
            int currentTotal = 0;
            for (int d = 1; d <= DAYS; d++) {
                currentTotal += data[month][d][c];
            }
            if (currentTotal > maxProfit) {
                maxProfit = currentTotal;
                winner = commodities[c];
            }
        }
        return winner + " " + maxProfit;
    }

    public static int totalProfitOnDay(int month, int day) {
        if (month < 0 || month >= MONTHS || day < 1 || day > DAYS) return -99999;

        int total = 0;
        for (int c = 0; c < COMMS; c++) {
            total += data[month][day][c];
        }
        return total;

    }

    public static int commodityProfitInRange(String commodity, int from, int to) {

        int cIdx = -1;
        for(int i=0; i<COMMS; i++) if(commodities[i].equals(commodity)) cIdx = i;

        if (cIdx == -1 || from < 1 || to > DAYS || from > to) return -99999;

        int sum = 0;
        for (int m = 0; m < MONTHS; m++) {
            for (int d = from; d <= to; d++) {
                sum += data[m][d][cIdx];
            }
        }
        return sum;
    }

    public static int bestDayOfMonth(int month) {

        if (month < 0 || month >= MONTHS) return -1;

        int bestDay = 1;
        int maxP = -999999999;

        for (int d = 1; d <= DAYS; d++) {
            int dailyTotal = 0;
            for (int c = 0; c < COMMS; c++) {
                dailyTotal += data[month][d][c];
            }
            if (dailyTotal > maxP) {
                maxP = dailyTotal;
                bestDay = d;
            }
        }
        return bestDay;
    }
    
    public static String bestMonthForCommodity(String comm) {
        int cIdx = -1;
        for(int i=0; i<COMMS; i++) if(commodities[i].equals(comm)) cIdx = i;
        if (cIdx == -1) return "INVALID_COMMODITY";

        int maxP = -999999999;
        int bestM = 0;
        for (int m = 0; m < MONTHS; m++) {
            int monthlyP = 0;
            for (int d = 1; d <= DAYS; d++) {
                monthlyP += data[m][d][cIdx];
            }
            if (monthlyP > maxP) {
                maxP = monthlyP;
                bestM = m;
            }
        }
        return months[bestM];





    }

    public static int consecutiveLossDays(String comm) { 
        return 1234; 
    }
    
    public static int daysAboveThreshold(String comm, int threshold) { 
        return 1234; 
    }

    public static int biggestDailySwing(int month) { 
        return 1234; 
    }
    
    public static String compareTwoCommodities(String c1, String c2) { 
        return "DUMMY is better by 1234"; 
    }
    
    public static String bestWeekOfMonth(int month) { 
        return "DUMMY"; 
    }

    public static void main(String[] args) {
        loadData();
        System.out.println("Data loaded – ready for queries");
    }
}