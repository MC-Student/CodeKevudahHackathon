import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class WelcomePanel extends JPanel
{
    private JComboBox<String> yearPairs;
    public WelcomePanel()
    {

        // Enter the year (ex. 2022-2033)
        // How many paid days

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(new JLabel("Please choose the starting year (January - December)"));

        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        String[] englishYears = new String[1000];
        for (int i = 0; i < englishYears.length; i++)
        {
            englishYears[i] = (2000 + i) + "";
        }
        yearPairs = new JComboBox<>(englishYears);
        yearPairs.setSelectedItem(dateFormat.format(new Date()));
        add(yearPairs);

        add(new JLabel("Please enter how many paid days off"));

        NumberFormatter numberFormatter = new NumberFormatter(new DecimalFormat("#"));
        JFormattedTextField paidDays = new JFormattedTextField(numberFormatter);
        paidDays.setColumns(5);
        add(paidDays);

        add(new JLabel("Please enter how many sick days off"));

        JFormattedTextField sickDays = new JFormattedTextField(numberFormatter);
        sickDays.setColumns(5);
        add(sickDays);


        add(new JLabel("Please enter how many mental health days off"));

        JFormattedTextField mentalHealthDays = new JFormattedTextField(numberFormatter);
        sickDays.setColumns(5);
        add(mentalHealthDays);

        add(new JLabel("Please enter how many company-wide time off"));

        JFormattedTextField companyTO = new JFormattedTextField(numberFormatter);
        sickDays.setColumns(5);
        add(companyTO);
    }

    public int getYear()
    {
        return Integer.parseInt((String) Objects.requireNonNull(yearPairs.getSelectedItem()));
    }
}
