package triangleAssignment;
import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;

/**
 * <p>This object defines a customized list rendering system for Yonglin Seal of Approval Triangle Calculator.
 * </p>
 * 
 * @author Yonglin Wang
 *
 */
class ComplexCellRenderer implements ListCellRenderer<Object> {

	public Color listColor = new Color(211,47,47);
	public Color hoverColor = new Color(183,28,28);
	Border border = BorderFactory.createLineBorder(new Color(244, 67, 54), 1);
	protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();

	public Component getListCellRendererComponent(JList<?> list, Object value, int index,
			boolean isSelected, boolean cellHasFocus) {
		Icon theIcon = null;
		String theText = null;
		JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index,
				isSelected, cellHasFocus);
		if (value instanceof Object[]) {
			Object values[] = (Object[]) value;
			theIcon = (Icon) values[0];
			theText = (String) values[1];
		} else {
			theText = "";
		}
		if (isSelected) {
			renderer.setBackground(hoverColor);
			renderer.setForeground(Color.white);
		} else {
			renderer.setForeground(Color.white);
			renderer.setBackground(listColor);
		}
		if(cellHasFocus){
			renderer.setBackground(hoverColor);
			renderer.setForeground(Color.white);
		}
		if (theIcon != null) {
			renderer.setIcon(theIcon);
		}
		renderer.setText(theText);
		return renderer;
	}
}