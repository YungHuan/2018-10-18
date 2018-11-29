import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private Container cp;
    private JMenuBar jmbr =new JMenuBar();
    private JMenu jm1 =new JMenu("File");
    private JMenu jm2 =new JMenu("Tool");
    private JMenu jm3 =new JMenu("Game");
    private JMenu jm4 =new JMenu("Help");
    private JMenuItem jmop =new JMenuItem("Open");
    private JMenuItem jmcl =new JMenuItem("Close");
    private JMenuItem jmexit =new JMenuItem("Exit");
    private JMenuItem jmOOXX =new JMenuItem("OOXX");
    private JMenuItem jmPokemon =new JMenuItem("Pokemon");
    private JMenuItem jmkeymove =new JMenuItem("Keymove");
    private JMenuItem jmclient =new JMenuItem("Client");
    private JMenuItem jmencrypt =new JMenuItem("Encrypt");
    private JMenuItem jmencryptfile =new JMenuItem("EncryptFile");
    private JMenuItem jmenDigiralTimer =new JMenuItem("DigiralTimer");
    public MainFrame(){
        init3();
    }
    private void init3(){
        this.setBounds(100, 100, 500, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setJMenuBar(jmbr);
        jmbr.add(jm1);
        jmbr.add(jm2);
        jmbr.add(jm3);
        jmbr.add(jm4);
        jm1.add(jmop);
        jm1.add(jmcl);
        jm1.add(jmexit);
        jm2.add(jmencrypt);
        jm2.add(jmencryptfile);
        jm2.add(jmenDigiralTimer);
        jm3.add(jmOOXX);
        jm3.add(jmPokemon);
        jm3.add(jmkeymove);
        jm3.add(jmclient);
        jmexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jmencrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Encrypt op = new Encrypt(MainFrame.this);
                op.setVisible(true);
                MainFrame.this.setVisible(false);
            }
        });
        jmOOXX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OOXX ox = new OOXX(MainFrame.this);
                ox.setVisible(true);
                MainFrame.this.setVisible(false);
            }
        });
        jmencryptfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EncryptFile file =new EncryptFile(MainFrame.this);
                file.setVisible(true);
                MainFrame.this.setVisible(false);
            }
        });
        jmenDigiralTimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DigiralTimer dt =new DigiralTimer(MainFrame.this);
                dt.setVisible(true);
                MainFrame.this.setVisible(false);
            }
        });
        jmPokemon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pokemon pok =new Pokemon(MainFrame.this);
                pok.setVisible(true);
                MainFrame.this.setVisible(false);
            }
        });
        jmkeymove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Keymove keymo =new Keymove(MainFrame.this);
                keymo.setVisible(true);
                MainFrame.this.setVisible(false);
            }
        });
        jmclient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client cli =new Client(MainFrame.this);
                cli.setVisible(true);
                MainFrame.this.setVisible(false);
            }
        });
    }
}