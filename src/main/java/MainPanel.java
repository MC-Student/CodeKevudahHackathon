import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class MainPanel extends JPanel
{
    private ArrayList<Step2Panel> step2Panels;
    private ArrayList<VerticalPanel> verticalPanels;

    public MainPanel()
    {

        verticalPanels = new ArrayList<>();
        step2Panels = new ArrayList<>();

        WelcomePanel welcomePanel = new WelcomePanel();
        add(welcomePanel);

        JButton submitButton = new JButton("NEXT");
        submitButton.addActionListener(this::onSubmitWelcome);
        add(submitButton);
    }

    private void onSubmitWelcome(ActionEvent actionEvent)
    {
        removeAll();
        Step2Panel step2Panel = new Step2Panel();
        add(step2Panel);
        step2Panels.add(step2Panel);

        JButton addMore = new JButton("Add more");
        addMore.addActionListener(this::addMoreStep2);
        add(addMore);
        revalidate();

        JButton submitButton = new JButton("NEXT");
        submitButton.addActionListener(this::onSubmitWelcomeStep2);
        add(submitButton);
        revalidate();
    }

    private void addMoreStep2(ActionEvent actionEvent)
    {
        removeAll();
        Step2Panel step2Panel = new Step2Panel();
        add(step2Panel);
        step2Panels.add(step2Panel);

        JButton addMore = new JButton("Add more");
        addMore.addActionListener(this::addMoreStep2);
        add(addMore);
        revalidate();

        JButton submitButton = new JButton("NEXT");
        submitButton.addActionListener(this::onSubmitWelcomeStep2);
        add(submitButton);
        revalidate();
    }

    private void onSubmitWelcomeStep2(ActionEvent actionEvent)
    {
        removeAll();
        VerticalPanel verticalPanel = new VerticalPanel();
        add(verticalPanel);
        verticalPanels.add(verticalPanel);

        JButton addMore = new JButton("Add more");
        addMore.addActionListener(this::addMore);
        add(addMore);
        revalidate();
    }

    private void addMore(ActionEvent actionEvent)
    {
        VerticalPanel verticalPanel = new VerticalPanel();
        add(verticalPanel);
        verticalPanels.add(verticalPanel);

    }
}
