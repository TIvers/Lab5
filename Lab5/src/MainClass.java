

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MainClass {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(350, 300);
		frame.setLocation(500, 700);
		frame.setTitle("Калькулятор");
		frame.setVisible(true);
		
		frame.setLayout(new FlowLayout());

		final JTextField firstField = new JTextField(30);
		final JComboBox<String> operationCombo = new JComboBox<String>(new String[] {"+", "-", "*", "/"});
		final JTextField secondField = new JTextField(30);
		final JButton calculateButton = new JButton("=");
		final JTextField resultField = new JTextField(30);
		
		frame.add(firstField);
		frame.add(operationCombo);
		frame.add(secondField);
		frame.add(calculateButton);
		frame.add(resultField);

		calculateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				float result = 0;
				String text_result = "";
				try {
					float x = Float.parseFloat(firstField.getText());
					float y = Float.parseFloat(secondField.getText());
					String operation = (String) operationCombo.getSelectedItem();
					switch (operation) {
						case ("+"):
							result = x + y;
							break;
						case ("*"):
							result = x * y;
							break;
						case ("/"):
							if(y!=0) { result = x / y; }
							else { text_result = "Ошибка в расчётах"; }
							break;
						case ("-"):
							result = x - y;
							break;
							}}
				catch (NumberFormatException nfe) {
					text_result = "Ошибка в расчётах";
				
				}
				if(text_result == "") { text_result = Float.toString(result); }
				resultField.setText(String.valueOf(text_result));
			}			
		});
		
		
		
	}
}
