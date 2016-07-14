package triangleAssignment;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class InformationDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	MaterialColors mColor = new MaterialColors();
	private Color btnColor = new Color(76,175,80);
	private Color btnHoverColor = new Color(56,142,60);

	/**
	 * Create the dialog.
	 */
	public InformationDialog() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InformationDialog.class.getResource("/appIcons/128.png")));
		setTitle("Information");
		setBounds(100, 100, 434, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextPane infoTextBox = new JTextPane();
			infoTextBox.setEditable(false);
			infoTextBox.setForeground(Color.WHITE);
			infoTextBox.setFont(new Font("Calibri", Font.PLAIN, 16));
			infoTextBox.setBounds(0, 0, 424, 224);
			infoTextBox.setBackground(mColor.RED);
			infoTextBox.setText("Copyleft (c) 2016 Designed and Programmed by Yonglin Wang.\r\nSoftware Used:\r\n\tEclipse\r\n\tAdobe Creative Cloud\r\nExternal libraries:\r\n\torg.eclipse.wb.swing\r\nFor more information about the author: visit yonglinwang.net or yonglin.design.");
			contentPanel.add(infoTextBox);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(211,47,47));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				final JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Calibri", Font.BOLD, 16));
				okButton.setForeground(Color.WHITE);
				okButton.setBackground(mColor.GREEN);
				okButton.setBorderPainted(false);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				okButton.addMouseListener(new MouseAdapter(){
					@Override
					public void mouseEntered(MouseEvent e) {
						okButton.setBackground(btnHoverColor);
					}
					public void mouseExited(MouseEvent e){
						okButton.setBackground(btnColor);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
