import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DigiralTimer extends JFrame {
    private Container cp ;
    private JLabel jlbs[] = new JLabel[8];
    private JPanel jpnc =new JPanel(new GridLayout(1,8,2,2));
    private String jlbImageName[] ={"0.PNG","1.PNG","2.PNG","3.PNG","4.PNG","5.PNG","6.PNG","7.PNG","8.PNG","9.PNG"};
    private ImageIcon icons[] =new ImageIcon[10];
    private JPanel jpns =new JPanel(new GridLayout(1,3,3,3));
    private JButton jbtnstart =new JButton("start");
    private JButton jbtnrest =new JButton("rest");
    private JButton jbtnclose =new JButton("close");
    private Timer t1 ;
    private int h,m,s;
    private MainFrame dtr;
    public DigiralTimer(MainFrame dtr){
        this.dtr=dtr;
        init7();
    }
    private void init7(){
        cp=getContentPane();
        this.setBounds(100,100,300,150);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dtr.setVisible(true);
            }
        });
        cp.setLayout(new BorderLayout(3,3));
        cp.add(jpnc, BorderLayout.CENTER);
        cp.add(jpns, BorderLayout.SOUTH);
        for (int i=0;i<10;i++){
            icons[i] =new ImageIcon(jlbImageName[i]);
            Image img =icons[i].getImage();
            Image newimg =img.getScaledInstance(30,60, Image.SCALE_SMOOTH);
            icons[i]=new ImageIcon(newimg);
        }
        jlbs[6]=new JLabel(":");
        jlbs[6].setFont(new Font(null,Font.BOLD,24));
        jlbs[6].setHorizontalAlignment(JLabel.CENTER);
        jlbs[7]=new JLabel(":");
        jlbs[7].setFont(new Font(null,Font.BOLD,24));
        jlbs[7].setHorizontalAlignment(JLabel.CENTER);
        for (int i=0;i<6;i++){
            jlbs[i]=new JLabel(icons[0]);
            if (i==2){
                jpnc.add(jlbs[6]);
                jpnc.add(jlbs[i]);
            }else if (i==4){
                jpnc.add(jlbs[7]);
                jpnc.add(jlbs[i]);
            }else {
                jpnc.add(jlbs[i]);
            }
        }
        t1 =new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             s++;
             if (s==60){
                 s = 0;
                 m++;
                 if (m==60){
                   m=0;
                   h++;
                 }
             }
             jlbs[5].setIcon(icons[s%10]);
             jlbs[4].setIcon(icons[s/10]);
             jlbs[3].setIcon(icons[m%10]);
             jlbs[2].setIcon(icons[m/10]);
             jlbs[1].setIcon(icons[h%10]);
             jlbs[0].setIcon(icons[h/10]);
             if (s%2==0){
                 jlbs[6].setForeground(Color.GREEN);
                 jlbs[7].setForeground(Color.GREEN);
             }else {
                 jlbs[6].setForeground(Color.RED);
                 jlbs[7].setForeground(Color.RED);
             }

            }
        });
        jpns.add(jbtnstart);
        jpns.add(jbtnrest);
        jpns.add(jbtnclose);
        jbtnstart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton tmpBtn=(JButton)e.getSource();
                if (tmpBtn.getText().equals("start")){
                    t1.start();
                    tmpBtn.setText("pause");
                }else {
                    t1.stop();
                    tmpBtn.setText("start");
                }
            }
        });
        jbtnrest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                t1.stop();
            }
        });


    }

}
