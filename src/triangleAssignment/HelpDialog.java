package triangleAssignment;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class HelpDialog extends JDialog {

	private static final long serialVersionUID = 2687L;
	MaterialColors mColor = new MaterialColors();
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			HelpDialog dialog = new HelpDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public HelpDialog() {

		setTitle("HELP MENU");
		setIconImage(Toolkit.getDefaultToolkit().getImage(HelpDialog.class.getResource("/menuIcons/info-icon.png")));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextPane mainDisplay = new JTextPane();
			JScrollPane scrollPane = new JScrollPane(mainDisplay);
			mainDisplay.setEditable(false);
			mainDisplay.setFont(new Font("Calibri", Font.PLAIN, 16));
			mainDisplay.setContentType("text/html");
			mainDisplay.setBounds(0, 0, 434, 229);
			HTMLDocument doc = (HTMLDocument)mainDisplay.getDocument();
			HTMLEditorKit editorKit = (HTMLEditorKit)mainDisplay.getEditorKit();
			scrollPane.setBounds(0, 0, 434, 229);
			contentPanel.add(scrollPane);
			String text = "<h1>HELP MENU</h1><p>It is important to understand how to use any applications before using them. "
					+ "Although Yonglin Seal of Approval Triangle Calculator is designed with intuition in mind, its robustness is certainly "
					+ "intimidating to many new users. Thus we decided to create this help section to provide answers to some user questions. "
					+ "The help section consists multiple topics that covers most known issues.</p>"
					+ "<h2>TABLE OF CONTENT</h2>"
					+ "<ul><li>Components</li><li>Calculation Operations<ul><b>Side Length Based Operation Modes</b><ul><li>Right Triangle Operations</li><li>Any Triangle Operations</li></ul></ul><ul><b>Coordinate Based Operation Modes</b></ul></li><li>Q&A</li></ul>"
					+ "<h2>Components</h2>"
					+ "<h3>Side Panel Components</h3>"
					+ "<h4>Editable Textfields</h4><p>Textfields that accepts your inputs.</p>"
					+ "<h4>Uneditable Textfields</h4><p>Textfields that cannot be edited.</p>"
					+ "<h4>Submit Buttons</h4><p>When you click the button, all inputs will be accepted and calculation will be done.</p>"
					+ "<h4>Regular modes toggle button</h4><p>Click this button to toggle between length based calculation modes - any triangle mode and right triangle only mode.</p>"
					+ "<h3>Header Menu Components</h3>"
					+ "<h4>Help Button</h4><p>The button you clicked to open this help menu.</p>"
					+ "<h4>Information Button</h4><p>Click to see more information about this application.</p>"
					+ "<h4>Coordinate/Length based modes toggle</h4><p>Click this button to toggle between length based calculation mode and coordinate based calculation mode.</p>"
					+ "<h4>Color selection Box</h4><p>Change the color of the triangle with this combo box list. (Disabled for Coordinate Triangle Mode)</p>"
					+ "<h2>Side Length Based Operation Mode</h2>"
					+ "<h3>Right Triangle Only Operation Mode</h3>"
					+ "<p>This operation mode is the set as default on every launch, in this mode, the application accepts will accept 2 inputs from you in the two input boxes labled \"length of side a\" and \"length of side b\", each representing a length of the Right-angle sides that forms a right triangle. The length of the hypotenuse as well as the area of the triangle will be calculated when the green calculate button is pressed(or enter is pressed in the text fields). A 1:1 sized triangle will also be painted on the canvas on the right.</p>"
					+ "<p><B>LIMITS:</B> Unfortunately, this application only accepts Right-angle side lengths less than 200 units and greater than 0 units. Furthermore, the application only accepts <b>integer values</b>.</p>"
					+ "<h3>Any Triangle Operation Mode</h3>"
					+ "<p>This operation mode can be launched by clicking the green toggle button titled \"Toggle to Any\"(You can see this mode live when the triangle on the right canvas becomes an isoceles triangle). In this mode, the application accepts will accept 3 inputs from you in all three input boxes on the left panel, each representing the length of a side that forms a triangle. The area of the triangle will be calculated when the green calculate button is pressed(or enter is pressed in the text fields). A 1:1 sized triangle will also be painted on the canvas on the right.</p><p><B>LIMITS:</B> Unfortunately, this application only accepts side lengths less than 200 units and greater than 0 units that <i>forms a triangle</i>(the sum of two sides must be longer than the other one). Furthermore, the application only accepts <b>integer values</b>.</p>"
					+ "<h2>Coordinate Based Operation Mode</h2>"
					+ "<p>This operation mode can be launched by clicking the red toggle button titled \"Toggle to Any\". In this mode, the application accepts will accept 6 inputs from you in all six input boxes on the bottom panel, each representing a coordinate value of three points that forms a triangle. The area of the triangle will be calculated when the green calculate button is pressed(or enter is pressed in the text fields). A 1:1 sized triangle will also be painted on the canvas.</p><p><B>LIMITS:</B> Unfortunately, this application only accepts coordinate values between 200 and -200 units. Furthermore, the application only accepts <b>integer values</b>.</p>"
					+ "<h2>Q&A</h2>"
					+ "<h3>Functional Issues</h3><h4>1. Why does it keep saying <i>\"please input integer value ONLY\"</i> when all the numbers I inputed are numeric?</h4><p>Please check all values in the textfields are completely integers, that means they should not consist any decimal values (for example: 12.0 is unacceptable).</p><h4>2. Why does it keep saying <i>\"Integers between 1-200 ONLY\"</i>?</h4><p>Please check if all inputs are less than or equal to 200</p><h3>Interface Design Issues</h3><h4>1. Why did you choose this color? It looks so crappy...</h4><p><b>HATER...</b> It is very unfortunate that you do not like the color of the interface, I will do my best to improve the interface of the next program. For now, you are only able to change the color of the triangle.</p><h4>2. Why is triangle color changing disabled in coordinate calculation mode?</h4><p>It felt useless in the mode and it also caused me some troubles, so I decided to get rid of it.</p>"
					+ "<h2>THIS IS THE END OF THE HELP FILE</h2>";
			try {
				editorKit.insertHTML(doc, doc.getLength(), text, 0, 0, null);
			} catch (BadLocationException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}


		}
	}
}
