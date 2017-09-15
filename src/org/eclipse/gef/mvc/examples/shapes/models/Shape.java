package org.eclipse.gef.mvc.examples.shapes.models;

import java.util.ArrayList;

public class Shape implements IConnectionListener {

	private int x = 0;
	private int y = 0;
	private int w = 50;
	private int h = 50;

	private ArrayList<Connection> sourceConnections = new ArrayList<Connection>();
	private ArrayList<Connection> targetConnections = new ArrayList<Connection>();
	private ArrayList<IShapeListener> listeners = new ArrayList<IShapeListener>();

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setLocation(int newX, int newY) {
		if (newX != x || newY != y) {
			int oldX = x;
			int oldY = y;
			x = newX;
			y = newY;
			notifyShapeMoved(oldX, oldY, newX, newY);
		}
	}

	public int getHeight() {
		return h;
	}

	public int getWidth() {
		return w;
	}

	public void setSize(int newWidth, int newHeight) {
		if (newWidth != w || newHeight != h) {
			int oldW = w;
			int oldH = h;
			w = newWidth;
			h = newHeight;
			notifyShapeResized(oldW, oldH, newWidth, newHeight);
		}
	}

	public void addConnection(Connection conn) {
		if (conn != null) {
			if (conn.getSource() == this) {
				sourceConnections.add(conn);
				conn.addListener(this);
				notifySourceConnectionAdded(conn);
			}
			if (conn.getTarget() == this) {
				targetConnections.add(conn);
				conn.addListener(this);
				notifyTargetConnectionAdded(conn);
			}
		}
	}

	public void removeSourceConnection(Connection conn) {
		if (conn != null && sourceConnections.remove(conn)) {
			if(!targetConnections.contains(conn))
				conn.removeListener(this);
			notifySourceConnectionRemoved(conn);
		}
	}

	public void removeTargetConnection(Connection conn) {
		if (conn != null && targetConnections.remove(conn)) {
			if(!sourceConnections.contains(conn))
				conn.removeListener(this);
			notifyTargetConnectionRemoved(conn);
		}
	}
	
	public Connection[] getSourceConnections() {
		return sourceConnections.toArray(new Connection[sourceConnections.size()]);
	}

	public Connection[] getTargetConnections() {
		return targetConnections.toArray(new Connection[targetConnections.size()]);
	}

	public void addListener(IShapeListener l) {
		if (!listeners.contains(l))
			listeners.add(l);
	}

	public boolean removeListener(IShapeListener l) {
		return listeners.remove(l);
	}

	private void notifyShapeMoved(int oldX, int oldY, int newX, int newY) {
		for (IShapeListener l : listeners) {
			l.handleShapeMoved(this, oldX, oldY, newX, newY);
		}
	}

	private void notifyShapeResized(int oldW, int oldH, int newWidth, int newHeight) {
		for (IShapeListener l : listeners) {
			l.handleShapeResized(this, oldW, oldH, newWidth, newHeight);
		}
	}

	private void notifyTargetConnectionAdded(Connection conn) {
		for (IShapeListener l : listeners) {
			l.handleTargetConnectionAdded(this, conn);
		}
	}

	private void notifySourceConnectionAdded(Connection conn) {
		for (IShapeListener l : listeners) {
			l.handleSourceConnectionAdded(this, conn);
		}
	}

	private void notifySourceConnectionRemoved(Connection conn) {
		for (IShapeListener l : listeners) {
			l.handleSourceConnectionRemoved(this, conn);
		}
	}

	private void notifyTargetConnectionRemoved(Connection conn) {
		for (IShapeListener l : listeners) {
			l.handleTargetConnectionRemoved(this, conn);
		}
	}

	@Override
	public void handleSourceChanged(Connection connection, Shape oldSource, Shape s) {
		if(oldSource == this)
			removeSourceConnection(connection);
	}

	@Override
	public void handleTargetChanged(Connection connection, Shape oldTarget, Shape t) {
		if(oldTarget == this)
			removeTargetConnection(connection);
	}
}
