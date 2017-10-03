package org.eclipse.gef.mvc.examples.shapes.models;

public interface IConnectionModelListener {

	void handleSourceChanged(ConnectionModel connection, AbstractNodeModel oldSource, AbstractNodeModel s);

	void handleTargetChanged(ConnectionModel connection, AbstractNodeModel oldTarget, AbstractNodeModel t);

}
