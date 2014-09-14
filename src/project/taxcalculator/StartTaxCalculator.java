/*
 * 
 * Copyright 2014 Gunjeet Hattar

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package project.taxcalculator;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class StartTaxCalculator extends JFrame {
	
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField incomeInput;
	private double taxValue = 0;
	private double totalIncome = 0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartTaxCalculator frame = new StartTaxCalculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StartTaxCalculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		incomeInput = new JTextField();
		incomeInput.setBounds(225, 51, 219, 41);
		contentPane.add(incomeInput);
		incomeInput.setColumns(10);
		
		JLabel incomeLable = new JLabel("Enter Total Income (€)");
		incomeLable.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		incomeLable.setBounds(26, 62, 182, 16);
		contentPane.add(incomeLable);
		
		JButton calculateButton = new JButton("Calculate");
		calculateButton.setBounds(145, 119, 128, 48);
		contentPane.add(calculateButton);
		
		JLabel answerLable = new JLabel("You Payable Tax");
		answerLable.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		answerLable.setBounds(26, 214, 138, 16);
		contentPane.add(answerLable);
		
		JLabel anwerOuput = new JLabel("");
		anwerOuput.setFont(new Font("Arial", Font.PLAIN, 20));
		anwerOuput.setBounds(225, 201, 195, 41);
		contentPane.add(anwerOuput);
		
		
		// Defining Action After Button Is Clicked
		calculateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				calculateTax();
				String finalValue = Double.toString(taxValue);
				anwerOuput.setText(finalValue);
			}
		});
		
	}
	
	public double calculateTax(){
		String income = incomeInput.getText(); //obtaining the value entered within the Income Text Field
		totalIncome = Integer.parseInt(income.toString());  // converting the input above to an Integer value
		
		// Checking condition for 1st 300000 of taxable income at 7% 
		if(totalIncome <= 300000){
			taxValue = totalIncome * 0.07;
		} 
		else if (totalIncome > 300000){
			taxValue = 300000 * 0.07;
			totalIncome -= 300000;
		}
		
		
		// Checking condition for next 300000 of taxable income at 11%
		if(totalIncome <= 300000){
			taxValue = taxValue + (totalIncome * 0.11);
		} 
		else if(totalIncome > 300000){
			taxValue = taxValue + (300000 * 0.11);
			totalIncome -= 300000;
		}
		
		
		// Checking condition for next 500000 of taxable income at 15%
		if(totalIncome <= 500000){
			taxValue = taxValue + (totalIncome * 0.15);
		} 
		else if(totalIncome > 500000){
			taxValue = taxValue + (500000 * 0.15);
			totalIncome -= 500000;
		}
		
		
		// Checking condition for next 500000 of taxable income at 19%
		if(totalIncome <= 500000){
			taxValue = taxValue + (totalIncome * 0.19);
		} 
		else if(totalIncome > 500000){
			taxValue = taxValue + (500000 * 0.19);
			totalIncome -= 500000;
		}
		
		
		// Checking condition for next 1600000 of taxable income at 21%
		
		
		//System.out.println(totalIncome);
		
		return taxValue;
	}
}
