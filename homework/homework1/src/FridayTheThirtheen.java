import java.util.Scanner;
import java.util.Arrays;

public class FridayTheThirtheen {



    static void caculateNumFromYear(int N){

        int freq[] = new int[7];
        Arrays.fill(freq, 0);

        int calendarDay = 0;
        int[] days = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int[] leapDays = new int[] { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int end = 1900 + N;
        for (int year = 1900; year < end; year++) {
            for (int month = 0; month < 12; month++) {
                int day = (calendarDay + 12) % 7;
                freq[day]++;
                calendarDay += isYeapYear(year) ? leapDays[month] : days[month];
            }
        }

        System.out.print(freq[5] + " " + freq[6] + " " + freq[0] + " " + freq[1] + " " + freq[2] + " " + freq[3] + " " + freq[4] + " ");

    }


    public static void main(String[] args) {
        System.out.println("Please input year number:");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        caculateNumFromYear(N);

    }

    public static boolean isYeapYear(int year) {
        if ((year % 100) == 0) {
            if (year % 400 == 0) {
                return true;
            }
            return false;
        } else {
            if (year % 4 == 0) {
                return true;
            }
            return false;
        }
    }
}


