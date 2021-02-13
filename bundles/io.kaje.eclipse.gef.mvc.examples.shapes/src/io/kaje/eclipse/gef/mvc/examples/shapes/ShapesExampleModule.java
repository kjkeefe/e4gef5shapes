package io.kaje.eclipse.gef.mvc.examples.shapes;

import org.eclipse.gef.mvc.fx.MvcFxModule;
import org.eclipse.gef.mvc.fx.parts.IContentPartFactory;

import io.kaje.eclipse.gef.mvc.examples.shapes.parts.ShapesExampleContentPartFactory;

public class ShapesExampleModule extends MvcFxModule {
	
	@Override
	protected void configure() {
		super.configure();
		
		bindIContentPartFactory();
	}
	
	protected void bindIContentPartFactory() {
		binder().bind(IContentPartFactory.class).to(ShapesExampleContentPartFactory.class);
	}

}
