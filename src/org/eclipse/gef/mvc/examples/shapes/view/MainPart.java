package org.eclipse.gef.mvc.examples.shapes.view;

import javax.annotation.PostConstruct;

import org.eclipse.gef.fx.swt.canvas.IFXCanvasFactory;
import org.eclipse.gef.mvc.fx.domain.IDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.google.inject.Inject;

import javafx.embed.swt.FXCanvas;

public class MainPart {
	
	@Inject
	private IDomain domain;
	
	@Inject 
	private IFXCanvasFactory canvasFactory;
	private FXCanvas canvas;
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		canvas = createCanvas(parent);
		
		activate();
	}
	
	private FXCanvas createCanvas(final Composite parent) {
		return canvasFactory.createCanvas(parent, SWT.NONE);
	}
	
	protected void activate() {
		domain.activate();
	}

}

