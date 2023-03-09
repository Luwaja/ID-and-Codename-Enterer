// Imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NameEnter extends JFrame
{
    final private Font mainFont = new Font("Comic Sans MS", Font.BOLD, 18);
    JTextField textFieldIDNum, textFieldCodename;
    JLabel labelWelcome;
    
    public void initialize()
    {
        /****************** Form Panel ******************/
        // Create ID label
        JLabel labelIDNum = new JLabel("ID");
        labelIDNum.setFont(mainFont);
        // Create ID textField
        textFieldIDNum = new JTextField();
        textFieldIDNum.setFont(mainFont);

        // Create codename label
        JLabel labelCodename = new JLabel("Codename");
        labelCodename.setFont(mainFont);
        // Create codename textField
        textFieldCodename = new JTextField();
        textFieldCodename.setFont(mainFont);
        
        // Create formPanel and add elements to it
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 1, 5, 5));
        formPanel.setOpaque(false);
        formPanel.add(labelIDNum);
        formPanel.add(textFieldIDNum);
        formPanel.add(labelCodename);
        formPanel.add(textFieldCodename);

        /****************** Welcome Label ******************/
        labelWelcome = new JLabel();
        labelWelcome.setFont(mainFont);

        /****************** Button Panel ******************/
        // Create OK button
        JButton buttonOK = new JButton("OK");
        buttonOK.setFont(mainFont);
        buttonOK.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Output ID and codename
                String id = textFieldIDNum.getText();
                String codeName = textFieldCodename.getText();
                labelWelcome.setText("Hello " + id + ": " + codeName);
            }
        });

        // Create clear button
        JButton buttonClear = new JButton("Clear");
        buttonClear.setFont(mainFont);
        buttonClear.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear textFields
                textFieldIDNum.setText("");
                textFieldCodename.setText("");
                labelWelcome.setText("");
            }
        });

        // Set buttonsPanel layout and add button elements
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 5, 5));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(buttonOK);
        buttonsPanel.add(buttonClear);

        // Create mainPanel with layout and background color
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(45, 82, 125));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(labelWelcome, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);
        
        setTitle("Laser Tag");
        setSize(500, 500);
        setMinimumSize(new Dimension(500,500));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        
        add(mainPanel);
    }

    public static void main(String[] args)
    {
        NameEnter nameEnter = new NameEnter();
        nameEnter.initialize();
    }
}