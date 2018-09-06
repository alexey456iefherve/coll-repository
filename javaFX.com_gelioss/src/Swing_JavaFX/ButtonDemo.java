package Swing_JavaFX;

// Demonstrate a button.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ButtonDemo implements ActionListener {

    JLabel jlab;

    ButtonDemo() {

        // Create a new JFrame container.
        JFrame jfrm = new JFrame("A Button Example");

        // Specify FlowLayout for the layout manager.
        jfrm.getContentPane().setLayout(new FlowLayout());

        // Give the frame an initial size.
        jfrm.setSize(220, 90);

        // Terminate the program when the user closes the application.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make two buttons.
        JButton jbtnFirst = new JButton("First");
        JButton jbtnSecond = new JButton("Second");

        // Add action listeners.
        jbtnFirst.addActionListener(this);
        jbtnSecond.addActionListener(this);

        // Add the buttons to the content pane.
        jfrm.getContentPane().add(jbtnFirst);
        jfrm.getContentPane().add(jbtnSecond);

        // Create a text-based label.
        jlab = new JLabel("Press a button.");

        // Add the label to the frame.
        jfrm.getContentPane().add(jlab);

        // Display the frame.
        jfrm.setVisible(true);
    }

    // Handle button events.
    public void actionPerformed(ActionEvent ae) {

        if(ae.getActionCommand().equals("First"))
            jlab.setText("First button was pressed.");
        else
            jlab.setText("Second button was pressed. ");
    }

    public static void main(String args[]) {

        // Create the frame on the event dispatching thread.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ButtonDemo();
            }
        });

    }
}
