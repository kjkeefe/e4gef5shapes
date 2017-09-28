package org.eclipse.gef.mvc.examples.shapes.parts;

import java.util.Map;

import org.eclipse.gef.mvc.examples.shapes.models.ConnectionModel;
import org.eclipse.gef.mvc.examples.shapes.models.EllipseModel;
import org.eclipse.gef.mvc.examples.shapes.models.RectangleModel;
import org.eclipse.gef.mvc.fx.parts.IContentPart;
import org.eclipse.gef.mvc.fx.parts.IContentPartFactory;

import com.google.inject.Inject;
import com.google.inject.Injector;

import javafx.scene.Node;

public class ShapesExampleContentPartFactory implements IContentPartFactory {
	
	@Inject
	private Injector injector;

	@Override
	public IContentPart<? extends Node> createContentPart(Object content, Map<Object, Object> contextMap) {
		if(content instanceof ConnectionModel) {
			return injector.getInstance(ConnectionPart.class);
		} else if (content instanceof EllipseModel) {
			return injector.getInstance(EllipsePart.class);
		} else if (content instanceof RectangleModel) {
			return injector.getInstance(RectanglePart.class);
		} else {
			throw new IllegalArgumentException(content.getClass().toString());
		}
	}

}
