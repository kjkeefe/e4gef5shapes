package org.eclipse.gef.mvc.examples.shapes.models;

public interface IDiagramListener {

	void handleShapeAdded(Diagram diagram, Shape s);

	void handleShapeRemoved(Diagram diagram, Shape s);

	void handleConnectionAdded(Diagram diagram, Connection c);

	void handleConnectionRemoved(Diagram diagram, Connection c);

}
