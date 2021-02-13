package io.kaje.eclipse.gef.mvc.examples.shapes.models;

import java.util.ArrayList;

public class ShapeModel implements IConnectionModelListener {

	private int x = 0;
	private int y = 0;
	private int w = 50;
	private int h = 50;

	private ArrayList<ConnectionModel> sourceConnections = new ArrayList<ConnectionModel>();
	private ArrayList<ConnectionModel> targetConnections = new ArrayList<ConnectionModel>();
	private ArrayList<IShapeModelListener> listeners = new ArrayList<IShapeModelListener>();

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

	public void addConnection(ConnectionModel conn) {
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

	public void removeSourceConnection(ConnectionModel conn) {
		if (conn != null && sourceConnections.remove(conn)) {
			if(!targetConnections.contains(conn))
				conn.removeListener(this);
			notifySourceConnectionRemoved(conn);
		}
	}

	public void removeTargetConnection(ConnectionModel conn) {
		if (conn != null && targetConnections.remove(conn)) {
			if(!sourceConnections.contains(conn))
				conn.removeListener(this);
			notifyTargetConnectionRemoved(conn);
		}
	}
	
	public ConnectionModel[] getSourceConnections() {
		return sourceConnections.toArray(new ConnectionModel[sourceConnections.size()]);
	}

	public ConnectionModel[] getTargetConnections() {
		return targetConnections.toArray(new ConnectionModel[targetConnections.size()]);
	}

	public void addListener(IShapeModelListener l) {
		if (!listeners.contains(l))
			listeners.add(l);
	}

	public boolean removeListener(IShapeModelListener l) {
		return listeners.remove(l);
	}

	private void notifyShapeMoved(int oldX, int oldY, int newX, int newY) {
		for (IShapeModelListener l : listeners) {
			l.handleShapeMoved(this, oldX, oldY, newX, newY);
		}
	}

	private void notifyShapeResized(int oldW, int oldH, int newWidth, int newHeight) {
		for (IShapeModelListener l : listeners) {
			l.handleShapeResized(this, oldW, oldH, newWidth, newHeight);
		}
	}

	private void notifyTargetConnectionAdded(ConnectionModel conn) {
		for (IShapeModelListener l : listeners) {
			l.handleTargetConnectionAdded(this, conn);
		}
	}

	private void notifySourceConnectionAdded(ConnectionModel conn) {
		for (IShapeModelListener l : listeners) {
			l.handleSourceConnectionAdded(this, conn);
		}
	}

	private void notifySourceConnectionRemoved(ConnectionModel conn) {
		for (IShapeModelListener l : listeners) {
			l.handleSourceConnectionRemoved(this, conn);
		}
	}

	private void notifyTargetConnectionRemoved(ConnectionModel conn) {
		for (IShapeModelListener l : listeners) {
			l.handleTargetConnectionRemoved(this, conn);
		}
	}

	@Override
	public void handleSourceChanged(ConnectionModel connection, ShapeModel oldSource, ShapeModel s) {
		if(oldSource == this)
			removeSourceConnection(connection);
	}

	@Override
	public void handleTargetChanged(ConnectionModel connection, ShapeModel oldTarget, ShapeModel t) {
		if(oldTarget == this)
			removeTargetConnection(connection);
	}
}
