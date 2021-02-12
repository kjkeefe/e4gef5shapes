package org.eclipse.gef.mvc.examples.shapes.models;

public interface IDiagramModelListener {

	void handleShapeAdded(DiagramModel diagram, ShapeModel s);

	void handleShapeRemoved(DiagramModel diagram, ShapeModel s);

	void handleConnectionAdded(DiagramModel diagram, ConnectionModel c);

	void handleConnectionRemoved(DiagramModel diagram, ConnectionModel c);

}
