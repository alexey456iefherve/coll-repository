package Swing_JavaFX;

// Demonstrate a text field.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class JTextFieldDemo implements ActionListener {

    JTextField jtf;
    JLabel jlab;

    JTextFieldDemo() {

        // Create a new JFrame container.
        JFrame jfrm = new JFrame("A Text Field Example");

        // Specify FlowLayout for the layout manager.
        jfrm.getContentPane().setLayout(new FlowLayout());

        // Give the frame an initial size.
        jfrm.setSize(240, 90);

        // Terminate the program when the user closes the application.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a text field instance.
        jtf = new JTextField(10);

        // Add an action listener for the text field.
        jtf.addActionListener(this);

        // Add the text field to the content pane.
        jfrm.getContentPane().add(jtf);

        // Create an empty text-based label.
        jlab = new JLabel("");

        // Add the label to the frame.
        jfrm.getContentPane().add(jlab);

        // Display the frame.
        jfrm.setVisible(true);
    }

    // Handle action events.
    public void actionPerformed(ActionEvent ae) {

        // Obtain the current text and display it in a label.
        jlab.setText("Current contents: " + jtf.getText());
    }

    public static void main(String args[]) {

        // Create the frame on the event dispatching thread.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JTextFieldDemo();
            }
        });

    }
}

