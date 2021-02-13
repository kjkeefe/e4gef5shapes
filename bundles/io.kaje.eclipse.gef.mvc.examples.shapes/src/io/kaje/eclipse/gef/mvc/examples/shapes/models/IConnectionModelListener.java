package io.kaje.eclipse.gef.mvc.examples.shapes.models;

public interface IConnectionModelListener {

	void handleSourceChanged(ConnectionModel connection, ShapeModel oldSource, ShapeModel s);

	void handleTargetChanged(ConnectionModel connection, ShapeModel oldTarget, ShapeModel t);

}
