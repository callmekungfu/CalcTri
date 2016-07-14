package triangleAssignment;
import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * <blockquote>I mean, this class is pretty cool.</blockquote>
 * <p>As an extension of the {@link javax.swing.JPanel}, the <code>{@link DrawTriangle}</code> class manages 
 * graphical rendering definitions for the Triangle assignment's normal mode. The class incorporates
 * series of procedural methods that allows applications to render triangle graphics according to 
 * different input conditions. This class can be instantiated.</p>
 * <p>When a new instance of this object is created, it is required to define the coordinate value of
 * the origin point with the parameters - <code>oX</code>, <code>oY</code>. These are the root values
 * which all other coordinate values are based on.</p>
 * <p><code>drawTriangle</code> does not accepts any inputs from application users, it only renders 
 * graphics based on the parameter provided by other classes.</p>
 * <p>The Following are Some features of this object:</p>
 * @author Yonglin Wang
 * @see javax.swing.JPanel
 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
 */
public class DrawTriangle extends JPanel{
	private static final long serialVersionUID = 12356L;
	/**
	 * <p><code>ORIGINX</code> defines the first value in the x coordinates
	 * array. The following two values in the array is altered according to
	 * this variable. <code>ORIGINX</code>is fixed does not contribute to 
	 * user input generated triangles
	 * </p>
	 */
	private int originX = 200;
	/**
	 * <p><code>ORIGINY</code> defines the first value in the y coordinates
	 * array. The following two values in the array is altered according to
	 * this variable. <code>ORIGINY</code>is fixed does not contribute to 
	 * user input generated triangles
	 * </p>
	 */
	private int originY = 250;
	/**
	 * <p><code>LEFT_STRING_X_POSITION</code> defines the value of triangle
	 * left label's x coordinate. The value of <code>LEFT_STRING_X_POSITION</code>
	 * alters according to the value <code>ORIGINX</code>, the value of the 
	 * variable is fixed and contributes to user input generated triangles.
	 * </p>
	 * <p>The value of the label's y coordinate is dynamic and alters according to
	 * the length of the triangle sides.</p>
	 */
	private final int LEFT_STRING_X_POSITION = originX - 15;
	/**
	 * <p><code>BOTTOM_STRING_Y_POSITION</code> defines the value of triangle
	 * right label's y coordinate. The value of <code>BOTTOM_STRING_Y_POSITION</code>
	 * alters according to the value <code>ORIGINY</code>, the value of the 
	 * variable is fixed and contributes to user input generated triangles.
	 * </p>
	 * <p>The value of the label's x coordinate is dynamic and alters according to
	 * the length of the triangle sides.</p>
	 */
	private final int BOTTOM_STRING_Y_POSITION = originY + 15;
	/**
	 * <p><code>xPositions</code> defines the x coordinates for drawing triangles.</p>
	 */
	public int[] xPositions = new int[]{originX, originX, originX + 100};
	public int[] yPositions = new int[]{originY, originY - 50, originY};
	private int leftStringX = 190;
	private int leftStringY = originY - 20;
	private int bottomStringX = 240;
	private int rightStringX, rightStringY;
	private boolean regularTriangleLables = false;
	private boolean rightTriangleLables = true;
	public Color triangleColor = new Color(76,175,80);
	
	public DrawTriangle(int oX, int oY){
		originX = oX;
		originY = oY;
	}
	
	/**
	 * <code>public void drawDefaultRightTriangle()</code>
	 * <p><i>Procedural Method</i>, Set graphics rendering definition to default right
	 * triangle values. Repaints the graphics by calling the <code>paintComponent()</code>
	 * method after the alteration.</p>
	 */
	public void drawDefaultRightTriangle(){
		xPositions = new int[]{originX, originX, originX + 100};
		yPositions = new int[]{originY, originY - 50, originY};
		leftStringX = 190;
		leftStringY = originY - 20;
		bottomStringX = 240;
		rightTriangleLables = true;
		regularTriangleLables = false;
		repaint();
	}
	/**
	 * <code>public void drawDefaultTriangle()</code>
	 * <p><i>Procedural Method</i>, Set graphics rendering definition to default regular
	 * triangle values. repaint the graphics.</p>
	 */
	public void drawDefaultTriangle(){
		xPositions = new int[]{originX, originX + 50, originX + 100};
		yPositions = new int[]{originY, originY-87, originY};
		leftStringX = 205;
		leftStringY = originY - 50;
		bottomStringX = originX + 50;
		rightStringX = 290;
		rightStringY = leftStringY; //#DONTJUDGE
		rightTriangleLables = false;
		regularTriangleLables = true;
		repaint();
	}
	
