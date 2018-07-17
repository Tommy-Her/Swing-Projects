/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




/*

essentially what this program does is just generate a new window when the button is clicked.
A new frame with a panel that has a text field is generated whenever the button is clicked.
Might want to limit the window to only be able to open one window.

*/

package helloworld;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author vangu
 */
public class NewWindowExample extends JPanel{
    public NewWindowExample(){
        JButton Button1 = new JButton("Generate New Window");
        CreateListener createListener1 = new CreateListener(Button1);
        Button1.setEnabled(true);
        Button1.setActionCommand("Create new windows");
        Button1.addActionListener(createListener1);
        
        JPanel firstPanel = new JPanel();
        firstPanel.add(Button1);
        add(firstPanel);
    }

    private static class NewExampleWindow extends JPanel {
        private JTextField textField1;
        
        public NewExampleWindow() {
            textField1 = new JTextField(20);
            JPanel tempPanel2 = new JPanel();
            tempPanel2.add(textField1);
            add(tempPanel2);
        }
    }
    
    public class CreateListener implements ActionListener{
        private JButton TempButton;
        
        public CreateListener(JButton e){
            this.TempButton = e;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            TempButton.setEnabled(false);
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createNewGUI();
                }
            });
        }

}
    
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new NewWindowExample();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    
    // The only issue creating this was line 86. Did, "tempFrame.setContentPane(tempFrame)" which doesn't make sense
    private static void createNewGUI(){
        JFrame tempFrame = new JFrame("New Window");
        tempFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JComponent newComponents = new NewExampleWindow();
        newComponents.setOpaque(true);
        tempFrame.setContentPane(newComponents);
        
        tempFrame.pack();
        tempFrame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
