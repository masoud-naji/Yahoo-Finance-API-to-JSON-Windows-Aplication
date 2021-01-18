package GUIform;


import AllReports.AllReport;
import MyKey.KeyRecorder;
import MyKey.ReadKey;
import MyKey.Writekey;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.example.App;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;


public class GuiForm {


    private JPanel Panel1;
    private JTextField textField1;
    private JRadioButton RD1;
    private JRadioButton RD3;
    private JRadioButton RD5;
    private JRadioButton RD7;
    private JRadioButton RD9;
    private JRadioButton RD2;
    private JRadioButton RD4;
    private JRadioButton RD6;
    private JRadioButton RD8;
    private JRadioButton RD10;
    private JButton createAllDurationsButton;
    private JLabel Label1;
    private JLabel Label2;
    private JTextField textField2;
    private JButton CreateBySelect;
    private JLabel LBcopy;
    private JButton btnpst2;
    private JButton btnpst1;


    public GuiForm() {

/////////////////////////////////////////////////////////////////Selective Duration Button///////////////////////////////////////////////////////////////////////
        CreateBySelect.addActionListener(e -> {
            if (!textField1.getText().isEmpty()) {
                getDataFromGui();
            } else {
                JOptionPane.showMessageDialog(null, "Please Enter Key \r\n Your Last Key is going to use \r\n If you never put any key before your report is crshed!!!");
                sendkeyfile();
            }
        });


/////////////////////////////////////////////////////////////////ALL Duration Button//////////////////////////////////////////////////////////////////////////
        createAllDurationsButton.addActionListener(e -> {
            if (!textField1.getText().isEmpty()) {
                try {
                    runallreport();
                } catch (UnirestException unirestException) {
                    unirestException.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please Enter Key \r\n Your Last Key is going to use \r\n If you never put any key before your report is crshed!!!");
                sendkeyfile();
            }


        });

        LBcopy.setForeground(Color.BLUE.darker());
        LBcopy.setCursor(new Cursor(Cursor.HAND_CURSOR));
        LBcopy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    Desktop.getDesktop().browse(new URI("mailto:m.naji@inceptionq.com"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }


            }
        });


   // textField2.addMouseListener(new MouseAdapter() { } );


        btnpst1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
                String past = null;
                try {
                    past = (String) c.getContents(null).getTransferData(DataFlavor.stringFlavor);
                } catch (UnsupportedFlavorException unsupportedFlavorException) {
                    unsupportedFlavorException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                textField1.setText(past);

            }
        });

        btnpst2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
                String past = null;
                try {
                    past = (String) c.getContents(null).getTransferData(DataFlavor.stringFlavor);
                } catch (UnsupportedFlavorException unsupportedFlavorException) {
                    unsupportedFlavorException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                textField2.setText(past);
            }
        });
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {


        JFrame frame = new JFrame("Get Yahoo Finance\n");
        frame.setContentPane(new GuiForm().Panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(700, 300);
        frame.setLocationRelativeTo(null);
        KeyRecorder.main(args);
        ReadKey.main(args);







    }

    /////////////////////////////////////////////////////////////////Radio  Button/////////////////////////////////////////////////////////////////////////////////////
    public String isRdSelected() {

        if (RD1.isSelected()) {
            return "1D";
        } else if (RD2.isSelected()) {
            return "5D";
        } else if (RD3.isSelected()) {
            return "1W";
        } else if (RD4.isSelected()) {
            return "1M";
        } else if (RD5.isSelected()) {
            return "3M";
        } else if (RD6.isSelected()) {
            return "6M";
        } else if (RD7.isSelected()) {
            return "1Y";
        } else if (RD8.isSelected()) {
            return "2Y";
        } else if (RD9.isSelected()) {
            return "5Y";
        } else if (RD10.isSelected()) {
            return "MAX";
        } else {
            JOptionPane.showMessageDialog(null, "not selected");
            return null;

        }


    }

    public String getDataFromGui() {


        try {
            String[] args = new String[]{textField1.getText(), isRdSelected(), textField2.getText()};
            App.main(args); // Send for Create
            Writekey.main(args); //Send for save key

        } catch (UnirestException unirestException) {
            unirestException.printStackTrace();
        }

        Label2.setText("Duration in \r\n" + isRdSelected());
        JOptionPane.showMessageDialog(null, isRdSelected() + " Report is Created on \r\n C:/Yahoo_Finance/Report/ONE/ \r\n Now you Can Use it on Excell");
        return Label2.getText();

    }

    public void runallreport() throws UnirestException {
        String[] args = new String[]{textField1.getText(),"All",textField2.getText()};
        AllReport.main(args); // Send for Create
        Writekey.main(args); //Send for save key
        Label2.setText("Duration in ALL");
        JOptionPane.showMessageDialog(null, "All Reports Created on \r\n C:/Yahoo_Finance/Report/ALL/ \r\n  Now you Can Use it on Excell");
    }


    public static void getsaveddata(String mySavedata) {

        String key;
        key = mySavedata;
      ////  System.out.println("mysavedat " + key);


    }

    public void sendkeyfile() { //only way to read and send to texbox1 old key
        try {
            File myObj = new File("C:/Yahoo_Finance/Report/Key.maxk");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                GuiForm.this.textField1.setText(data);

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }

}
