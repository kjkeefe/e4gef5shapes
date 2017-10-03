package org.eclipse.gef.mvc.examples.shapes.view;

import javax.annotation.PostConstruct;

import org.eclipse.gef.common.adapt.AdapterKey;
import org.eclipse.gef.fx.swt.canvas.IFXCanvasFactory;
import org.eclipse.gef.mvc.examples.shapes.ShapesPlugin;
import org.eclipse.gef.mvc.examples.shapes.models.ConnectionModel;
import org.eclipse.gef.mvc.examples.shapes.models.DiagramModel;
import org.eclipse.gef.mvc.examples.shapes.models.EllipseModel;
import org.eclipse.gef.mvc.examples.shapes.models.RectangleModel;
import org.eclipse.gef.mvc.fx.domain.IDomain;
import org.eclipse.gef.mvc.fx.viewer.IViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.google.inject.Inject;

import javafx.collections.ObservableList;
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
		
		DiagramModel dm = getDiagramModel();
		
		ObservableList<Object> contents = contentViewer.getContents();
		contents.addAll(dm.getShapes());
		contents.addAll(dm.getConnections());
	}
	
	private DiagramModel getDiagramModel() {
		DiagramModel dm = new DiagramModel();
		
		populateExampleDiagram(dm);
		
		return dm;
	}

	private void populateExampleDiagram(DiagramModel dm) {
		RectangleModel rm = new RectangleModel();
		rm.setLocation(20, 30);
		rm.setSize(100, 40);
		
		RectangleModel rm2 = new RectangleModel();
		rm2.setLocation(220,  30);
		rm2.setSize(100, 40);
		
		EllipseModel e = new EllipseModel();
		e.setLocation(130, 130);
		e.setSize(80, 40);
		
		RectangleModel rm3 = new RectangleModel();
		rm3.setLocation(120, 230);
		rm3.setSize(100, 40);
		
		ConnectionModel cm1 = new ConnectionModel();
		cm1.setSource(rm);
		cm1.setTarget(e);
		
		ConnectionModel cm2 = new ConnectionModel();
		cm2.setSource(rm2);
		cm2.setTarget(e);
		
		ConnectionModel cm3 = new ConnectionModel();
		cm3.setSource(e);
		cm3.setTarget(rm3);
		
		dm.addShape(rm);
		dm.addShape(rm2);
		dm.addShape(e);
		dm.addShape(rm3);
		
		dm.addConnection(cm1);
		dm.addConnection(cm2);
		dm.addConnection(cm3);
	}

}

