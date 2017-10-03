package org.eclipse.gef.mvc.examples.shapes;

import org.eclipse.gef.common.adapt.AdapterKey;
import org.eclipse.gef.common.adapt.inject.AdapterMaps;
import org.eclipse.gef.fx.swt.canvas.FXCanvasEx;
import org.eclipse.gef.fx.swt.canvas.IFXCanvasFactory;
import org.eclipse.gef.mvc.examples.shapes.parts.AbstractNodePart;
import org.eclipse.gef.mvc.examples.shapes.parts.ConnectionPart;
import org.eclipse.gef.mvc.examples.shapes.parts.ShapesExampleContentPartFactory;
import org.eclipse.gef.mvc.fx.MvcFxModule;
import org.eclipse.gef.mvc.fx.domain.IDomain;
import org.eclipse.gef.mvc.fx.parts.IContentPartFactory;
import org.eclipse.gef.mvc.fx.providers.DefaultAnchorProvider;
import org.eclipse.gef.mvc.fx.viewer.IViewer;
import org.eclipse.swt.widgets.Composite;

import com.google.inject.multibindings.MapBinder;

import javafx.embed.swt.FXCanvas;

public class ShapesExampleModule extends MvcFxModule {
	
	@Override
	protected void configure() {
		super.configure();
		bindFXCanvasFactory();
		bindIContentPartFactory();
		bindGeometricShapePartAdaptersInContentViewerContext(AdapterMaps.getAdapterMapBinder(binder(), AbstractNodePart.class, AdapterKey.get(IViewer.class, IDomain.CONTENT_VIEWER_ROLE)));
		bindGeometricShapePartAdaptersInContentViewerContext(AdapterMaps.getAdapterMapBinder(binder(), ConnectionPart.class, AdapterKey.get(IViewer.class, IDomain.CONTENT_VIEWER_ROLE)));
	}
	
	protected void bindIContentPartFactory() {
		binder().bind(IContentPartFactory.class).to(ShapesExampleContentPartFactory.class);
	}
	
	protected void bindFXCanvasFactory() {
		binder().bind(IFXCanvasFactory.class)
				.toInstance(new IFXCanvasFactory() {
					@Override
					public FXCanvas createCanvas(Composite parent, int style) {
						return new FXCanvasEx(parent, style);
					}
				});
	}

	protected void bindGeometricShapePartAdaptersInContentViewerContext(MapBinder<AdapterKey<?>, Object> adapterMapBinder) {

		// bind dynamic anchor provider
		adapterMapBinder.addBinding(AdapterKey.defaultRole()).to(DefaultAnchorProvider.class);
		
	}
	
}
