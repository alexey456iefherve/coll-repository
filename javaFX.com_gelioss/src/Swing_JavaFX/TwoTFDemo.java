package Swing_JavaFX;

// Use two text fields.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TwoTFDemo implements ActionListener {

    JTextField jtf1;
    JTextField jtf2;
    JLabel jlab;

    TwoTFDemo() {

        // Create a new JFrame container.
        JFrame jfrm = new JFrame("Use Two Text Fields");

        // Specify FlowLayout for the layout manager.
        jfrm.getContentPane().setLayout(new FlowLayout());

        // Give the frame an initial size.
        jfrm.setSize(240, 120);

        // Terminate the program when the user closes the application.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create two text field instances.
        jtf1 = new JTextField(10);
        jtf2 = new JTextField(10);

        // Set the action commands.
        jtf1.setActionCommand("One");
        jtf2.setActionCommand("Two");

        // Add action listeners for the text fields.
        jtf1.addActionListener(this);
        jtf2.addActionListener(this);

        // Add the text fields to the content pane.
        jfrm.getContentPane().add(jtf1);
        jfrm.getContentPane().add(jtf2);

        // Create an empty text-based label.
        jlab = new JLabel("");

        // Add the label to the frame.
        jfrm.getContentPane().add(jlab);

        // Display the frame.
        jfrm.setVisible(true);
    }

    // Handle action events.
    public void actionPerformed(ActionEvent ae) {

        if(ae.getActionCommand().equals("One"))
            jlab.setText("ENTER pressed in tf1: "
                    + jtf1.getText());
        else
            jlab.setText("ENTER pressed in jtf2: "
                    + jtf2.getText());
    }

    public static void main(String args[]) {

        // Create the frame on the event dispatching thread.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TwoTFDemo();
            }
        });

    }
}
