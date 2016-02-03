import javax.swing.*;
import java.awt.*;

/**
 * Created by Александр on 07.08.2015.
 */
public class MainFrame extends JFrame{
    private String title;
    private Dimension dimension;


    public MainFrame(String t, Dimension d){
        title = t;
        dimension = d;
    }

    public void paint(){
        setTitle(title);

        setSize(dimension);
        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("agt_business.png").getImage());

        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        TextPanel tp = new TextPanel();
        add(tp, BorderLayout.NORTH);

        ButtonsPanel bp = new ButtonsPanel(tp);
        add(bp, BorderLayout.CENTER);

        setVisible(true);
    }
}
