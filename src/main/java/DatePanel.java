import javax.swing.*;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

public class DatePanel extends JPanel
{
    private boolean leapYear;
    private int lastDay;
    private JComboBox<String> days;
    private JComboBox<String> months;
    public HashMap<String, Integer> monthHashMap = new HashMap<>();

    int year;

    private final String[] monthNames = new String[]{"January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "November", "December"};

    public DatePanel(int year)
    {
        this.year = year;

        monthHashMap.put("January", 31);
        monthHashMap.put("February", 28);
        monthHashMap.put("March", 31);
        monthHashMap.put("April", 30);
        monthHashMap.put("May", 31);
        monthHashMap.put("June", 30);
        monthHashMap.put("July", 31);
        monthHashMap.put("August", 31);
        monthHashMap.put("September", 30);
        monthHashMap.put("October", 31);
        monthHashMap.put("November", 30);
        monthHashMap.put("December", 31);

        months = new JComboBox<>(monthNames);
        months.setEditable(false);
        months.setSelectedItem("January");
        months.addActionListener(this::onChange);

        validateDay();

        add(months);

        add(days);

    }

    private void onChange(ActionEvent actionEvent)
    {
        remove(days);

        validateDay();

        revalidate();
    }

    private void validateDay()
    {
        boolean alreadySet = (days != null);
        int dayOfMonth = alreadySet
                ? Integer.parseInt(Objects.requireNonNull(days.getSelectedItem()).toString())
                : 1;
        days = new JComboBox<>();
        leapYear = getLeapYear();

        if ((Objects.requireNonNull(months.getSelectedItem())).equals("February"))
        {
            lastDay = leapYear ? 29 : 28;
        } else
        {
            lastDay = monthHashMap.get((String) (Objects.requireNonNull(months.getSelectedItem())));
        }

        for (int i = 1; i <= lastDay; i++)
        {
            days.addItem(i + "");
        }
        days.setEditable(false);

        days.setSelectedItem(dayOfMonth + "");
        add(days);
    }

    private boolean getLeapYear()
    {
        boolean isLeap = year % 400 == 0 && year % 100 != 0 && year % 4 == 0;
        monthHashMap.put("February", isLeap ? 29 : 28);
        return isLeap;
    }

    public int getCorrespondingNumber()
    {
        getLeapYear();

        int count = 0;
        String month = (String) Objects.requireNonNull(months.getSelectedItem());

        // TODO: Fix logic
        for (int i = 0; i < monthNames.length; i++)
        {
            if (monthNames[i].equals(month))
            {
                count += Integer.parseInt((String) Objects.requireNonNull(days.getSelectedItem()));
                break;
            }
            else
            {
                count += monthHashMap.get(monthNames[i]);
            }

        }

        return count;

    }
}
