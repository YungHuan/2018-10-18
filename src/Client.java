import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.Socket;

public class Client extends JFrame {
    private JButton jb =new JButton("連線" );
    private MainFrame clie;
    public Client(MainFrame clie){
        this.clie=clie;
        init10();
    }
    private void init10(){
        this.setBounds(500,500,500,500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.add(jb);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                byte buff[]=new byte[1024];
                try{
                    System.out.println("正在與伺服器建立連線...");
                    Socket s =new Socket("10.51.3.93",2525);
                    System.out.println("已經與伺服器取得連線...");
                    InputStream in =s.getInputStream();
                    int n=in.read(buff);
                    System.out.println("從伺服器到:");
                    System.out.println(new String(buff,0,n));
                    in.close();
                    s.close();
                }
                catch (Exception aa){
                    System.out.println("發生了"+e+"例外");
                }
            }
        });
    }
}
