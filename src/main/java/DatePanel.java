import javax.swing.*;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class DatePanel extends JPanel
{
    private int lastDay;

    private JComboBox<String> days;
    private JComboBox<String> months;
    private JComboBox<String> years;

    public DatePanel()
    {
        String[] englishMonths = new String[]{"January", "February", "March", "April", "May", "June", "July", "August",
        "September", "October", "November", "December"};
        months = new JComboBox<>(englishMonths);
        months.setEditable(false);
        months.setSelectedItem(englishMonths[0]);


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
        int year = Integer.parseInt((String) Objects.requireNonNull(years.getSelectedItem()));
        days = new JComboBox<>();
        switch ((String) Objects.requireNonNull(months.getSelectedItem()))
        {
            case "February":
                if (year % 400 == 0 && year % 100 != 0 && year % 4 == 0
                        && Objects.requireNonNull(months.getSelectedItem()).equals("February"))
                {
                    lastDay = 29;
                } else if (Objects.requireNonNull(months.getSelectedItem()).equals("February"))
                {
                    lastDay = 28;
                }
                break;
            case "September": case "April": case "June": case "November":
                lastDay = 30;
                break;
            case "January": case "March": case "May": case "July": case "August": case "October": case "December":
                lastDay = 31;
                break;
        }
        for (int i = 1; i <= lastDay; i++)
        {
            days.addItem(i + "");
        }
        days.setEditable(false);
        add(days);
    }
}
