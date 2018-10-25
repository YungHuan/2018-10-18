//import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

import javafx.stage.FileChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class EncryptFile extends JFrame {
    public static void main(String[] args) {
//         new EncryptFile().setVisible(true);
    }
    private Container cp;
    private JPanel jpW = new JPanel(new GridLayout(2,1,3,3));
    private JPanel jpE = new JPanel(new GridLayout(2,1,3,3));
    private JPanel jpC = new JPanel(new GridLayout(2,1,3,3));
    private JPanel jpN = new JPanel(new GridLayout(1,6,3,3));
    private JPanel jpS = new JPanel(new GridLayout(1,1,0,0));
    private JLabel jlb1 = new JLabel("原始檔");
    private JLabel jlb2 = new JLabel("加密檔");
    private JLabel jlb3 = new JLabel("加密法");
    private JLabel jlbkey = new JLabel("key");
    private String algoLabels[] = {"Caesar", "XOR", "DES", "AES"};
    private JComboBox jcomb = new JComboBox(algoLabels);
    private JTextField jtf1 = new JTextField();
    private JTextField jtf2 = new JTextField();
    private JTextField jtfkey = new JTextField("");
    private JButton jbtnload = new JButton("選擇檔案");
    private JButton jbtnsave = new JButton("保存檔案");
    private JButton jbtnrun = new JButton("Run");
    private JButton jbtnclose = new JButton("Close");
    private JProgressBar jpb = new JProgressBar();
    private int frmw = 500, frmh = 250;
    private Timer t1;
    private int val = 0;
    private MainFrame file;
    private JFileChooser jfc =new JFileChooser();
    private String loadfilename = "";

    public EncryptFile(MainFrame file){
        this.file = file;
        init6();
    }
    public void init6(){
        this.setBounds(120,120,frmw,frmh);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                file.setVisible(true);
            }
        });
        cp = this.getContentPane();
        cp.add(jpN, BorderLayout.NORTH);
        cp.add(jpW, BorderLayout.WEST);
        cp.add(jpC, BorderLayout.CENTER);
        cp.add(jpE, BorderLayout.EAST);
        cp.add(jpS, BorderLayout.SOUTH);
        jpN.add(jlb3);
        jpN.add(jcomb);
        jpN.add(jlbkey);
        jpN.add(jtfkey);
        jpN.add(jbtnrun);
        jpN.add(jbtnclose);
        jpW.add(jlb1);
        jpW.add(jlb2);
        jpC.add(jtf1);
        jpC.add(jtf2);
        jpE.add(jbtnload);
        jpE.add(jbtnsave);
        jpS.add(jpb);
        jbtnload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jfc.showOpenDialog(EncryptFile.this)==JFileChooser.APPROVE_OPTION){
                    loadfilename= jfc.getSelectedFile().getPath();
                    jtf1.setText(jfc.getSelectedFile().getPath());
                    jtf2.setText(jtf1.getText()+"sec");
                }

            }
        });
        jbtnrun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if (loadfilename.equals("")) {
                        JOptionPane.showMessageDialog(EncryptFile.this, "No File Selected");
                    } else {
                        try {
                            File SelectFile = new File(loadfilename);
                            long fileLength = SelectFile.length();
                            jpb.setMaximum(100);
                            char key[] = jlbkey.getText().toCharArray();
                            FileReader fr = new FileReader(SelectFile);
                            BufferedReader bfr = new BufferedReader(fr);
                            File writeFile = new File(jtf2.getText());
                            FileWriter fw = new FileWriter(writeFile);
                            BufferedWriter bfw = new BufferedWriter(fw);
                            int data;
                            int i = 0;
                            while ((data = bfr.read()) != -1) {
                                data = data ^ key[i % key.length];
                                bfw.write(data);
                                i++;
                                jpb.setValue(Math.round((float) i / fileLength * 100));
                            }
                            fr.close();
                            bfw.close();
                         JOptionPane.showMessageDialog(EncryptFile.this, "Finish");
                    }catch (Exception io2){
                    JOptionPane.showMessageDialog(EncryptFile.this,"Open File Error:"+io2.toString());
                }
                    }
            }
        });

    }
}