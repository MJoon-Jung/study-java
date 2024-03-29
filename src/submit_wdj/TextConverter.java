package submit_wdj;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class TextConverter extends JFrame implements ActionListener, KeyListener{
	private JButton convertBtn;
	private JButton cancelBtn;
	private JTextArea textIn;
	private JTextArea textOut;
	private PapagoApi papago = new PapagoApi();
	
	public TextConverter() {
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 786, 553);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("papago");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 38));
		lblNewLabel.setBounds(332, 10, 130, 46);
		panel.add(lblNewLabel);
		
		textIn = new JTextArea(20,30);
		textIn.setBounds(27,72,350,390);
		textIn.setFont(new Font("굴림", Font.PLAIN, 20));
		textIn.addKeyListener(this);
		JScrollPane scroll1 = new JScrollPane(textIn);
		scroll1.setPreferredSize(new Dimension(350,390));
		scroll1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		textOut = new JTextArea(20,30);
		textOut.setBounds(406, 72, 350, 390);
		textOut.setFont(new Font("Arial", Font.PLAIN, 20));
		
		textIn.setLineWrap(true);
		textOut.setLineWrap(true);
		textOut.setEditable(false);
		
		
		panel.add(textIn);
		panel.add(textOut);
		
		convertBtn = new JButton("convert");
		convertBtn.addActionListener(this);
		convertBtn.setBounds(251, 472, 130, 51);
		
		cancelBtn = new JButton("cancel");
		cancelBtn.addActionListener(this);
		cancelBtn.setBounds(400,472,130,51);
		
		panel.add(convertBtn);
		panel.add(cancelBtn);
		
//		JPanel btnPanel = new JPanel();
//		btnPanel.add(convertBtn);
//		btnPanel.add(cancelBtn);
//		
//		JPanel mainPanel = new JPanel(new GridLayout(2,1,20,20));
		
//		mainPanel.add(panel);
//		mainPanel.add(btnPanel);
//		this.add(mainPanel);
		this.add(scroll1);
		this.add(panel);
		this.pack();
		this.setSize(800,600);
		this.setTitle("papago");
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == convertBtn) {
			//textIn 에서 받아온 텍스트를 번역해서 textOut에 올린다.
			textOut.setText(papago.Convert(textIn.getText()));
		}else if(e.getSource() == cancelBtn) {
			textIn.setText("");
			textOut.setText("");
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		String s = textIn.getText();
		String a = s.replace(" ", "");
		a = a.replace("\n", "");
		if(!a.equals("")) {
			textOut.setText(papago.Convert(textIn.getText()));
		}
	}
	public static void main(String[] args) {
		new TextConverter();
	}
	@Override
	public void keyPressed(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
}
