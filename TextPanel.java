import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import java.awt.*;

/**
 * Created by Александр on 07.08.2015.
 */
public class TextPanel extends JPanel{
    private Mind mind;
    private JTextField claimField;
    private JTextField calculationField;
    private Document doc;
    public static final byte claimField_MaxLength = 13;
    public static final byte calculationField_MaxLength = 34;

    public JTextField getClaimField() {
        return claimField;
    }

    public Mind getMind() {
        return mind;
    }

    public TextPanel() {
        setBackground(Color.GREEN);
        setLayout(new GridBagLayout());

        mind = new Mind();
        doc = new CalcFilter();
        claimField = new JTextField();
        calculationField = new JTextField();
        claimField.setFont(new Font("Sylfaen", Font.BOLD, 40 ));
        calculationField.setFont( new Font("Sylfaen", Font.BOLD, 15 ));


        claimField.setHorizontalAlignment(JTextField.RIGHT);
        calculationField.setHorizontalAlignment(JTextField.RIGHT);

        claimField.setDocument(doc);
        claimField.setFocusCycleRoot(true);
        calculationField.setFocusable(false);

        claimField.setBorder(BorderFactory.createEmptyBorder());
        calculationField.setBorder(BorderFactory.createEmptyBorder());


        add(calculationField, new GridBagConstraints(0, 0, 5, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(15, 15, 0, 15), 0, 0));
        add(claimField, new GridBagConstraints(0, 1, 5, 2, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(0, 15, 15, 15), 0, 0));

    }

    boolean isNumberInClaim() {
        return claimField.getText().length() > 0 && Character.isDigit(claimField.getText().charAt(claimField.getText().length() - 1));
    }

    public void changingOfClaim(String str) throws BadLocationException {
        doc.insertString(claimField.getText().length(), String.valueOf(str), null);
    }

    public void clearClaimField(){
        claimField.setText("");
    }

    public void clearAllFields(){
        clearClaimField();
        calculationField.setText("");
    }

    public void backspace() throws BadLocationException {
        if(claimField.getText().length() > 0)
            claimField.setText(claimField.getText(0, claimField.getText().length() - 1));
    }

    public void functionCall(String str){
        calculationField.setText(calculationField.getText() + str + "(" + claimField.getText() + ")");
        clearClaimField();
    }

    public void memoryRecall() {
        claimField.setText(String.valueOf(mind.getMemoryClass().getMemory()));
    }

    private class CalcFilter extends PlainDocument {
        private final String acceptedChars = "0123456789.-+*/^|=";
        private boolean waitingForSign = false;

        public String acceptedSymbols(String str) throws BadLocationException {
            StringBuilder text = new StringBuilder(str);
            char ch = text.charAt(text.length() - 1);

            if(calculationField.getText().indexOf('=') != -1)                                                           //clean calculation field
                calculationField.setText("");

            if(waitingForSign) {                                                                                        //if function waiting for sign
                if (acceptedChars.indexOf(ch) < 11 || acceptedChars.indexOf(ch) > 15)
                    text.deleteCharAt(text.length() - 1);
                else {
                    calculationField.setText(calculationField.getText() + " " + ch + " ");
                    text.deleteCharAt(text.length() - 1);
                    waitingForSign = false;
                }
            } else {

                if ((ch == 'r' || ch == 'g' || ch == 'n') && isNumberInClaim()) {                                       //if function was entered
                    waitingForSign = true;
                    if ((ch == 'r' && new Double(claimField.getText()) == 0) || (new Double(claimField.getText()) <= 0)) {
                        JOptionPane.showMessageDialog(null, "Недопустимое значение!!!");
                        clearClaimField();
                    } else {
                        if (mind.getClaim() == null) {
                            if (ch == 'r')
                                mind.setClaim(String.valueOf(mind.reciproc(claimField.getText())));
                            else if (ch == 'g')
                                mind.setClaim(String.valueOf(mind.log(claimField.getText())));
                            else
                                mind.setClaim(String.valueOf(mind.ln(claimField.getText())));
                        }else {
                            if (ch == 'r')
                                mind.action(String.valueOf(mind.reciproc(claimField.getText())),
                                        calculationField.getText().charAt(calculationField.getText().length() - 2));
                            else if (ch == 'g')
                                mind.action(String.valueOf(mind.log(claimField.getText())),
                                        calculationField.getText().charAt(calculationField.getText().length() - 2));
                            else
                                mind.action(String.valueOf(mind.ln(claimField.getText())),
                                        calculationField.getText().charAt(calculationField.getText().length() - 2));
                        }

                        if(ch == 'r')
                            functionCall("reciproc");
                        else if (ch == 'g')
                            functionCall("log");
                        else
                            functionCall("ln");
                    }
                    text.deleteCharAt(text.length() - 1);
                } else {
                    if (acceptedChars.indexOf(ch) == -1)                                                                //checking accepted of symbol
                        text.deleteCharAt(text.length() - 1);
                    else if ((claimField.getText().length() >= claimField_MaxLength && acceptedChars.indexOf(ch) <= 9)  //if first symbol not digit or '-'
                            || ((acceptedChars.indexOf(ch) == 10 || acceptedChars.indexOf(ch) > 11) &&
                            claimField.getText().length() == 0) || (ch == '-' && claimField.getText().equals("-")))
                        text.deleteCharAt(text.length() - 1);
                    else if (ch == '.' && claimField.getText().indexOf('.') != -1)                                      //trying to use '.' twice
                        text.deleteCharAt(text.length() - 1);
                    else if (ch == '|') {                                                                               //if trying to change sign
                        if (claimField.getText().charAt(0) == '-')
                            claimField.setText(claimField.getText(1, claimField.getText().length()));
                        else
                            claimField.setText("-" + claimField.getText());
                        text.deleteCharAt(text.length() - 1);
                    } else if (acceptedChars.indexOf(ch) > 10 && !isNumberInClaim()) {
                        text.deleteCharAt(text.length() - 1);
                    } else if (acceptedChars.indexOf(ch) > 10 && isNumberInClaim()) {                                   //action

                        if (mind.getClaim() == null) {
                            mind.setClaim(claimField.getText());
                        } else
                            mind.action(claimField.getText(),
                                    calculationField.getText().charAt(calculationField.getText().length() - 2));

                        if (ch != '=')
                            calculationField.setText(calculationField.getText() + claimField.getText() + " " + ch + " ");
                        else
                            calculationField.setText(calculationField.getText() + claimField.getText());

                        clearClaimField();
                        text.deleteCharAt(text.length() - 1);
                    }
                }
            }

            if(ch == '=' && mind.getClaim() != null){
                calculationField.setText(calculationField.getText() + " = " + mind.getClaim() + " ");
                waitingForSign = false;
                mind.clearClaim();
            }

            if(calculationField.getText().length() > calculationField_MaxLength){
                calculationField.setText("<<" +
                        calculationField.getText().substring(calculationField.getText().length() - calculationField_MaxLength));
            }

            return text.toString();
        }

        public void insertString(int offset,
                                 String string, AttributeSet attr) throws BadLocationException {
            super.insertString(offset, acceptedSymbols(string), attr);
            claimField.requestFocusInWindow();
        }

    }
}
