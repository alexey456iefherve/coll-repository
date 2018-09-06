package Swing_JavaFX;

// Project 1-1: A Simple stopwatch.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

class StopWatch implements ActionListener {

    JLabel jlab;
    long stop; // holds the start time in milliseconds
    long start;

    StopWatch() {

        // Create a new JFrame container.
        JFrame jfrm = new JFrame("A Simple Stopwatch");

        // Specify FlowLayout for the layout manager.
        jfrm.getContentPane().setLayout(new FlowLayout());

        // Give the frame an initial size.
        jfrm.setSize(230, 90);

        // Terminate the program when the user closes the application.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make two buttons.
        JButton jbtnStart = new JButton("Start");
        JButton jbtnStop = new JButton("Stop");

        // Add action listeners.
        jbtnStart.addActionListener(this);
        jbtnStop.addActionListener(this);

        // Add the buttons to the content pane.
        jfrm.getContentPane().add(jbtnStart);
        jfrm.getContentPane().add(jbtnStop);

        // Create a text-based label.
        jlab = new JLabel("Press Start to begin timing.");

        // Add the label to the frame.
        jfrm.getContentPane().add(jlab);

        // Display the frame.
        jfrm.setVisible(true);
    }

    // Handle button events.
    public void actionPerformed(ActionEvent ae) {
        Calendar cal = Calendar.getInstance(); // get the current system time

        if(ae.getActionCommand().equals("Stop")) {
            // Store start time.
            stop = cal.getTimeInMillis();
            jlab.setText("Stopwatch is Running...");
        }
        else
            // Compute the elapsed time.
            jlab.setText("Elapsed time is "
                    + (double) (cal.getTimeInMillis() - stop)/1000);
    }

    public static void main(String args[]) {

        // Create the frame on the event dispatching thread.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StopWatch();
            }
        });
    }

}
