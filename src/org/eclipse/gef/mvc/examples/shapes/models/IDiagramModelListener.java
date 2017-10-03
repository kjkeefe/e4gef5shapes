package org.eclipse.gef.mvc.examples.shapes.models;

public interface IDiagramModelListener {

	void handleShapeAdded(DiagramModel diagram, AbstractNodeModel s);

	void handleShapeRemoved(DiagramModel diagram, AbstractNodeModel s);

	void handleConnectionAdded(DiagramModel diagram, ConnectionModel c);

	void handleConnectionRemoved(DiagramModel diagram, ConnectionModel c);

}
