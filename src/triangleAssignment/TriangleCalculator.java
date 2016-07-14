package triangleAssignment;//construction module

import java.awt.EventQueue;//used to

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Graphics;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JToggleButton;
import javax.swing.ListCellRenderer;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.JEditorPane;
import javax.swing.border.Border;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.SwingConstants;


/**
 * <blockquote>I think I worked pretty hard on this...<blockquote>
 * <p>The Yonglin Seal of Approval Triangle Calculator is created with intuition, efficiency, and elegance in mind,
 * Designed and programmed to be not just functional but also beautiful. </p>
 * <p>As the name of the application describes, this is a triangle graphics calculator, that is able to not just calculate multiple
 * statuses of a triangle, but also render it out in front of the user to create a marvelous experience.</p>
 * <p>The application is able to accept user inputs regarding side length values and coordinates which allow the system
 * to calculate variables and render triangle graphics.</p>
 * <p>Modes this triangle calculator supports</p>
 * <ol>
 * <li>Right Triangle Mode (This is a length based calculation mode)
 * <li>Any Triangle Mode (This is a length based calculation mode)
 * <li>Coordinate based calculation mode</ol>
 * @author Yonglin Wang
 *
 * @since JDK 1.7.0_71
 */
public class TriangleCalculator extends JPanel{
	private static final long serialVersionUID = 2586L;
	
