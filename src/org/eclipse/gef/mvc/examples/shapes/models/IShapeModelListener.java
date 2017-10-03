package org.eclipse.gef.mvc.examples.shapes.models;

public interface IShapeModelListener {

	void handleShapeMoved(AbstractNodeModel shape, int oldX, int oldY, int newX, int newY);

	void handleShapeResized(AbstractNodeModel shape, double oldW, double oldH, double newWidth, double newHeight);

	void handleTargetConnectionAdded(AbstractNodeModel shape, ConnectionModel conn);

	void handleSourceConnectionAdded(AbstractNodeModel shape, ConnectionModel conn);

	void handleSourceConnectionRemoved(AbstractNodeModel shape, ConnectionModel conn);

	void handleTargetConnectionRemoved(AbstractNodeModel shape, ConnectionModel conn);

}
