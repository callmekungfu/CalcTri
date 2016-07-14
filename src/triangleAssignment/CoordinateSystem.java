package triangleAssignment;
import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class CoordinateSystem extends JPanel{
	/**
	 * Import my own Material Color class
	 */
	MaterialColors mColor = new MaterialColors();
	/**
	 * Array used to store all the x coordinate values
	 */
	ArrayList<Integer> xCoordinateStore = new ArrayList<Integer>();
	/**
	 * Array used to store all the y coordinate values
	 */
	ArrayList<Integer> yCoordinateStore = new ArrayList<Integer>();

	/**
	 * Defines the horizontal boundary of the canvas
	 */
	public int maxXValue = 480;
	/**
	 * Defines the vertical boundary of the canvas
	 */
	public int maxYValue = 300;

	/**
	 * Defines the origin X Coordinate Values and the value of half a canvas, you call this redundancy, I call this intuition
	 */
	private int halfXValue = maxXValue/2, originX = maxXValue/2;
	/**
	 * Defines the origin Y Coordinate Values and the value of half a canvas, you call this redundancy, I call this intuition
	 */
	private int halfYValue = maxYValue/2, originY = maxYValue/2;
	/**
	 * Used to store the x coordinates before they are being processed in rendering
	 */
	private int[] triXCoordinates = new int[]{halfXValue,280,300};
	/**
	 * Used to store the x coordinates before they are being processed in rendering
	 */
	private int[] triYCoordinates = new int[]{halfYValue,200,130};
	/**
	 * An array of colors used to define the rendering color of triangle
	 */
	private Object[] triangleColors = new Object[] {mColor.GREEN, mColor.PINK, mColor.PURPLE, mColor.DEEP_PURPLE, 
			mColor.INDIGO, mColor.BLUE, mColor.LIGHT_BLUE, mColor.CYAN, mColor.TEAL, mColor.LIGHT_GREEN, mColor.LIME, 
			mColor.YELLOW, mColor.AMBER, mColor.ORANGE, mColor.DEEP_ORANGE, mColor.BROWN};
	/**
	 * Determines if the canvas should be cleared
	 */
	private boolean clearCommand = false;
	/**
	 * Sets the rendering definition to default and renders a triangle
	 */
	public void paintDefaultTriangle(){
		triXCoordinates = new int[]{halfXValue,280,300};
		triYCoordinates = new int[]{halfYValue,200,130};
		repaint();
	}
	/**
	 * Sets canvas clearing command to true and renders the scene
	 */
	public void clearCanvas(){
		clearCommand = true;
		xCoordinateStore.clear();
		yCoordinateStore.clear();
		repaint();
	}
	/**
	 * Modifies the value of the global printing definition array, 
	 * stores it in an ArrayList and renders a new triangle on canvas.
	 * 
	 * @param x1 - coordinate value of x1
	 * @param y1 - coordinate value of y1
	 * @param x2 - coordinate value of x2
	 * @param y2 - coordinate value of y2
	 * @param x3 - coordinate value of x3
	 * @param y3 - coordinate value of y3
	 */
	public void paintTriangle(int x1, int y1, int x2, int y2, int x3, int y3){
		triXCoordinates[0] = originX + x1;
		triXCoordinates[1] = originX + x2;
		triXCoordinates[2] = originX + x3;
		triYCoordinates[0] = originY - y1;
		triYCoordinates[1] = originY - y2;
		triYCoordinates[2] = originY - y3;
		for(int i = 0; i < 3; i++){
			xCoordinateStore.add(triXCoordinates[i]);
			yCoordinateStore.add(triYCoordinates[i]);
		}
		repaint();
	}
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);//declare supreme of this method
		int count = 0;//a variable used to count how much triangles are drawn
		Graphics2D g2d = (Graphics2D)g;//declare the use of a g2d
		RenderingHints rh = new RenderingHints(//modifies the rendering hints for the graphic rendering
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHints(rh);//set rendering hints to declared
		g2d.setColor(Color.BLACK);//set color of the grid
		for(int i = 0; i <= maxXValue;i += 10){//draw the vertical grid lines
			g2d.drawLine(i, 0, i, maxYValue);

		}
		for(int i = 0; i <= maxYValue; i += 10){//draw the horizontal grid lines
			g2d.drawLine(0, i, maxXValue, i);
		}
		g2d.setColor(Color.WHITE);//set label color to white
		for(int i = 0; i <= maxXValue; i += 10){//draws the number labels on the horizontal x-axis
			if(i%20 == 0){
				if(i-halfXValue < -80 || i-halfXValue > 80) {
				}else if(i-halfXValue == 0)
					g2d.drawString(String.valueOf(i - halfXValue), i-3, 160);
				else if(i-halfXValue > 0)
					g2d.drawString(String.valueOf(i - halfXValue), i-6, 160);
				else
					g2d.drawString(String.valueOf(i - halfXValue), i-10, 160);
			}
		}
		for(int i = 0; i <= maxYValue; i+= 10){//draws the number labels on the vertical y-axis
			if((halfYValue - i) % 20 == 0){
				if(halfYValue - i < -80 || halfYValue - i > 100) {
				}else if(i-halfYValue == 0)
					g2d.drawString("", halfXValue + 10, 160);
				else if(i-halfYValue > 0)
					g2d.drawString(String.valueOf(halfYValue - i), halfXValue + 5, i+5);
				else
					g2d.drawString(String.valueOf(halfYValue - i), halfXValue + 5, i+5);
			}
		}
		g2d.setColor(mColor.GREEN);//set the color of the origin lines to green
		g2d.drawLine(maxXValue/2, 0, maxXValue/2, maxYValue);//draw horizontal origin line
		g2d.drawLine(0, maxYValue/2, maxXValue, maxYValue/2);//draw vertical origin line
		if(!clearCommand){//if the user didn't click clear
			for(int i = 0; i < xCoordinateStore.size(); i+=3){//render all the triangles the user inputed
				readValFromList(i,3,xCoordinateStore,triXCoordinates);
				readValFromList(i,3,yCoordinateStore,triYCoordinates);
				g2d.setColor((Color) triangleColors[count]);
				g2d.fillPolygon(triXCoordinates, triYCoordinates, 3);
				g2d.setColor(Color.white);
				g2d.drawString("A", triXCoordinates[0] - 10, triYCoordinates[0] + 5);
				g2d.drawString("B", triXCoordinates[1] + 5, triYCoordinates[1] + 5);
				g2d.drawString("C", triXCoordinates[2] + 5, triYCoordinates[2] - 5);
				if(count == triangleColors.length-1)
					count = 0;
				else
					count++;
			}
		}
		clearCommand = false;
	}
	/**
	 * Retrieves the coordinate values of a triangle from the array list
	 * @param start - the starting value of the ArrayList
	 * @param al - the list to retrieve from
	 * @param array - the values to
	 */
	/**
	 * Retrieves the coordinate values of a triangle from the array list
	 * @param start - the starting value of the ArrayList
	 * @param al - the list to retrieve from
	 * @param array - the values to
	 * @param numOfVal - number of values to retrieve
	 */
	private void readValFromList(int start,int numOfVal, ArrayList<Integer> al, int[] array){
		for(int i = start; i < start + numOfVal; i++){
			array[i-start] = al.get(i);
		}
	}

}
