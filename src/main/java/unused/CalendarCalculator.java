package unused;

import java.util.HashMap;
import java.util.Scanner;

public class CalendarCalculator
{
    public static int PTO;

    public static int sickDays;

    public static int mentalHealth;

    public static void main(String[] args)
    {
        Scanner user = new Scanner(System.in);

        System.out.println("Welcome to Frum Days!");
        System.out.println("Our goal is to minimize the impact of frum scheduling conflicts on your salary.");
        System.out.println("You tell us when you work, and we help you figure out how to take the least amount of unpaid leave.");

        System.out.println("leap year (english)? enter true/false");
        int leap = user.nextInt();
        boolean leapYear = (leap != 0);
        user.nextLine();

        HashMap<Integer, boolean[]> workingPaidDays = new HashMap<>();
        for (int i = 0; i < (leapYear ? 366 : 365); i++)
        {
            workingPaidDays.put(i, new boolean[]{true, true});
        }

        // Day 0: working paid
        // Day 1: working paid
        // get value from HashMap
        //boolean workingToday = workingPaidDays.get(364)[0];

        //generated from first GUI - days company gives off
        int[] workOff = new int[]{4, 25, 66, 72, 194, 278, 333, 361}; // these should stay (false, true)

        //any work days already off with no loss of money
        for (int i = 0; i < workOff.length; i++)
        {
            boolean[] dayInfo = workingPaidDays.get(workOff[i]);
            dayInfo[0] = false;
            workingPaidDays.put(workOff[i], dayInfo);
        }

        System.out.println("PTO?");
        PTO = user.nextInt();
        user.nextLine();

        System.out.println("sick days?");
        sickDays = user.nextInt();
        user.nextLine();

        System.out.println("paid mental health days?");
        mentalHealth = user.nextInt();
        user.nextLine();

        int lostDays = 0;

        System.out.println("Now we have to get personal conflicts?  ");

        System.out.println("starting date for rosh hashana");
        //check how many days left of
        int rhStart = user.nextInt();
        user.nextLine();

        System.out.println("days off for rosh hashana?");
        int rhDays = user.nextInt();
        user.nextLine();


        if (workingPaidDays.get(rhStart)[0])
        {
            lostDays = updateCalendar(rhDays, workingPaidDays, rhStart, lostDays);
        }


        System.out.println("starting date for yom kippur");
        int ykStart = user.nextInt();
        user.nextLine();

        System.out.println("days off for yom kippur?");
        int ykDays = user.nextInt();
        user.nextLine();

        if (workingPaidDays.get(ykStart)[0])
        {
            lostDays = updateCalendar(ykDays, workingPaidDays, ykStart, lostDays);
        }


        System.out.println("starting date for first days succos");
        int suFStart = user.nextInt();
        user.nextLine();

        System.out.println("days off for first days succos?");
        int suFDays = user.nextInt();
        user.nextLine();

        if (workingPaidDays.get(suFStart)[0])
        {
            lostDays = updateCalendar(suFDays, workingPaidDays, suFStart, lostDays);
        }


        System.out.println("starting date for second days succos");
        int suLStart = user.nextInt();
        user.nextLine();

        System.out.println("days off for second days succos?");
        int suLDays = user.nextInt();
        user.nextLine();

        if (workingPaidDays.get(suLStart)[0])
        {
            lostDays = updateCalendar(suLDays, workingPaidDays, suLStart, lostDays);
        }


        System.out.println("starting date for chanukah");
        int chStart = user.nextInt();
        user.nextLine();

        System.out.println("days off for chanukah?");
        int chDays = user.nextInt();
        user.nextLine();

        if (workingPaidDays.get(chStart)[0])
        {
            lostDays = updateCalendar(chDays, workingPaidDays, chStart, lostDays);
        }


        System.out.println("starting date for purim");
        int puStart = user.nextInt();
        user.nextLine();

        System.out.println("days off for purim?");
        int puDays = user.nextInt();
        user.nextLine();

        if (workingPaidDays.get(puStart)[0])
        {
            lostDays = updateCalendar(puDays, workingPaidDays, puStart, lostDays);
        }


        System.out.println("starting date for first days pesach");
        int peFStart = user.nextInt();
        user.nextLine();

        System.out.println("days off for first days pesach?");
        int peFDays = user.nextInt();
        user.nextLine();

        if (workingPaidDays.get(peFStart)[0])
        {
            lostDays = updateCalendar(peFDays, workingPaidDays, peFStart, lostDays);
        }


        System.out.println("starting date for second days pesach");
        int peLStart = user.nextInt();
        user.nextLine();

        System.out.println("days off for second days pesach?");
        int peLDays = user.nextInt();
        user.nextLine();

        if (workingPaidDays.get(peLStart)[0])
        {
            lostDays = updateCalendar(peLDays, workingPaidDays, peLStart, lostDays);
        }


        System.out.println("starting date for shavuos");
        int shavStart = user.nextInt();
        user.nextLine();

        System.out.println("days off for shavuos?");
        int shavDays = user.nextInt();
        user.nextLine();

        if (workingPaidDays.get(shavStart)[0])
        {
            lostDays = updateCalendar(shavDays, workingPaidDays, shavStart, lostDays);
        }

        System.out.println("starting date for Tisha Ba'av");
        int tBStart = user.nextInt();
        user.nextLine();

        System.out.println("days off for Tisha Ba'av?");
        int tBDays = user.nextInt();
        user.nextLine();

        if (workingPaidDays.get(tBStart)[0])
        {
            lostDays = updateCalendar(tBDays, workingPaidDays, tBStart, lostDays);
        }

        for (int i = 0; i < workingPaidDays.size(); i++)
        {
            System.out.print("Day " + i + ": ");
            System.out.println("Working? " + workingPaidDays.get(i)[0] + "; Paid? " + workingPaidDays.get(i)[1]);
        }

        System.out.println("Lost days: " + lostDays);

        //company gives off - set workingpaid[0] for all those days to false
    }

    private static int updateCalendar(int NumDaysOff, HashMap<Integer, boolean[]> workingPaidDays, int startDate, int lostDays)
    {
        while (NumDaysOff > 0)
        {
            boolean[] dayInfo = workingPaidDays.get(startDate);
            dayInfo[0] = false;
            workingPaidDays.put(startDate, dayInfo);

            if (PTO > 0)
            {
                PTO--;
            }
            else
            {
                if (mentalHealth > 0)
                {
                    mentalHealth--;
                }
                else
                {
                    if (sickDays > 0)
                    {
                        sickDays--;
                    }
                    else
                    {
                        lostDays++;
                    }
                    dayInfo[1] = false;
                    workingPaidDays.put(startDate, dayInfo);
                }
            }

            NumDaysOff--;
            if (NumDaysOff > 0)
            {
                startDate++;
            }
        }
        return lostDays;
    }


}
