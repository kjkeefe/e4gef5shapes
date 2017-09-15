package org.eclipse.gef.mvc.examples.shapes.models;

public interface IConnectionListener {

	void handleSourceChanged(Connection connection, Shape oldSource, Shape s);

	void handleTargetChanged(Connection connection, Shape oldTarget, Shape t);

}
