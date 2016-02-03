import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Александр on 07.08.2015.
 */
public class ButtonsPanel extends JPanel{
    private TextPanel textPanel;

    private ArrayList<JButton> digits = new ArrayList<JButton>(10);
    private JButton plus;
    private JButton minus;
    private JButton multiply;
    private JButton divide;
    private JButton pow;
    private JButton log;
    private JButton ln;
    private JButton changeSign;
    private JButton reciproc;
    private JButton C;
    private JButton CE;
    private JButton mplus;
    private JButton mminus;
    private JButton ms;
    private JButton mc;
    private JButton mr;
    private JButton backspace;
    private JButton coma;
    private JButton eq;


    public ButtonsPanel(TextPanel tp){
        setBackground(Color.GREEN);
        setLayout(new GridBagLayout());

        textPanel = tp;

        MyActionListener actionListener = new MyActionListener();

        for(int i = 0; i < 10; i++){
            digits.add(i, new JButton(String.valueOf(i)));
            digits.get(i).setFont(new Font("Sylfaen", Font.BOLD, 20 ));
            digits.get(i).addActionListener(actionListener);
        }

        plus = new JButton("+");
        plus.addActionListener(actionListener);
        minus = new JButton("-");
        minus.addActionListener(actionListener);
        multiply = new JButton(new ImageIcon("multiply.png"));
        multiply.addActionListener(actionListener);
        divide = new JButton(new ImageIcon("divide.png"));
        divide.addActionListener(actionListener);
        pow = new JButton("pow");
        pow.addActionListener(actionListener);
        log = new JButton("log");
        log.addActionListener(actionListener);
        ln = new JButton("ln");
        ln.addActionListener(actionListener);
        changeSign = new JButton("+/-");
        changeSign.addActionListener(actionListener);
        reciproc = new JButton("1/x");
        reciproc.addActionListener(actionListener);
        C = new JButton("C");
        C.addActionListener(actionListener);
        CE = new JButton("CE");
        CE.addActionListener(actionListener);
        mplus = new JButton("M+");
        mplus.addActionListener(actionListener);
        mminus = new JButton("M-");
        mminus.addActionListener(actionListener);
        ms = new JButton("MS");
        ms.addActionListener(actionListener);
        mc = new JButton("MC");
        mc.addActionListener(actionListener);
        mr = new JButton("MR");
        mr.addActionListener(actionListener);
        backspace = new JButton(new ImageIcon("backspace1.png"));
        backspace.addActionListener(actionListener);
        coma = new JButton(".");
        coma.addActionListener(actionListener);
        eq = new JButton("=");
        eq.addActionListener(actionListener);

        add(mc, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(5, 15, 5, 5), 0, 0));
        add(mr, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
        add(mplus, new GridBagConstraints(2, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
        add(mminus, new GridBagConstraints(3, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
        add(ms, new GridBagConstraints(4, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(5, 5, 5, 15), 0, 0));

        add(backspace, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(5, 15, 5, 5), 0, 0));
        add(CE, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
        add(C, new GridBagConstraints(2, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
        add(reciproc, new GridBagConstraints(3, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
        add(log, new GridBagConstraints(4, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(5, 5, 5, 15), 0, 0));

        add(digits.get(7), new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(5, 15, 5, 5), 0, 0));
        add(digits.get(8), new GridBagConstraints(1, 2, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
        add(digits.get(9), new GridBagConstraints(2, 2, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
        add(divide, new GridBagConstraints(3, 2, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
        add(ln, new GridBagConstraints(4, 2, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(5, 5, 5, 15), 0, 0));

        add(digits.get(4), new GridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(5, 15, 5, 5), 0, 0));
        add(digits.get(5), new GridBagConstraints(1, 3, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
        add(digits.get(6), new GridBagConstraints(2 , 3, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
        add(multiply, new GridBagConstraints(3, 3, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
        add(pow, new GridBagConstraints(4, 3, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(5, 5, 5, 15), 0, 0));

        add(digits.get(1), new GridBagConstraints(0, 4, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(5, 15, 5, 5), 0, 0));
        add(digits.get(2), new GridBagConstraints(1, 4, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
        add(digits.get(3), new GridBagConstraints(2, 4, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
        add(minus, new GridBagConstraints(3, 4, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
        add(eq, new GridBagConstraints(4, 4, 1, 2, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(5, 5, 15, 15), 0, 0));

        add(digits.get(0), new GridBagConstraints(0, 5, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(5, 15, 15, 5), 0, 0));
        add(coma, new GridBagConstraints(1, 5, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(5, 5, 15, 5), 0, 0));
        add(changeSign, new GridBagConstraints(2, 5, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(5, 5, 15, 5), 0, 0));
        add(plus, new GridBagConstraints(3, 5, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(5, 5, 15, 5), 0, 0));
    }

    private void colorMemoryButtons(Color color){
        ms.setBackground(color);
        mr.setBackground(color);
        mc.setBackground(color);
        mplus.setBackground(color);
        mminus.setBackground(color);
    }

    private class MyActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            try {
                if (digits.contains(e.getSource()))
                    textPanel.changingOfClaim(String.valueOf(digits.indexOf(e.getSource())));
                else if (e.getSource().equals(backspace))
                    try {
                        textPanel.backspace();
                    } catch (BadLocationException e1) {
                        System.out.println("Backspace error e:" + e1);
                    }
                else if (e.getSource().equals(coma))
                    textPanel.changingOfClaim(".");
                else if (e.getSource().equals(eq))
                    textPanel.changingOfClaim("=");
                else if (e.getSource().equals(plus))
                    textPanel.changingOfClaim("+");
                else if (e.getSource().equals(minus))
                    textPanel.changingOfClaim("-");
                else if (e.getSource().equals(multiply))
                    textPanel.changingOfClaim("*");
                else if (e.getSource().equals(divide))
                    textPanel.changingOfClaim("/");
                else if (e.getSource().equals(pow))
                    textPanel.changingOfClaim("^");
                else if (e.getSource().equals(log))
                    textPanel.changingOfClaim("g");
                else if (e.getSource().equals(ln))
                    textPanel.changingOfClaim("n");
                else if (e.getSource().equals(changeSign))
                    textPanel.changingOfClaim("|");
                else if (e.getSource().equals(reciproc))
                    textPanel.changingOfClaim("r");
                else if (e.getSource().equals(C))
                    textPanel.clearClaimField();
                else if (e.getSource().equals(CE))
                    textPanel.clearAllFields();
                else if (e.getSource().equals(mplus)) {
                    if (textPanel.isNumberInClaim()) {
                        textPanel.getMind().getMemoryClass().addToMemory(textPanel.getClaimField().getText());
                        colorMemoryButtons(Color.CYAN);
                    }
                }else if (e.getSource().equals(mminus)) {
                    if (textPanel.isNumberInClaim()) {
                        textPanel.getMind().getMemoryClass().takeAwayFromMemory(textPanel.getClaimField().getText());
                        colorMemoryButtons(Color.CYAN);
                    }
                }else if (e.getSource().equals(ms)) {
                    if (textPanel.isNumberInClaim()) {
                        textPanel.getMind().getMemoryClass().setMemory(textPanel.getClaimField().getText());
                        colorMemoryButtons(Color.CYAN);
                    }
                }else if (e.getSource().equals(mr))
                    textPanel.memoryRecall();
                else if (e.getSource().equals(mc)) {
                    textPanel.getMind().getMemoryClass().clearMemory();
                    colorMemoryButtons(Color.WHITE);
                }

            } catch (BadLocationException e1) {
                System.out.println("Problem with buttons e:" + e1);
            }

        }

    }
}
