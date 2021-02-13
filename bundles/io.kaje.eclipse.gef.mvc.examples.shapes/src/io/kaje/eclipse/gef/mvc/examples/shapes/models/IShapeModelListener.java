package io.kaje.eclipse.gef.mvc.examples.shapes.models;

public interface IShapeModelListener {

	void handleShapeMoved(ShapeModel shape, int oldX, int oldY, int newX, int newY);

	void handleShapeResized(ShapeModel shape, int oldW, int oldH, int newWidth, int newHeight);

	void handleTargetConnectionAdded(ShapeModel shape, ConnectionModel conn);

	void handleSourceConnectionAdded(ShapeModel shape, ConnectionModel conn);

	void handleSourceConnectionRemoved(ShapeModel shape, ConnectionModel conn);

	void handleTargetConnectionRemoved(ShapeModel shape, ConnectionModel conn);

}
