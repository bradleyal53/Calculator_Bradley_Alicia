import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class calculator {

	private JFrame frame;
	private JPanel operationsPanel; 
	private JPanel buttonsPanel; 
	private JPanel otherPanel; 
	private JTextField text; 
	private int resultTotal; 
	private JButton addOpp; 
	private JButton clear;
	private JButton subOpp; 
	private JButton multOpp;
	private JButton divOpp;
	private JButton powOpp; 
	private JButton leftPOpp; 
	private JButton rightPOpp; 
	private JButton zeroButton;
	private JButton equalsButton; 
	private JButton[] numberButtons;
	private StringBuilder initialResult = new StringBuilder(); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculator window = new calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}); 
		
		/*String infix = "3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3"; 
		System.out.printf("infix: %s%n", infix); 
		System.out.printf("postfix: %s%n", infixToPostfix(infix)); */
	}

	/**
	 * Create the application.
	 */
	public calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// creating frame 
		frame = new JFrame();
		frame.setSize(300, 300);
		frame.setTitle("Alicia's Unbreakable Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// creating a text box for calculations
		text = new JTextField(); 
		text.setHorizontalAlignment(JTextField.RIGHT);
		text.setEditable(false);
		frame.add(text, BorderLayout.NORTH);  // adds text to frame
		// creating panel for buttons 
		operationsPanel = new JPanel(); 
		operationsPanel.setLayout(new GridLayout(4, 2)); 
		frame.add(operationsPanel, BorderLayout.EAST);
		// adding labels to buttons
		addOpp = new JButton("+");
		clear = new JButton("C");
		subOpp = new JButton("-"); 
		multOpp = new JButton("*");
		divOpp = new JButton("/"); 
		powOpp = new JButton("^"); 
		leftPOpp = new JButton("("); 
		rightPOpp = new JButton(")"); 
		operationsPanel.add(addOpp); 
		operationsPanel.add(clear); 
		operationsPanel.add(subOpp); 
		operationsPanel.add(multOpp); 
		operationsPanel.add(divOpp); 
		operationsPanel.add(powOpp);
		operationsPanel.add(leftPOpp);
		operationsPanel.add(rightPOpp); 
		
		buttonsPanel = new JPanel(); 
		buttonsPanel.setLayout(new GridLayout(3,3)); 
		frame.add(buttonsPanel, BorderLayout.CENTER);
		numberButtons = new JButton[10]; 
		for(int i = 1; i < 10; i++){
			numberButtons[i-1] = new JButton(Integer.toString(i)); 
			buttonsPanel.add(numberButtons[i-1]); 
		} // end for 
		
		otherPanel = new JPanel(); 
		otherPanel.setLayout(new GridLayout(1,2)); 
		frame.add(otherPanel, BorderLayout.SOUTH);
		zeroButton = new JButton("0"); 
		equalsButton = new JButton("="); 
		otherPanel.add(zeroButton); 
		otherPanel.add(equalsButton); 
		
		clear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				clearButtonActionPerformed(event); 
			} // end actionPerformed
		});
		
		zeroButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				zeroButtonActionPerformed(event); 
			} // end actionPerformed
		}); 
		
		numberButtons[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				oneButtonActionPerformed(event); 
			} // end actionPerformed
		}); 
		
		numberButtons[1].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				twoButtonActionPerformed(event); 
			} // end actionPerformed
		}); 
		
		numberButtons[2].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				threeButtonActionPerformed(event); 
			} // end actionPerformed
		}); 
		
		numberButtons[3].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				fourButtonActionPerformed(event); 
			} // end actionPerformed
		}); 
		
		numberButtons[4].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				fiveButtonActionPerformed(event); 
			} // end actionPerformed
		}); 
		
		numberButtons[5].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				sixButtonActionPerformed(event); 
			} // end actionPerformed
		}); 
		
		numberButtons[6].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				sevenButtonActionPerformed(event); 
			} // end actionPerformed
		}); 
		
		numberButtons[7].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				eightButtonActionPerformed(event); 
			} // end actionPerformed
		}); 
		
		numberButtons[8].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				nineButtonActionPerformed(event); 
			} // end actionPerformed
		}); 
		
		addOpp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				addOppActionPerformed(event); 
			} // end actionPerformed
		}); 
		
		subOpp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				subOppActionPerformed(event); 
			} // end actionPerformed
		}); 
		
		multOpp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				multOppActionPerformed(event); 
			} // end actionPerformed
		}); 
		
		divOpp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				divOppActionPerformed(event); 
			} // end actionPerformed
		}); 
		
		powOpp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				powOppActionPerformed(event); 
			} // end actionPerformed
		}); 
		
		leftPOpp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				leftPOppActionPerformed(event); 
			} // end actionPerformed
		}); 
		
		rightPOpp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				rightPOppActionPerformed(event); 
			} // end actionPerformed
		}); 
		
		equalsButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				equalsButtonActionPerformed(event); 
			} // end actionPerformed
		}); 
	} // end initialize 
	
	private void zeroButtonActionPerformed(ActionEvent event){
		text.setText(text.getText() + zeroButton.getText());
		initialResult.append(zeroButton.getText()); 
	} // end zeroButtonActionPerformed
	
	private void oneButtonActionPerformed(ActionEvent event){
		text.setText(text.getText() + numberButtons[0].getText());
		initialResult.append(numberButtons[0].getText()); 
	} // end oneButtonActionPerformed
	
	private void twoButtonActionPerformed(ActionEvent event){
		text.setText(text.getText() + numberButtons[1].getText());
		initialResult.append(numberButtons[1].getText()); 
	} // end two ButtonActionPerformed
	
	private void threeButtonActionPerformed(ActionEvent event){
		text.setText(text.getText() + numberButtons[2].getText());
		initialResult.append(numberButtons[2].getText()); 
	} // end threeButtonActionPerformed
	
	private void fourButtonActionPerformed(ActionEvent event){
		text.setText(text.getText() + numberButtons[3].getText());
		initialResult.append(numberButtons[3].getText()); 
	} // end fourButtonActionPerformed
	
	private void fiveButtonActionPerformed(ActionEvent event){
		text.setText(text.getText() + numberButtons[4].getText());
		initialResult.append(numberButtons[4].getText()); 
	} // end fiveButtonActionPerformed
	
	private void sixButtonActionPerformed(ActionEvent event){
		text.setText(text.getText() + numberButtons[5].getText());
		initialResult.append(numberButtons[5].getText()); 
	} // end sixButtonActionPerformed
	
	private void sevenButtonActionPerformed(ActionEvent event){
		text.setText(text.getText() + numberButtons[6].getText());
		initialResult.append(numberButtons[6].getText()); 
	} // end sevenButtonActionPerformed
	
	private void eightButtonActionPerformed(ActionEvent event){
		text.setText(text.getText() + numberButtons[7].getText());
		initialResult.append(numberButtons[7].getText()); 
	} // end eightButtonActionPerformed
	
	private void nineButtonActionPerformed(ActionEvent event){
		text.setText(text.getText() + numberButtons[8].getText());
		initialResult.append(numberButtons[8].getText()); 
	} // end nineButtonActionPerformed
	
	private void addOppActionPerformed(ActionEvent event){
		text.setText(text.getText() + addOpp.getText()); 
		initialResult.append(addOpp.getText()); 
	} // end addOppButtonActionPerformed
	
	private void subOppActionPerformed(ActionEvent event){
		text.setText(text.getText() + subOpp.getText()); 
		initialResult.append(subOpp.getText()); 
	} // end subOppButtonActionPerformed
	
	private void multOppActionPerformed(ActionEvent event){
		text.setText(text.getText() + multOpp.getText()); 
		initialResult.append(multOpp.getText()); 
	} // end multOppButtonActionPerformed
	
	private void divOppActionPerformed(ActionEvent event){
		text.setText(text.getText() + divOpp.getText()); 
		initialResult.append(divOpp.getText()); 
	} // end divOppButtonActionPerformed
	
	private void powOppActionPerformed(ActionEvent event){
		text.setText(text.getText() + powOpp.getText());
		initialResult.append(powOpp.getText()); 
	} // end powOppButtonActionPerformed
	
	private void leftPOppActionPerformed(ActionEvent event){
		text.setText(text.getText() + leftPOpp.getText());
		initialResult.append(leftPOpp.getText()); 
	} // end leftPOppButtonActionPerformed
	
	private void rightPOppActionPerformed(ActionEvent event){
		text.setText(text.getText() + rightPOpp.getText()); 
		initialResult.append(rightPOpp.getText()); 
	} // end rightsPOppButtonActionPerformed
	
	private void clearButtonActionPerformed(ActionEvent event){
		text.setText(""); 
		initialResult.setLength(0);
	} // end clearButtonActionPerformed
	
	private void equalsButtonActionPerformed(ActionEvent event){
		text.setText("result: " + evalPost(infixToPostfix(initialResult.toString())));
	} // end equalsButtonActionPerformed

	static String infixToPostfix(String infix) {
        final String ops = "-+/*^";
        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();
 
        for (String token : infix.split("")) {
            if (token.isEmpty())
                continue;
            char c = token.charAt(0);
            int idx = ops.indexOf(c);
 
            // check for operator
            if (idx != -1) {
                if (s.isEmpty())
                    s.push(idx);
 
                else {
                    while (!s.isEmpty()) {
                        int prec2 = s.peek() / 2;
                        int prec1 = idx / 2;
                        if (prec2 > prec1 || (prec2 == prec1 && c != '^'))
                            sb.append(ops.charAt(s.pop())).append(' ');
                        else break;
                    }
                    s.push(idx);
                }
            } 
            else if (c == '(') {
                s.push(-2); // -2 stands for '('
            } 
            else if (c == ')') {
                // until '(' on stack, pop operators.
                while (s.peek() != -2)
                    sb.append(ops.charAt(s.pop())).append(' ');
                s.pop();
            }
            else {
                sb.append(token).append(' ');
            }
        }
        while (!s.isEmpty())
            sb.append(ops.charAt(s.pop())).append(' ');
        return sb.toString();
    } // end infixToPostfix 
	
	private String evalPost(String string){
		Stack<Double> secStack = new Stack(); 
		Scanner scan = new Scanner(string); 
		while (scan.hasNext()){
			if(scan.hasNextInt()){
				secStack.push(scan.nextDouble()); 
			} // end if 
			else {
				double num2 = secStack.pop(); 
				double num1 = secStack.pop();
				String ops = scan.next(); 
				
				switch(ops){
				case "+": 
					secStack.push(num1 + num2); 
					break; 
				case "-": 
					secStack.push(num1 - num2); 
					break; 
				case "*": 
					secStack.push(num1 * num2); 
					break; 
				case "/": 
					secStack.push(num1 / num2); 
					break; 
				case "^": 
					secStack.push( Math.pow(num1, num2)); 
					break; 
				default: 
					return null;  
				} // end switch
				return Double.toString(secStack.pop());
			} // else 
		} // end while		
		return null; 
	} // end evalPost
} // end calculator 
