import javax.swing.*;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainPanel extends JPanel
{
    private WelcomePanel welcomePanel;
    private ArrayList<PaidHolidayPanel> paidHolidays;
    private ArrayList<UnpaidHolidayPanel> unpaidHolidayPanels;
    private UnpaidHolidayPanel currentUnpaidHolidayPanel;

    private int year;

    public MainPanel()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        this.year = Integer.parseInt(dateFormat.format(new Date()));

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        unpaidHolidayPanels = new ArrayList<>();
        paidHolidays = new ArrayList<>();

        welcomePanel = new WelcomePanel();
        add(welcomePanel);

        JButton submitButton = new JButton("NEXT");
        submitButton.addActionListener(this::onSubmitWelcome);
        add(submitButton);
    }

    private void onSubmitWelcome(ActionEvent actionEvent)
    {
        if (!welcomePanel.mentalHealthDays.getText().strip().equals("")
                && !welcomePanel.sickDays.getText().strip().equals("")
                && !welcomePanel.paidDays.getText().strip().equals(""))
        {
            removeAll();

            addNewStep2Panel();

            revalidate();

            this.year = welcomePanel.getYear();
        } else
        {
        } // validation
    }

    private void addNewStep2Panel()
    {
        PaidHolidayPanel step2Panel = new PaidHolidayPanel(year);
        add(step2Panel);
        paidHolidays.add(step2Panel);

        JButton addMorePaidHolidays = new JButton("Add more paid holidays");
        addMorePaidHolidays.addActionListener(this::onSubmitAddMorePaidHolidays);
        add(addMorePaidHolidays);

        JButton submitPaidHolidays = new JButton("NEXT");
        submitPaidHolidays.addActionListener(this::onSubmitPaidHolidays);
        add(submitPaidHolidays);
    }

    private void onSubmitAddMorePaidHolidays(ActionEvent actionEvent)
    {
        JOptionPane.showMessageDialog(this, "Submitted");
        removeAll();

        addNewStep2Panel();

        revalidate();
    }

    private void onSubmitPaidHolidays(ActionEvent actionEvent)
    {
        removeAll();

        addNewUnpaidHolidayPanel();

        for (int i = 0; i < paidHolidays.size(); i++)
        {
            System.out.println(paidHolidays.get(i).datePanel.getCorrespondingNumber());
        }

        revalidate();
    }

    private void addNewUnpaidHolidayPanel()
    {
        UnpaidHolidayPanel unpaidHolidayPanel = new UnpaidHolidayPanel(year);
        currentUnpaidHolidayPanel = unpaidHolidayPanel;
        add(unpaidHolidayPanel);
        unpaidHolidayPanels.add(unpaidHolidayPanel);

        JButton addMoreUnpaidHolidays = new JButton("Add more unpaid holidays");
        addMoreUnpaidHolidays.addActionListener(this::onSubmitAddMoreUnpaidHolidays);
        add(addMoreUnpaidHolidays);

        JButton submitUnpaidHolidays = new JButton("Calculate Calendar");
        submitUnpaidHolidays.addActionListener(this::onSubmitUnpaidHolidays);
        add(submitUnpaidHolidays);
    }

    private void onSubmitAddMoreUnpaidHolidays(ActionEvent actionEvent)
    {
        if (!currentUnpaidHolidayPanel.daysToTakeOff.getText().strip().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Submitted");

            removeAll();

            addNewUnpaidHolidayPanel();

            for (int i = 0; i < unpaidHolidayPanels.size(); i++)
            {
                System.out.println(unpaidHolidayPanels.get(i).datePanel.getCorrespondingNumber());
            }

            revalidate();
        }
    }

    private void onSubmitUnpaidHolidays(ActionEvent actionEvent)
    {
        if (!currentUnpaidHolidayPanel.daysToTakeOff.getText().strip().equals(""))
        {
            removeAll();

            int year = welcomePanel.getYear();
            boolean isLeap = year % 400 == 0 && year % 100 != 0 && year % 4 == 0;

            Calculator calculator = new Calculator(isLeap, Integer.parseInt(welcomePanel.paidDays.getText()),
                    Integer.parseInt(welcomePanel.mentalHealthDays.getText()),
                    Integer.parseInt(welcomePanel.sickDays.getText()), paidHolidays);

            JOptionPane.showMessageDialog(this,
                    "Lost days: " + calculator.calculateLostDays(unpaidHolidayPanels) +
                            "\nPaid Time Off Remaining: " + calculator.PTO +
                            "\nMental Health Days Remaining: " + calculator.mentalHealth +
                            "\nSick Days Remaining: " + calculator.sickDays);

            add(new JLabel("All done!"));

            revalidate();
        }
    }
}
