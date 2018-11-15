import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keymove extends JFrame {
//    private JButton jb1 =new JButton("Run");
//    private JButton jb2 =new JButton("左");
//    private JButton jb3 =new JButton("右");
//    private JButton jb4 =new JButton("上");
//    private JButton jb5 =new JButton("下");
//    private JButton jb6 =new JButton("Exit");
    private Container cp;
    private JLabel jl =new JLabel();
    private ImageIcon ig =new ImageIcon("pokemon.jpg");
    private Timer t1 ;
    private JPanel jp1 =new JPanel(new GridLayout(1,6,3,3));
    private int dir =1 ,objx=50,objy=50,objw=50,objh=50;
    private MainFrame key;

    public Keymove(MainFrame key){
        this.key=key;
        init9();
    }
    public void init9(){
        this.setBounds(100,100,600,600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp =this.getContentPane();
        cp.add(jp1,BorderLayout.SOUTH);
        cp.add(jl,BorderLayout.CENTER);
        jl.setIcon(ig);
//        jp1.add(jb1);
//        jp1.add(jb2);
//        jp1.add(jb3);
//        jp1.add(jb4);
//        jp1.add(jb5);
//        jp1.add(jb6);

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
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case 37:
                       dir=3;
                        break;
                    case 38:
                       dir=1;
                        break;
                    case 39:
                    dir=4;
                        break;
                    case 40:
                        dir=2;
                        break;
                    case 32:
                        t1.start();
                        break;
                }
            }
        });

    }
}