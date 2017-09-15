package org.eclipse.gef.mvc.examples.shapes.models;

public interface IShapeListener {

	void handleShapeMoved(Shape shape, int oldX, int oldY, int newX, int newY);

	void handleShapeResized(Shape shape, int oldW, int oldH, int newWidth, int newHeight);

	void handleTargetConnectionAdded(Shape shape, Connection conn);

	void handleSourceConnectionAdded(Shape shape, Connection conn);

	void handleSourceConnectionRemoved(Shape shape, Connection conn);

	void handleTargetConnectionRemoved(Shape shape, Connection conn);

}
