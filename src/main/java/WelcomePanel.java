import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class WelcomePanel extends JPanel
{
    public JComboBox<String> yearPairs;

    public JFormattedTextField paidDays;

    public JFormattedTextField sickDays;

    public JFormattedTextField mentalHealthDays;

    public WelcomePanel()
    {

        // Enter the year (ex. 2022-2033)
        // How many paid days

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JOptionPane.showMessageDialog(this, "Welcome to My Frum Calendar\n" +
                "Our goal is to minimize the impact of Frum\n" +
                "scheduling conflicts on your salary. You tell us when you work, and we help you figure out how\n" +
                        "to take the least amount of unpaid leave.");
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
        paidDays = new JFormattedTextField(numberFormatter);
        paidDays.setColumns(5);
        add(paidDays);

        add(new JLabel("Please enter how many sick days off"));

        sickDays = new JFormattedTextField(numberFormatter);
        sickDays.setColumns(5);
        add(sickDays);


        add(new JLabel("Please enter how many mental health days off"));

        mentalHealthDays = new JFormattedTextField(numberFormatter);
        sickDays.setColumns(5);
        add(mentalHealthDays);
    }

    public int getYear()
    {
        return Integer.parseInt((String) Objects.requireNonNull(yearPairs.getSelectedItem()));
    }
}
