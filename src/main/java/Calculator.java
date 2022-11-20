import java.util.ArrayList;
import java.util.HashMap;

public class Calculator
{
    public int PTO;

    public int sickDays;

    public int mentalHealth;

    private HashMap<Integer, boolean[]> workingPaidDays;

    public Calculator(boolean leapYear, int pto, int mentalHealthDays, int sickDays,
                      ArrayList<PaidHolidayPanel> step2PanelArrayList)
    {
        this.PTO = pto;
        this.mentalHealth = mentalHealthDays;
        this.sickDays = sickDays;

        fillHashMap(leapYear);

        ArrayList<Integer> workOff = new ArrayList<>();
        for (int i = 0; i < step2PanelArrayList.size(); i++)
        {
            int day = step2PanelArrayList.get(i).datePanel.getCorrespondingNumber();
            workOff.add(day);
        }

        //any work days already off with no loss of money
        for (int i = 0; i < workOff.size(); i++)
        {
            boolean[] dayInfo = workingPaidDays.get(workOff.get(i));
            dayInfo[0] = false;
            workingPaidDays.put(workOff.get(i), dayInfo);
        }
    }

    private void fillHashMap(boolean leapYear)
    {
        workingPaidDays = new HashMap<>();
        for (int i = 0; i < (leapYear ? 366 : 365); i++)
        {
            workingPaidDays.put(i, new boolean[]{true, true});
        }
    }

    public int calculateLostDays(ArrayList<UnpaidHolidayPanel> unpaidHolidayPanelArrayList)
    {
        int lostDays = 0;

        for (int i = 0; i < unpaidHolidayPanelArrayList.size(); i++)
        {
            int day = unpaidHolidayPanelArrayList.get(i).datePanel.getCorrespondingNumber();
            int numDays = Integer.parseInt(unpaidHolidayPanelArrayList.get(i).daysToTakeOff.getText());
            System.out.println("DAY: " + day + " " + numDays);
            lostDays = updateCalendar(numDays, workingPaidDays, day, lostDays);
        }

        return lostDays;
    }

    private int updateCalendar(int NumDaysOff, HashMap<Integer, boolean[]> workingPaidDays, int startDate, int lostDays)
    {
        boolean sickDaysChanged = false;
        while (NumDaysOff > 0)
        {
            boolean[] dayInfo = workingPaidDays.get(startDate);
            dayInfo[0] = false;
            workingPaidDays.put(startDate, dayInfo);

            if (PTO > 0)
            {
                PTO--;
            } else
            {
                if (mentalHealth > 0)
                {
                    mentalHealth--;
                } else
                {
                    if (sickDays > 0)
                    {
                        sickDaysChanged = true;
                        sickDays--;
                    } else
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
        if (sickDaysChanged)
        {
            sickDays++;
        }
        return lostDays;
    }

}
