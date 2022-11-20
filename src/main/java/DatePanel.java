import javax.swing.*;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

public class DatePanel extends JPanel
{
    private boolean leapYear;
    private int lastDay;
    private JComboBox<String> days;
    private JComboBox<String> months;
    private JComboBox<String> years;

    public HashMap<String, Integer> monthHashMap = new HashMap<>();

    private String[] monthNames = new String[]{"January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "November", "December"};

    public DatePanel()
    {
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

        months = new JComboBox<>(monthHashMap.keySet().toArray(new String[0]));
        months.setEditable(false);
        months.setSelectedItem("January");


        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        String[] englishYears = new String[1000];
        for (int i = 0; i < englishYears.length; i++)
        {
            englishYears[i] = 2000 + i + "";
        }
        years = new JComboBox<>(englishYears);
        years.setSelectedItem(dateFormat.format(new Date()));

        years.addActionListener(this::onChange);
        months.addActionListener(this::onChange);

        validateDay();

        add(months);

        add(days);

        add(years);

    }

    private void onChange(ActionEvent actionEvent)
    {
        remove(years);

        validateDay();

        add(years);
    }

    private void validateDay()
    {
        days = new JComboBox<>();
        leapYear = getLeapYear();

        if ((Objects.requireNonNull(months.getSelectedItem())).equals("February"))
        {
            if (leapYear && Objects.requireNonNull(months.getSelectedItem()).equals("February"))
            {
                lastDay = 29;
            } else if (Objects.requireNonNull(months.getSelectedItem()).equals("February"))
            {
                lastDay = 28;
            }
        } else
        {
            lastDay = monthHashMap.get((String) (Objects.requireNonNull(months.getSelectedItem())));
        }

        for (int i = 1; i <= lastDay; i++)
        {
            days.addItem(i + "");
        }
        days.setEditable(false);
        add(days);
    }

    private boolean getLeapYear()
    {
        int year = Integer.parseInt((String) Objects.requireNonNull(years.getSelectedItem()));
        boolean isLeap = year % 400 == 0 && year % 100 != 0 && year % 4 == 0;
        monthHashMap.put("February", isLeap ? 29 : 28);
        return isLeap;
    }

    public int getCorrespondingNumber()
    {
        getLeapYear();

        int count = 0;
        String month = (String) Objects.requireNonNull(months.getSelectedItem());
        for (int i = 0; i < monthNames.length; i++)
        {
            count += monthHashMap.get(monthNames[i]);

            if (monthNames[i].equals(month))
            {
                count += Integer.parseInt((String) Objects.requireNonNull(days.getSelectedItem()));
                break;
            }
        }

        return count;

    }
}
