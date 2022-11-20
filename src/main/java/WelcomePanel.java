import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class WelcomePanel extends JPanel
{
    public WelcomePanel()
    {

        // Enter the year (ex. 2022-2033)
        // How many paid days

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(new JLabel("Please choose the starting year"));

        JComboBox<String> yearPairs = new JComboBox<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        String[] englishYears = new String[1000];
        for (int i = 0; i < englishYears.length; i++)
        {
            englishYears[i] = (2000 + i) + "-" + (2001 + i);
        }
        yearPairs = new JComboBox<>(englishYears);
        LocalDate now = LocalDate.now();
        LocalDate nextYear = now.plusYears(1);
        // TODO: Set to this year
        yearPairs.setSelectedItem(dateFormat.format(now.getYear()) + "-"
                + (dateFormat.format(nextYear.getYear())));
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

}
