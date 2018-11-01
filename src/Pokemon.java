import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pokemon extends JFrame {
    private JButton jb1 =new JButton("Run");
    private JButton jb2 =new JButton("左");
    private JButton jb3 =new JButton("右");
    private JButton jb4 =new JButton("上");
    private JButton jb5 =new JButton("下");
    private JButton jb6 =new JButton("Exit");
    private Container cp;
    private JLabel jl =new JLabel();
    private ImageIcon ig =new ImageIcon("pokemon.jpg");
    private Timer t1 ;
    private JPanel jp1 =new JPanel(new GridLayout(1,6,3,3));
    private int dir =0 ,objx=50,objy=50,objw=50,objh=50;
    private MainFrame poke;

    public Pokemon(MainFrame poke){
        this.poke=poke;
        init8();
    }
    public void init8(){
        this.setBounds(100,100,600,600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp =this.getContentPane();
        cp.add(jp1,BorderLayout.SOUTH);
        cp.add(jl,BorderLayout.CENTER);
        jl.setIcon(ig);
        jp1.add(jb1);
        jp1.add(jb2);
        jp1.add(jb3);
        jp1.add(jb4);
        jp1.add(jb5);
        jp1.add(jb6);

        jl.setBounds(objx,objy,objw,objh);
        t1 =new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (dir){
                    case 1:
                        if (objy-2>-240){
                            objy-=5;
                        }else {
                            dir=2;
                        }
                        break;
                    case 2:
                        if (objy<300-objh){
                            objy+=5;
                        }else {
                            dir=1;
                        }
                        break;
                    case 3:
                        if (objx-2>0){
                            objx-=5;
                        }else {
                            dir=4;
                        }
                        break;
                    case 4:
                        if (objx<600-objw){
                            objx+=5;
                        }else {
                            dir=3;
                        }
                        break;
                }
                jl.setLocation(objx,objy);
            }


        });
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.start();
            }
        });
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dir=3;
            }
        });
        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dir=4;
            }
        });
        jb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dir=1;
            }
        });
        jb5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dir=2;
            }
        });
        jb6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}