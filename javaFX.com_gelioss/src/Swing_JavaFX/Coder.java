package Swing_JavaFX;

// Project 1-2: A simple code machine.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Coder implements ActionListener {

    JTextField jtfPlaintext;
    JTextField jtfCiphertext;

    Coder() {

        // Create a new JFrame container.
        JFrame jfrm = new JFrame("A Simple Code Machine");

        // Specify FlowLayout for the layout manager.
        jfrm.getContentPane().setLayout(new FlowLayout());

        // Give the frame an initial size.
        jfrm.setSize(340, 120);

        // Terminate the program when the user closes the application.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create two labels.
        JLabel jlabPlaintext = new JLabel("   Plain Text: ");
        JLabel jlabCiphertext = new JLabel("Cipher Text: ");

        // Create two text field instances.
        jtfPlaintext = new JTextField(20);
        jtfCiphertext = new JTextField(20);

        // Set the action commands for the text fields.
        jtfPlaintext.setActionCommand("Encode");
        jtfCiphertext.setActionCommand("Decode");

        // Add action listeners for the text fields.
        jtfPlaintext.addActionListener(this);
        jtfCiphertext.addActionListener(this);

        // Add the text fields and labels to the content pane.
        jfrm.getContentPane().add(jlabPlaintext);
        jfrm.getContentPane().add(jtfPlaintext);
        jfrm.getContentPane().add(jlabCiphertext);
        jfrm.getContentPane().add(jtfCiphertext);

        // Create push button instances.
        JButton jbtnEncode = new JButton("Encode");
        JButton jbtnDecode = new JButton("Decode");
        JButton jbtnReset =  new JButton("Reset");

        // Add action listeners for the buttons.
        jbtnEncode.addActionListener(this);
        jbtnDecode.addActionListener(this);
        jbtnReset.addActionListener(this);

        // Add the buttons to the content pane.
        jfrm.getContentPane().add(jbtnEncode);
        jfrm.getContentPane().add(jbtnDecode);
        jfrm.getContentPane().add(jbtnReset);

        // Display the frame.
        jfrm.setVisible(true);
    }

    // Handle action events.
    public void actionPerformed(ActionEvent ae) {

        // If action command is "Encode" then encode the string.
        if(ae.getActionCommand().equals("Encode")) {

            // Obtain the plain text and put it into a StringBuilder.
            StringBuilder str = new StringBuilder(jtfPlaintext.getText());

            // Add 1 to each character.
            for(int i=0; i<str.length(); i++)
                str.setCharAt(i, (char)(str.charAt(i) + 1));

            // Set the coded text into the cipher text field.
            jtfCiphertext.setText(str.toString());

        }

        // If action command is "Decode" then decode the string.
        else if(ae.getActionCommand().equals("Decode")) {

            // Obtain the cipher text and put it into a StringBuilder.
            StringBuilder str = new StringBuilder(jtfCiphertext.getText());

            // Subtract 1 from each character.
            for(int i=0; i<str.length(); i++)
                str.setCharAt(i, (char)(str.charAt(i) - 1));

            // Set the decoded text into the plain text field.
            jtfPlaintext.setText(str.toString());
        }

        // Otherwise, must be "Reset" command.
        else {
            jtfPlaintext.setText("");
            jtfCiphertext.setText("");
        }
    }

    public static void main(String args[]) {

        // Create the frame on the event dispatching thread.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Coder();
            }
        });

    }
}