	/**
	 * Creating a IntegerChecking object that checks input for integer before processed
	 */
	IntegerChecking ic = new IntegerChecking();
	/**
	 * Create a DrawTriangle object that consists multiple methods for rendering triangle on canvas and defines the origin point of the printing
	 */
	DrawTriangle dt = new DrawTriangle(200,250);
	/**
	 * Create a MaterialColors object that consists many color variables
	 */
	MaterialColors mColor = new MaterialColors();
	/**
	 * Create a coordinate based canvas on screen and initialize the coordinate drawing system
	 */
	CoordinateSystem cs = new CoordinateSystem();
	/**
	 * Create a custom list cell renderer
	 */
	ListCellRenderer<Object> renderer = new ComplexCellRenderer();
	/**
	 * Calling the help dialog window
	 */
	HelpDialog hd = new HelpDialog();
	/**
	 * Global boolean to determine if the user is in right triangle mode
	 */
	private boolean rightMode = true;
	/**
	 * Declare the usage of a JFrame called <code>frmTriangleCalculator</code>, later initialized in the <code>initialize</code> method
	 */
	private JFrame frmTriangleCalculator;
	/**
	 * Declare the usage of a JTextField called <code>sideAInput</code>, later initialized in the <code>initialize</code> method
	 * used to accept user input regarding side A length
	 */
	private JTextField sideAInput;
	/**
	 * Declare the usage of a JTextField called <code>sideBInput</code>, later initialized in the <code>initialize</code> method
	 * used to accept user input regarding side A length
	 */
	private JTextField sideBInput;
	/**
	 * Declare the usage of a JTextField called <code>areaOutput</code>, later initialized in the <code>initialize</code> method
	 * used to accept user input regarding side A length
	 */
	private JTextField areaOutput;
	/**
	 * Declare the usage of a JTextField called <code>printRightArea</code>, later initialized in the <code>initialize</code> method
	 * used to accept user input regarding side A length
	 */
	private JTextField printRightArea;
	/**
	 * Declare the usage of a JTextField called <code>hypotenuseInput</code>, later initialized in the <code>initialize</code> method
	 * used to accept user input regarding side A length
	 */
	private JTextField hypotenuseInput;
	/**
	 * Declare the usage of a JTextField called <code>x3</code>, later initialized in the <code>initialize</code> method
	 * used to accept user input regarding side A length
	 */
	private JTextField x3;
	/**
	 * Declare the usage of a JTextField called <code>y3</code>, later initialized in the <code>initialize</code> method
	 * used to accept user input regarding side A length
	 */
	private JTextField y3;
	/**
	 * Declare the usage of a JTextField called <code>x1</code>, later initialized in the <code>initialize</code> method
	 * used to accept user input regarding side A length
	 */
	private JTextField x1;
	/**
	 * Declare the usage of a JTextField called <code>y1</code>, later initialized in the <code>initialize</code> method
	 * used to accept user input regarding side A length
	 */
	private JTextField y1;
	/**
	 * Declare the usage of a JTextField called <code>x2</code>, later initialized in the <code>initialize</code> method
	 * used to accept user input regarding side A length
	 */
	private JTextField x2;
	/**
	 * Declare the usage of a JTextField called <code>y2</code>, later initialized in the <code>initialize</code> method
	 * used to accept user input regarding side A length
	 */
	private JTextField y2;
	//Labels for UI design
	private JLabel lblsideBInputPrompt;
	private JLabel lblHypotenuse;
	private JLabel lblWarning;
	private JLabel lblWarningCoordinate;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	//Colors for UI design
	private Color canvasColor = new Color(244, 67, 54);
	private Color sidePanelColor = new Color(211,47,47);
	private Color btnColor = new Color(76,175,80);
	private Color tglbtnColor = new Color(129,199,132);
	private Color btnHoverColor = new Color(56,142,60);
	private Color txtDisabledColor = new Color(198,40,40);
	private Color txtColor = new Color(183,28,28);
	private Color tglbtnHoverColor = new Color(165,214,167);
	//borders for UI design
	Border inputBorder = BorderFactory.createLineBorder(txtColor, 1);
	Border disabledBorder = BorderFactory.createLineBorder(txtDisabledColor, 1);
	//a editor pane used as a background
	private JEditorPane coInputBackground;
	//buttons seen in the menu bar
	private JButton btnHelp;
	private JButton btnInformation;
	/**
	 * Defines all the elements in the color selection list
	 */
	private Object elements[][] = {
			{new ColorIcon(mColor.GREEN,15,15), "GREEN"},
			{new ColorIcon(mColor.PINK,15,15), "PINK"},
			{new ColorIcon(mColor.PURPLE,15,15), "PURPLE"},
			{new ColorIcon(mColor.DEEP_PURPLE,15,15), "DEEP PURPLE"},
			{new ColorIcon(mColor.INDIGO,15,15), "INDIGO"},
			{new ColorIcon(mColor.BLUE,15,15), "BLUE"},
			{new ColorIcon(mColor.LIGHT_BLUE,15,15), "LIGHT BLUE"},
			{new ColorIcon(mColor.CYAN,15,15), "CYAN"},
			{new ColorIcon(mColor.TEAL,15,15), "TEAL"},
			{new ColorIcon(mColor.LIGHT_GREEN,15,15), "LIGHT GREEN"},
			{new ColorIcon(mColor.LIME,15,15), "LIME"},
			{new ColorIcon(mColor.YELLOW,15,15), "YELLOW"},
			{new ColorIcon(mColor.AMBER,15,15), "AMBER"},
			{new ColorIcon(mColor.ORANGE,15,15), "ORANGE"},
			{new ColorIcon(mColor.DEEP_ORANGE,15,15), "DEEP ORANGE"},
			{new ColorIcon(mColor.BROWN,15,15), "BROWN"} };
	/**
	 * An array of colors used to define the rendering color of triangle
	 */
	private Object[] triangleColors = new Object[] {mColor.GREEN, mColor.PINK, mColor.PURPLE, mColor.DEEP_PURPLE, 
			mColor.INDIGO, mColor.BLUE, mColor.LIGHT_BLUE, mColor.CYAN, mColor.TEAL, mColor.LIGHT_GREEN, mColor.LIME, 
			mColor.YELLOW, mColor.AMBER, mColor.ORANGE, mColor.DEEP_ORANGE, mColor.BROWN};

	/**
	 * <p>This class defines a small object with a dynamic diameter determined by the user.
	 * The icon can be used to preview a color.</p>
	 * 
	 * @author Yonglin Wang
	 *
	 */
	class ColorIcon implements Icon {
		/**
		 * The color of the icon object
		 */
		Color iconColorLocal;
		/**
		 * The height of the icon, default 15px high
		 */
		int iconHeight = 15;
		/**
		 * The width of the icon, default 15px wide
		 */
		int iconWidth = 15;
		/**
		 * <p>Accepts parameter input and modifies the definitions</p>
		 * @param iconColor - the color definition of the object
		 * @param height - the width definition of the object
		 * @param width - the height definition of the object
		 */
		public ColorIcon(Color iconColor, int height, int width) {
			iconColorLocal = iconColor;
			iconHeight = height;
			iconWidth = width;
		}
		/**
		 * Returns custom icon height
		 */
		public int getIconHeight() {
			return iconHeight;
		}

