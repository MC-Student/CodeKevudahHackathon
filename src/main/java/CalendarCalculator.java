import java.util.HashMap;
import java.util.Scanner;

public class CalendarCalculator
{
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
        for (int i = 0; i < (leapYear ? 366: 365); i++)
        {
           workingPaidDays.put(i, new boolean[]{true, true});
        }

        // Day 0: working paid
        // Day 1: working paid
        // get value from HashMap
        //boolean workingToday = workingPaidDays.get(364)[0];

        int [] workOff = new int[]{4, 25, 66, 72, 194, 278, 333, 361};

        //any work days already off with no loss of money
        for (int i = 0; i < workOff.length; i++)
        {
            boolean[] dayInfo = workingPaidDays.get(i);
            dayInfo[0] = false;
            workingPaidDays.put(workOff[i], dayInfo);
        }

        System.out.println("PTO?");
        int PTO = user.nextInt();
        user.nextLine();

        System.out.println("sick days?");
        int sickDays = user.nextInt();
        user.nextLine();

        System.out.println("paid mental health days?");
        int mentalHealth = user.nextInt();
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

        if(workingPaidDays.get(rhStart)[0])
        {
            while(rhDays > 0)
            {
                boolean[] dayInfo = workingPaidDays.get(rhStart);
                dayInfo[0] = false;
                workingPaidDays.put(rhStart, dayInfo);

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
                            dayInfo[1] = false;
                            workingPaidDays.put(rhStart, dayInfo);
                        }
                        else
                        {
                            lostDays++;
                            dayInfo[1] = false;
                            workingPaidDays.put(rhStart, dayInfo);
                        }
                    }
                }

                rhDays--;
                if(rhDays > 0){rhStart++;}
            }
        }


        System.out.println("days off for yom kippur?");
        int ykDays = user.nextInt();
        user.nextLine();

        System.out.println("starting date");
        int ykStart = user.nextInt();
        user.nextLine();

        System.out.println("days off for first days succos?");
        int suFDays = user.nextInt();
        user.nextLine();

        System.out.println("starting date");
        int suFStart = user.nextInt();
        user.nextLine();

        System.out.println("days off for second days succos?");
        int suLDays = user.nextInt();
        user.nextLine();

        System.out.println("starting date");
        int suLStart = user.nextInt();
        user.nextLine();

        System.out.println("days off for chanukah?");
        int chDays = user.nextInt();
        user.nextLine();

        System.out.println("starting date");
        int chStart = user.nextInt();
        user.nextLine();

        System.out.println("days off for purim?");
        int puDays = user.nextInt();
        user.nextLine();

        System.out.println("starting date");
        int puStart = user.nextInt();
        user.nextLine();

        System.out.println("days off for first days pesach?");
        int peFDays = user.nextInt();
        user.nextLine();

        System.out.println("starting date");
        int peFStart = user.nextInt();
        user.nextLine();

        System.out.println("days off for second days pesach?");
        int peLDays = user.nextInt();
        user.nextLine();

        System.out.println("starting date");
        int peLStart = user.nextInt();
        user.nextLine();

        System.out.println("days off for shavuos?");
        int shavDays = user.nextInt();
        user.nextLine();

        System.out.println("starting date");
        int shavStart = user.nextInt();
        user.nextLine();

        //company gives off - set workingpaid[0] for all those days to false
    }



}
