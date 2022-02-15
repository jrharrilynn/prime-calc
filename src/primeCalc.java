import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Font.BOLD;

//class extends Jframe and acitonlistener
public class primeCalc extends JFrame implements ActionListener{

   //instantiate GUI features
    private JButton button;
    private JLabel label;
    private JFrame frame;
    private JPanel panel;
    private JTextField textField;
    @Override
    //action method for when button is clicked, it checks if the number in the
    //user input is a prime number via the helper function from the Sieve class
    public void actionPerformed(ActionEvent actionEvent) {
        //initialize sieve
       Sieve primeSieve = new Sieve(1000000);
       //if text field is empty disable button
        if (textField.getText().isEmpty()) {
            button.setEnabled(false);
            label.setText("requires input");
        } else {
            button.setEnabled(true);
            try {
                //change string into integer
                int i = Integer.parseInt(textField.getText());
                //use Sieve helper function
                    if (primeSieve.isPrime(i)) {
                            label.setText(i + " is prime");
                        } else
                            label.setText(i + " is not prime");
            }
            catch (NumberFormatException e){
                label.setText("thats not an integer, please try again");
            }


        }
    }
    //constructor
    public primeCalc(){
        //make the window
        textField = new JTextField("");
        frame = new JFrame();
        button = new JButton("Prime Number?");
        button.addActionListener(this);
        label = new JLabel("Am I Prime??", SwingConstants.CENTER);
        panel = new JPanel();
        //this is to check if there has been an update to the user input
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                changed();
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                changed();
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                changed();
            }
            public void changed()
            {
                if(textField.getText().isEmpty())
                {
                    button.setEnabled(false);
                }
                else
                    button.setEnabled(true);
            }
        });
        //pretty-ify
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0,1));
        //add text box
        panel.add(textField);
        panel.add(button);
        panel.add(label);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Our GUI");
        frame.pack();
        frame.setVisible(true);
        button.setFont(new Font("Serif", BOLD, 20));
        button.setBackground(new Color(251,204,209));
        button.setForeground(Color.white);
        button.setSize(new Dimension(300, 300));
        //set up label
        label.setFont(new Font("SANS-SERIF",(BOLD), 55));

    }

    public static void main(String[] args)
    {
        //initialize constructor.
        new primeCalc();
    }
}
