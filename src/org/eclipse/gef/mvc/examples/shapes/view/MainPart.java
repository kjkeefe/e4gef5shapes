
package org.eclipse.gef.mvc.examples.shapes.view;

import javax.annotation.PostConstruct;
import com.google.inject.Inject;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.gef.fx.swt.canvas.IFXCanvasFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import javafx.embed.swt.FXCanvas;

public class MainPart {

	@Inject 
	private IFXCanvasFactory canvasFactory;
	private FXCanvas canvas;
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		canvas = createCanvas(parent);
	}

	private FXCanvas createCanvas(final Composite parent) {
		return canvasFactory.createCanvas(parent, SWT.NONE);
	}
	
	@Focus
	public void onFocus() {
		
	}

}