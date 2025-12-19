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

        int cIdx = -1;
        for(int i=0; i<COMMS; i++) if(commodities[i].equals(comm)) cIdx = i;
        if (cIdx == -1) return -1;

        int maxStreak = 0;
        int currentStreak = 0;

        for (int m = 0; m < MONTHS; m++) {
            for (int d = 1; d <= DAYS; d++) {
                if (data[m][d][cIdx] < 0) {
                    currentStreak++;
                    if (currentStreak > maxStreak) maxStreak = currentStreak;
                } else {
                    currentStreak = 0;
                }
            }
        }
        return maxStreak;

    }
    
    public static int daysAboveThreshold(String comm, int threshold) {
        int cIdx = -1;
        for(int i=0; i<COMMS; i++) if(commodities[i].equals(comm)) cIdx = i;
        if (cIdx == -1) return -1;

        int count = 0;
        for (int m = 0; m < MONTHS; m++) {
            for (int d = 1; d <= DAYS; d++) {
                if (data[m][d][cIdx] > threshold) count++;
            }
        }
        return count;
    }

    public static int biggestDailySwing(int month) {
        if (month < 0 || month >= MONTHS) return -99999;

        int maxSwing = 0;
        for (int d = 1; d < DAYS; d++) {
            int today = 0;
            int tomorrow = 0;
            for (int c = 0; c < COMMS; c++) {
                today += data[month][d][c];
                tomorrow += data[month][d+1][c];
            }
            int diff = tomorrow - today;
            if (diff < 0) diff = -diff;

            if (diff > maxSwing) maxSwing = diff;
        }
        return maxSwing;


    }
    
    public static String compareTwoCommodities(String c1, String c2) {
        int idx1 = -1, idx2 = -1;
        for(int i=0; i<COMMS; i++) {
            if(commodities[i].equals(c1)) idx1 = i;
            if(commodities[i].equals(c2)) idx2 = i;
        }
        if (idx1 == -1 || idx2 == -1) return "INVALID_COMMODITY";

        int profit1 = 0, profit2 = 0;
        for (int m = 0; m < MONTHS; m++) {
            for (int d = 1; d <= DAYS; d++) {
                profit1 += data[m][d][idx1];
                profit2 += data[m][d][idx2];
            }
        }
    
    public static String bestWeekOfMonth(int month) {return "DUMMY";}

    public static void main(String[] args) {
        loadData();
        System.out.println("Data loaded – ready for queries");
    }
}