		/**
		 * Returns custom icon width
		 */
		public int getIconWidth() {
			return iconWidth;
		}
		/**
		 * Displays the icon
		 */
		public void paintIcon(Component c, Graphics g, int x, int y) {
			g.setColor(iconColorLocal);
			g.fillRect(3, 3, iconHeight, iconWidth);
		}
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TriangleCalculator window = new TriangleCalculator();
					window.frmTriangleCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public TriangleCalculator() {
		initialize();
	}
	/**
	 * <p><i>Functional Method</i>, <code>initialize</code> method Initialize the contents of the frame.
	 * this is automatically run every launch.</p>
	 * <>
	 * 
	 */
	private void initialize() {

		frmTriangleCalculator = new JFrame();
		frmTriangleCalculator.setIconImage(Toolkit.getDefaultToolkit().getImage(TriangleCalculator.class.getResource("/appIcons/128.png")));
		frmTriangleCalculator.setFont(new Font("Calibri", Font.PLAIN, 14));
		frmTriangleCalculator.setTitle("Triangle Calculator");
		frmTriangleCalculator.setBounds(100, 100, 500, 372);
		frmTriangleCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTriangleCalculator.setResizable(false);

		frmTriangleCalculator.getContentPane().add(dt);
		dt.drawDefaultRightTriangle();
		cs.setLayout(null);
		cs.setBackground(canvasColor);

		JButton btnDraw = new JButton("DRAW");
		btnDraw.setBackground(btnColor);
		btnDraw.setForeground(Color.white);
		btnDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paintCoTriangle();
			}
		});
		btnDraw.setBounds(402, 285, 80, 22);
		cs.add(btnDraw);
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBackground(btnColor);
		btnClear.setForeground(Color.white);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cs.clearCanvas();
			}
		});
		btnClear.setBounds(402, 255, 80, 22);
		cs.add(btnClear);
		dt.setLayout(null);
		sideAInput = new JTextField("50");
		sideAInput.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetLabel(lblWarning);
			}
		});
		sideAInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					selectOutputProcess();
				}
			}
		});
		sideAInput.setForeground(Color.white);
		sideAInput.setBackground(txtColor);
		sideAInput.setBorder(inputBorder);
		sideAInput.setFont(new Font("Calibri", Font.BOLD, 14));
		sideAInput.setBounds(10, 34, 133, 21);
		sideAInput.setColumns(10);
		dt.add(sideAInput);

		sideBInput = new JTextField("100");
		sideBInput.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetLabel(lblWarning);
			}
		});
		sideBInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					selectOutputProcess();
				}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
					lblWarning.setText("");
				}
			}
		});
		sideBInput.setForeground(Color.white);
		sideBInput.setBackground(txtColor);
		sideBInput.setBorder(inputBorder);
		sideBInput.setFont(new Font("Calibri", Font.BOLD, 14));
		sideBInput.setBounds(10, 85, 133, 21);
		dt.add(sideBInput);
		sideBInput.setColumns(10);

		JLabel lblSideAInputPrompt = new JLabel("Value of side A");
		lblSideAInputPrompt.setLabelFor(sideAInput);
		lblSideAInputPrompt.setForeground(Color.WHITE);
		lblSideAInputPrompt.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblSideAInputPrompt.setBounds(10, 10, 109, 26);
		dt.add(lblSideAInputPrompt);

		lblsideBInputPrompt = new JLabel("Value of side B");
		lblsideBInputPrompt.setLabelFor(sideBInput);
		lblsideBInputPrompt.setForeground(Color.WHITE);
		lblsideBInputPrompt.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblsideBInputPrompt.setBounds(10, 60, 109, 26);
		dt.add(lblsideBInputPrompt);

		lblHypotenuse = new JLabel("Hypotenuse");
		lblHypotenuse.setForeground(Color.WHITE);
		lblHypotenuse.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblHypotenuse.setBounds(10, 112, 109, 26);
		dt.add(lblHypotenuse);

		hypotenuseInput = new JTextField();
		hypotenuseInput.setToolTipText("Displays the hypotenuse in Right triangle mode(read only). Accepts the length of side c in Advanced Triangle Mode");
		lblHypotenuse.setLabelFor(hypotenuseInput);
		hypotenuseInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					selectOutputProcess();
				}
			}
		});
		hypotenuseInput.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetLabel(lblWarning);
			}
		});
		hypotenuseInput.setBackground(txtDisabledColor);
		hypotenuseInput.setBorder(disabledBorder);
		hypotenuseInput.setEditable(false);
		hypotenuseInput.setForeground(Color.white);
		hypotenuseInput.setFont(new Font("Calibri", Font.BOLD, 14));
		hypotenuseInput.setColumns(10);
		hypotenuseInput.setBounds(10, 137, 133, 21);
		dt.add(hypotenuseInput);

		final JButton submitBtn = new JButton("CALCULATE");
		submitBtn.setToolTipText("Calculates the area of the triangle and paints the triangle");
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectOutputProcess();
			}
		});
		submitBtn.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				submitBtn.setBackground(btnHoverColor);
			}
			public void mouseExited(MouseEvent e){
				submitBtn.setBackground(btnColor);
			}
		});
		submitBtn.setBackground(btnColor);
		submitBtn.setForeground(Color.white);
		submitBtn.setBorderPainted(false);
		submitBtn.setFont(new Font("Calibri", Font.BOLD, 14));
		submitBtn.setBounds(10, 199, 133, 50);
		dt.add(submitBtn);

		final JToggleButton tglbtnChangeToOther = new JToggleButton("TGL TO ANY");
		tglbtnChangeToOther.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				tglbtnChangeToOther.setBackground(tglbtnHoverColor);
			}
			public void mouseExited(MouseEvent e) {
				tglbtnChangeToOther.setBackground(tglbtnColor);
			}
		});
		tglbtnChangeToOther.setBackground(tglbtnColor);
		tglbtnChangeToOther.setForeground(Color.white);
		tglbtnChangeToOther.setBorderPainted(false);
		tglbtnChangeToOther.setToolTipText("Advance Mode allows you to paint acute and obtuse triangles");
		tglbtnChangeToOther.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED){
					hypotenuseInput.setEditable(true);
					dt.drawDefaultTriangle();
					tglbtnChangeToOther.setToolTipText("");
					tglbtnChangeToOther.setFont(new Font("Calibri", Font.ITALIC, 11));
					tglbtnChangeToOther.setText("TGL TO RIGHT");
					changeLblText(lblHypotenuse, "Value of side C");
					rightMode = false;
				} else if(e.getStateChange()==ItemEvent.DESELECTED){
					hypotenuseInput.setEditable(false);
					hypotenuseInput.setText("");
					dt.drawDefaultRightTriangle();
					tglbtnChangeToOther.setFont(new Font("Calibri", Font.ITALIC, 14));
					tglbtnChangeToOther.setToolTipText("Advance Mode allows you to paint acute and obtuse triangles");
					tglbtnChangeToOther.setText("TGL TO NORMAL");
					changeLblText(lblHypotenuse, "Hypotenuse");
					rightMode = true;
				}
			}

		});
		tglbtnChangeToOther.setFont(new Font("Calibri", Font.ITALIC, 14));
		tglbtnChangeToOther.setBounds(10, 166, 133, 23);
		dt.add(tglbtnChangeToOther);

		lblWarning = new JLabel();
		lblWarning.setFont(new Font("Calibri", Font.ITALIC, 14));
		lblWarning.setForeground(Color.white);
		lblWarning.setBounds(176, 284, 306, 26);
		dt.add(lblWarning);
		dt.setBackground(canvasColor);
		printRightArea = new JTextField();
		printRightArea.setToolTipText("Displays the area of the triangle, read only");
		printRightArea.setFont(new Font("Calibri", Font.BOLD, 16));
		printRightArea.setEditable(false);
		printRightArea.setForeground(Color.white);
		printRightArea.setBackground(txtColor);
		printRightArea.setBorder(inputBorder);
		printRightArea.setBounds(61, 259, 82, 21);
		printRightArea.setColumns(10);
		dt.add(printRightArea);

		JLabel lblArea = new JLabel("Area:");
		lblArea.setLabelFor(printRightArea);
		lblArea.setFont(new Font("Calibri", Font.BOLD, 16));
		lblArea.setForeground(Color.white);
		lblArea.setBounds(10, 263, 41, 15);
		dt.add(lblArea);

		JEditorPane editorPane = new JEditorPane();
		editorPane.setEnabled(false);
		editorPane.setBackground(new Color(229,57,53));
		editorPane.setBounds(0, 0, 163, 314);
		dt.add(editorPane);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(sidePanelColor);
		frmTriangleCalculator.setJMenuBar(menuBar);

		btnHelp = new JButton("");
		btnHelp.setToolTipText("See help menu");
		btnHelp.setIcon(new ImageIcon(TriangleCalculator.class.getResource("/menuIcons/help-icon.png")));
		btnHelp.setBackground(sidePanelColor);
		btnHelp.setForeground(Color.white);
		btnHelp.setBorderPainted(false);
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				hd.setVisible(true);
			}
		});
		btnHelp.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				btnHelp.setBackground(txtColor);
			}
			public void mouseExited(MouseEvent e){
				btnHelp.setBackground(sidePanelColor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btnHelp.setBackground(txtColor);
			}
		});
		menuBar.add(btnHelp);

		btnInformation = new JButton("");
		btnInformation.setToolTipText("See more information about this APP, as well as the credits.");
		btnInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InformationDialog dialog = new InformationDialog();
				dialog.setVisible(true);
			}
		});
		btnInformation.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				btnInformation.setBackground(txtColor);
			}
			public void mouseExited(MouseEvent e){
				btnInformation.setBackground(sidePanelColor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btnInformation.setBackground(txtColor);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				btnInformation.setBackground(txtColor);
			}
		});
		btnInformation.setIcon(new ImageIcon(TriangleCalculator.class.getResource("/menuIcons/info-icon.png")));
		btnInformation.setBackground(sidePanelColor);
		btnInformation.setForeground(Color.white);
		btnInformation.setBorderPainted(false);
		menuBar.add(btnInformation);

		final JComboBox<Object> triColorSelect = new JComboBox<Object>(elements);
		triColorSelect.setToolTipText("Toggle the color of the triangle in NORMAL MODE.");
		triColorSelect.setBackground(sidePanelColor);
		triColorSelect.setForeground(Color.white);
		triColorSelect.setRenderer(renderer);
		triColorSelect.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					int color =  triColorSelect.getSelectedIndex();
					dt.changeTriangleColor((Color) triangleColors[color]);
				}
			}
		});

		final JToggleButton tglMode = new JToggleButton("TOGGLE TO COORDINATE MODE");
		tglMode.setToolTipText("Toggle between normal calculator and coordination mode");
		tglMode.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED){
					frmTriangleCalculator.getContentPane().add(cs);
					cs.paintDefaultTriangle();
					triColorSelect.setEnabled(false);
					dt.setVisible(false);
					cs.setVisible(true);
					tglMode.setText("TOGGLE TO LENGTH BASED MODE");
				} else if(e.getStateChange()==ItemEvent.DESELECTED){
					tglMode.setText("TOGGLE TO COORDINATE MODE");
					dt.drawDefaultRightTriangle();
					cs.setVisible(false);
					dt.setVisible(true);
					triColorSelect.setEnabled(true);
				}
			}
		});
		tglMode.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				tglMode.setBackground(txtColor);
			}
			public void mouseExited(MouseEvent e){
				tglMode.setBackground(sidePanelColor);
			}
		});
		tglMode.setBorderPainted(false);
		tglMode.setBackground(sidePanelColor);
		tglMode.setForeground(Color.white);
		menuBar.add(tglMode);
		menuBar.add(triColorSelect);

		label_3 = new JLabel(")");
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(392, 287, 17, 18);
		cs.add(label_3);

		label_1 = new JLabel(")(");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(226, 287, 17, 18);
		cs.add(label_1);

		label_2 = new JLabel(")(");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(309, 287, 17, 18);
		cs.add(label_2);

		x3 = new JTextField();
		x3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetLabel(lblWarningCoordinate);
			}
		});
		x3.setHorizontalAlignment(SwingConstants.CENTER);
		x3.setFont(new Font("Calibri", Font.BOLD, 16));
		x3.setText("40");
		x3.setColumns(10);
		x3.setBackground(txtColor);
		x3.setBorder(inputBorder);
		x3.setForeground(Color.white);
		x3.setBounds(319, 285, 33, 22);
		cs.add(x3);

		y3 = new JTextField();
		y3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetLabel(lblWarningCoordinate);
			}
		});
		y3.setHorizontalAlignment(SwingConstants.CENTER);
		y3.setFont(new Font("Calibri", Font.BOLD, 16));
		y3.setText("-50");
		y3.setColumns(10);
		y3.setBackground(txtColor);
		y3.setBorder(inputBorder);
		y3.setForeground(Color.white);
		y3.setBounds(357, 285, 33, 22);
		cs.add(y3);

		x1 = new JTextField();
		x1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetLabel(lblWarningCoordinate);
			}
		});
		x1.setHorizontalAlignment(SwingConstants.CENTER);
		x1.setFont(new Font("Calibri", Font.BOLD, 16));
		x1.setText("0");
		x1.setBackground(txtColor);
		x1.setBorder(inputBorder);
		x1.setForeground(Color.white);
		x1.setColumns(10);
		x1.setBounds(153, 285, 33, 22);
		cs.add(x1);

		y1 = new JTextField();
		y1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetLabel(lblWarningCoordinate);
			}
		});
		y1.setHorizontalAlignment(SwingConstants.CENTER);
		y1.setFont(new Font("Calibri", Font.BOLD, 16));
		y1.setText("0");
		y1.setColumns(10);
		y1.setBackground(txtColor);
		y1.setBorder(inputBorder);
		y1.setForeground(Color.white);
		y1.setBounds(191, 285, 33, 22);
		cs.add(y1);

		x2 = new JTextField();
		x2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetLabel(lblWarningCoordinate);
			}
		});
		x2.setHorizontalAlignment(SwingConstants.CENTER);
		x2.setFont(new Font("Calibri", Font.BOLD, 16));
		x2.setText("60");
		x2.setColumns(10);
		x2.setBackground(txtColor);
		x2.setBorder(inputBorder);
		x2.setForeground(Color.white);
		x2.setBounds(236, 285, 33, 22);
		cs.add(x2);

		y2 = new JTextField();
		y2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetLabel(lblWarningCoordinate);
			}
		});
		y2.setHorizontalAlignment(SwingConstants.CENTER);
		y2.setFont(new Font("Calibri", Font.BOLD, 16));
		y2.setText("20");
		y2.setColumns(10);
		y2.setBackground(txtColor);
		y2.setBorder(inputBorder);
		y2.setForeground(Color.white);
		y2.setBounds(274, 285, 33, 22);
		cs.add(y2);

		areaOutput = new JTextField();
		areaOutput.setEditable(false);
		areaOutput.setBounds(402, 225, 80, 22);
		areaOutput.setColumns(10);
		areaOutput.setBackground(txtColor);
		areaOutput.setBorder(inputBorder);
		areaOutput.setForeground(Color.white);
		areaOutput.setFont(new Font("Calibri", Font.BOLD, 15));
		cs.add(areaOutput);
		
		lblWarningCoordinate = new JLabel();
		lblWarningCoordinate.setFont(new Font("Calibri", Font.BOLD, 15));
		lblWarningCoordinate.setForeground(Color.white);
		lblWarningCoordinate.setBounds(130, 150, 306, 26);
		cs.add(lblWarningCoordinate);

		JLabel lblCoInstructions = new JLabel("(Xa,Ya) (Xb,Yb) (Xc,Yc)");
		lblCoInstructions.setForeground(Color.WHITE);
		lblCoInstructions.setBounds(5, 287, 135, 18);
		cs.add(lblCoInstructions);

		JLabel label = new JLabel("(");
		label.setForeground(Color.WHITE);
		label.setBounds(146, 287, 55, 18);
		cs.add(label);

		coInputBackground = new JEditorPane();
		coInputBackground.setEditable(false);
		coInputBackground.setBounds(0, 278, 494, 36);
		coInputBackground.setBackground(sidePanelColor);
		cs.add(coInputBackground);
		cs.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{x1, y1, x2, y2, x3, y3, btnDraw}));
		frmTriangleCalculator.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{sideAInput, sideBInput, hypotenuseInput, submitBtn, printRightArea}));
	}
	/**
	 * <p><i>Functional Method</i>, the <code>calcIsoArea</code> method utilizes the triangle area calculation method to
	 * calculate the area of a right triangle.</p>
	 * @param height - the height value of the triangle
	 * @param width - the width value of the triangle
	 * @return The area of a right triangle, according to parameter values.
	 */
	private double calcRightArea(int height, int width) {
		return (double)height*width/2;
	}
	/**
	 * <p><i>Functional Method</i>, through Heron's Formula, using <code>aLength</code>, <code>bLength</code>, <code>cLength</code>
	 * the <code>calcTriArea</code> method is able to calculate the area of a triangle.</p>
	 * @param a - the length of side a
	 * @param b - the length of side b
	 * @param c - the length of side c
	 * @return The area of a triangle, according to parameter values.
	 */
	private double calcTriArea(int a, int b, int c){
		double p = (double)(a+b+c)/2;
		return Math.round(Math.sqrt(p*(p-a)*(p-b)*(p-c)));
	}
	/**
	 * <p><i>Procedural Method</i>, the <code>resetLable</code> method resets the content of an label to "".
	 * Which is also known as nothing.</p>
	 * @param lable - the label to reset to ""
	 */
	private void resetLabel(JLabel lable){
		lable.setText("");
	}
	/**
	 * <p><i>Functional Method</i>, <code>calcHypotenuse</code> method calculates the hypotenuse value of a
	 * right triangle according to the value of the parameters.</p>
	 * @param a - the length of side a
	 * @param b - the length of side b
	 * @return The value of the hypotenuse in double value
	 */
	private double calcHypotenuse(int a, int b) {
		return (double)Math.round(Math.sqrt(a*a+b*b));
	}
	/**
	 * <p><i>Procedural Method</i>, changes the text of a lable to a predetermined string.</p> 
	 * @param a - the name of the label
	 * @param str - the string used for text exchange
	 */
	private void changeLblText(JLabel a, String str) {
		a.setText(str);
	}
	/**
	 * <p><i>Procedural Method</i>, constructs the outputs for right triangle by implementing multiple functional and procedural methods from this project.</p>
	 * <p>List of external methods that are being implemented:</p>
	 * <ol>
	 * <li>{@link DrawTriangle#drawRightTriangle(int, int)} - paints a right triangle on the canvas with parameters provided
	 * <li>{@link TriangleCalculator#calcHypotenuse(int, int)} - calculates the hypotenuse of the right triangle
	 * <li>{@link TriangleCalculator#calcRightArea(int, int)} - calculates the area of the right triangle
	 * <li>{@link IntegerChecking#isIntergerFast(String)} - checks string usability without parsing and exceptions</ol>
	 * <p>List of local variables used in this method:</p>
	 * <ol>
	 * <li>height - temporary storage for the side a value from user input
	 * <li>width - temporary storage for the side b value from user input
	 * </ol>
	 * <p>The local variables are used to increase the intuitiveness of the code since they represents <code>Integer.parseInt(side*Input.getText())</code></p>
	 */
	private void printRightArea(){
		int height = 0, width = 0;
		if(ic.isIntegerSafe(sideAInput.getText()) && ic.isIntegerSafe(sideBInput.getText())){
			height = Integer.parseInt(sideAInput.getText());
			width = Integer.parseInt(sideBInput.getText());
			hypotenuseInput.setText(String.valueOf(calcHypotenuse(height, width)));
			if(height <= 200 && height > 0 && width <= 200 && width >0){
				dt.drawRightTriangle(height, width);
				printRightArea.setText(String.valueOf(calcRightArea(height,width)));
			}else lblWarning.setText("Integers from 1-200 only");
		}else lblWarning.setText("Please Input Integers ONLY");
	}
	private void paintCoTriangle(){
		int X1,X2,X3,Y1,Y2,Y3;
		if(ic.isIntegerSafe(x1.getText()) && ic.isIntegerSafe(x2.getText()) && ic.isIntegerSafe(x3.getText()) && ic.isIntegerSafe(y1.getText())
				&& ic.isIntegerSafe(y2.getText()) && ic.isIntegerSafe(y3.getText())){
			X1 = Integer.parseInt(x1.getText());
			X2 = Integer.parseInt(x2.getText());
			X3 = Integer.parseInt(x3.getText());
			Y1 = Integer.parseInt(y1.getText());
			Y2 = Integer.parseInt(y2.getText());
			Y3 = Integer.parseInt(y3.getText());
			areaOutput.setText(String.valueOf(calcAreaWithCoordinates(X1, Y1, X2, Y2, X3, Y3)));
			if(X1 <= 200 && X2 <= 200 && X3 <= 200 && Y1 <= 200 && Y2 <= 200 && Y3 <= 200 && X1 >= -200 && X2 >= -200 && X3 >= -200 && Y1 >= -200 && Y2 >= -200 && Y3 >= -200)
				cs.paintTriangle(X1, Y1, X2, Y2, X3, Y3);
			else lblWarningCoordinate.setText("*Please Input values between -200 and 200");
		}else lblWarningCoordinate.setText("*Please Input Integers ONLY");
	}
	/**
	 * <p><i>Procedural Method</i>, constructs the outputs for ANY triangle by implementing multiple functional and procedural methods from this project.</p>
	 * <p>List of external methods that are being implemented:</p>
	 * <ol>
	 * <li>{@link DrawTriangle#drawTriangle(int, int)} - paints a triangle on the canvas with the parameters.
	 * <li>{@link TriangleCalculator#checkTri(int, int, int)} - examines the existence of the triangle.
	 * <li>{@link TriangleCalculator#calcTriArea(int, int, int)} - calculates the area of the triangle.
	 * <li>{@link IntegerChecking#isIntergerSafe(String)} - checks string usability without parsing and exceptions.
	 * </ol>
	 * <p>List of local variables used in this method:</p>
	 * <ol>
	 * <li>a - temporary storage for the side a value from user input
	 * <li>b - temporary storage for the side b value from user input
	 * <li>c - temporary storage for the side c value from user input
	 * </ol>
	 * <p>The local variables are used to increase the intuitiveness of the code since they represents <code>Integer.parseInt(side*Input.getText())</code></p>
	 */
	private void printRegularArea(){
		int a = 0, b = 0, c = 0;
		if(ic.isIntegerSafe(sideAInput.getText()) && ic.isIntegerSafe(sideBInput.getText()) && ic.isIntegerSafe(hypotenuseInput.getText())){
			a = Integer.parseInt(sideAInput.getText());
			b = Integer.parseInt(sideBInput.getText());
			c = Integer.parseInt(hypotenuseInput.getText());
			if(a <= 200 && a > 0 && b <= 200 && b > 0 && c <= 200 && c > 0){
				if(checkTri(a,b,c)){
					dt.drawTriangle((int) calcTriArea(a,c,b), a, b, c);
					printRightArea.setText(String.valueOf(calcTriArea(a,b,c)));
				}
				else lblWarning.setText("One Leg cannot be longer than the sum of the other two");
			}else lblWarning.setText("Integers from 1-200 only");
		}else lblWarning.setText("Please Input Integers ONLY");
	}
	/**
	 * <p><i>Procedural Method</i>, <code>selectOutputProcess</code> method decides the output information by comparing the mode user is active on.</p>
	 */
	private void selectOutputProcess(){
		if(rightMode)
			printRightArea();
		else 
			printRegularArea();
	}
	/**
	 * <p><i>Functional Method</i>, <code>calcAreaWithCoordinates</code> method calculates the area value of any
	 * triangle according to the value of the three coordinates.</p>
	 * @param x1 - the x coordinate value of point A
	 * @param y1 - the x coordinate value of point A
	 * @param x2 - the x coordinate value of point B
	 * @param y2 - the x coordinate value of point B
	 * @param x3 - the x coordinate value of point C
	 * @param y3 - the x coordinate value of point C
	 * @return The area value of the triangle
	 */
	private double calcAreaWithCoordinates(int x1, int y1, int x2, int y2, int x3, int y3){
		return Math.round(Math.abs((x1*(y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2))/2));
	}
	/**
	 * <p><i>Functional Method</i>, the <code>checkTri</code> method examines the existence of a triangle by
	 * compring the length of the three sides, if one of them is longer/equal to the sum of the other two
	 * lengths, the function will automatically return false, otherwise, it will return true.</p>
	 * @param a - the length value of side a
	 * @param b - the length value of side b
	 * @param c - the length value of side c
	 * @return The truth of the triangle
	 */
	private boolean checkTri(int a, int b, int c) {
		if(a + b <= c) return false;
		if(b + c <= a) return false;
		if(a + c <= b) return false;
		return true;
	}

}
