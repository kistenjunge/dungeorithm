package kistenjunge.org.dungeorithm.painters.impl;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SwingDungeonMouseListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Component component = e.getComponent();
		if (component != null) {
			if (component instanceof SwingDungeonTileTypeLabel) {
				SwingDungeonTileTypeLabel tileTypeLabel = (SwingDungeonTileTypeLabel) component;
				String tileTypeName = tileTypeLabel.getTileType().toString();
				Integer tileYCoordinate = tileTypeLabel.getTileCoordinate()
						.getY();
				Integer tileXCoordinate = tileTypeLabel.getTileCoordinate()
						.getX();
				SwingDungeonPainter.getSwingDungeonMenuPanel().setText(
						tileTypeName + " (" + tileXCoordinate + ":"
								+ tileYCoordinate + ")");
			} else if (component instanceof SwingDungeonReloadButton) {
				System.out
						.println("SwingDungeonMouseListener : SwingDungeonReloadButton pressed: TODO");
			}
		} else {
			SwingDungeonPainter.getSwingDungeonMenuPanel().setText(
					"CurrentTime :" + System.currentTimeMillis());
		}
	}

}
