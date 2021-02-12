package org.eclipse.gef.mvc.examples.shapes.view;

import javax.annotation.PostConstruct;

import org.eclipse.gef.common.adapt.AdapterKey;
import org.eclipse.gef.fx.swt.canvas.IFXCanvasFactory;
import org.eclipse.gef.mvc.examples.shapes.ShapesPlugin;
import org.eclipse.gef.mvc.fx.domain.IDomain;
import org.eclipse.gef.mvc.fx.viewer.IViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.google.inject.Inject;

import javafx.embed.swt.FXCanvas;
import javafx.scene.Scene;

public class MainPart {
	
	@Inject
	private IDomain domain;
	
	@Inject 
	private IFXCanvasFactory canvasFactory;
	private FXCanvas canvas;
	
	public MainPart() {
		ShapesPlugin.GetInjector().injectMembers(this);
	}
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		canvas = canvasFactory.createCanvas(parent, SWT.NONE);
		
		IViewer contentViewer = domain.getAdapter(AdapterKey.get(IViewer.class, IDomain.CONTENT_VIEWER_ROLE));
		
		canvas.setScene(new Scene(contentViewer.getCanvas()));
		
		domain.activate();
	}

}