	/**
	 * <code>public void changeTriangleColor(Color c)</code>
	 * <p><i>Procedural Method</i>, sets the color the triangle graphics is rendered in.</p>
	 * @param color - the color rendering definition of the triangle.
	 */
	public void changeTriangleColor(Color c){
		triangleColor = c;
		repaint();
	}
	
	/**
	 * <code>public void drawTriangle(int aLength, int bLength)</code>
	 * <p><i>Procedural Method</i>, alters the triangle graphics rendering definitions
	 * according to user inputs to paint a triangle graphic with a right angle.</p>
	 * <p>Using the value of <code>aLength</code>, <code>bLength</code>, <code>ORIGINX</code>and <code>ORIGINY</code>, 
	 * the method is able to calculate the x and y coordinates of the points which forms a right triangle.</p>
	 * @param aLength - The value of side A's length
	 * @param bLength - The value of side B's length
	 */
	public void drawRightTriangle(int aLength, int bLength){
		yPositions[1] = originY - aLength;
		xPositions[2] = originX + bLength;
		leftStringY = originY - (aLength/2 - 5);
		bottomStringX = originX + (bLength/2 - 5);
		rightTriangleLables = true;
		regularTriangleLables = false;
		repaint();
	}
	
	/**
	 * <code>public void drawTriangle(int area, int aLength
	 * 						int bLength, int cLength)</code>
	 * <p><i>Procedural Method</i>, alters the triangle graphics rendering definitions
	 * according to user input.</p>
	 * <p>This method calculates the x and y coordinates of the triangle graphic
	 * using a combination of formulas.</p>
	 * <p>Through triangle Formulas, using <code>area</code>, <code>aLength</code>, <code>bLength</code>, <code>cLength</code>
	 * . It is able to calculate the height of the triangle, which placidly contributes
	 * to calculating the y coordinate of the top point by subtracting the y coordinate of the origin.</p>
	 * <p>The <code>paintComponent()</code> method is called at the end of the method to render the triangle graphics.</p>
	 * @param area - the area of the triangle
	 * @param aLength - the length of side a
	 * @param bLength - the length of side b
	 * @param cLength - the length of side c
	 */
	public void drawTriangle(int area, int aLength, int cLength, int bLength){
		int height,pointCXPos;
		height = (int)((2 * area)/cLength + 0.5);//height of the triangle
		pointCXPos = (int) (Math.sqrt(aLength * aLength - height * height) + 0.5);
		bottomStringX = originX + (cLength/2 - 5);
		leftStringY = originY - (height/2 - 5);
		rightStringX = originX + cLength - 10;
		rightStringY = leftStringY; //#DONTJUDGE
		yPositions[1] = originY - height;
		xPositions[1] = originX + pointCXPos;
		xPositions[2] = originX + cLength;
		rightTriangleLables = false;
		regularTriangleLables = true;
		repaint();
	}
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		RenderingHints rh = new RenderingHints(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHints(rh);
		g2.setColor(triangleColor);
		g2.fillPolygon(xPositions, yPositions, 3);
		g2.setColor(Color.white);
		if(rightTriangleLables){
			g2.drawString("a", LEFT_STRING_X_POSITION, leftStringY);
			g2.drawString("b", bottomStringX, BOTTOM_STRING_Y_POSITION);
			g2.drawString("Hypotenuse", bottomStringX, leftStringY - 15);
		}else if(regularTriangleLables){
			g2.drawString("a", leftStringX, leftStringY);
			g2.drawString("b", bottomStringX, BOTTOM_STRING_Y_POSITION);
			g2.drawString("c", rightStringX, rightStringY);
		}
	}
}
