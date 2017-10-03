package org.eclipse.gef.mvc.examples.shapes.parts;

import java.util.Collections;
import java.util.List;

import org.eclipse.gef.fx.nodes.GeometryNode;
import org.eclipse.gef.geometry.planar.IShape;
import org.eclipse.gef.mvc.examples.shapes.models.AbstractNodeModel;
import org.eclipse.gef.mvc.examples.shapes.models.ConnectionModel;
import org.eclipse.gef.mvc.fx.parts.AbstractContentPart;
import org.eclipse.gef.mvc.fx.parts.IResizableContentPart;
import org.eclipse.gef.mvc.fx.parts.ITransformableContentPart;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.SetMultimap;

import javafx.scene.effect.Effect;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.transform.Affine;

public abstract class AbstractNodePart extends AbstractContentPart<GeometryNode<IShape>>
implements ITransformableContentPart<GeometryNode<IShape>>, IResizableContentPart<GeometryNode<IShape>> {

	protected Affine transform;
	protected IShape geometry;
	protected Paint stroke;
	protected double strokeWidth;
	protected Paint fill;
	protected Effect effect;
	
	public AbstractNodePart() {
		geometry = createGeometry();
		fill = Color.WHITE;
		stroke = Color.BLACK;
		strokeWidth = 1;
	}
	
	protected abstract IShape createGeometry();

	@Override
	public Affine getContentTransform() {
		return transform;
	}

	@Override
	public void setContentTransform(Affine totalTransform) {
		transform = totalTransform;
	}

	@Override
	protected List<? extends Object> doGetContentChildren() {
		return Collections.emptyList();
	}

	@Override
	protected GeometryNode<IShape> doCreateVisual() {
		GeometryNode<IShape> geometryNode = new GeometryNode<>();
		geometryNode.setGeometry(geometry);
		return geometryNode;
	}

	@Override
	protected void doRefreshVisual(GeometryNode<IShape> visual) {
		
		if(transform != null)
			setVisualTransform(transform);
		
		if(visual.getStroke() != stroke) {
			visual.setStroke(stroke);
		}
		
		if(visual.getStrokeWidth() != strokeWidth) {
			visual.setStrokeWidth(strokeWidth);
		}
		
		if(visual.getFill() != fill) {
			visual.setFill(fill);
		}
		
		if(visual.getEffect() != effect) {
			visual.setEffect(effect);
		}
		
		
	}
	
	@Override
	public AbstractNodeModel getContent() {
		return (AbstractNodeModel)super.getContent();
	}
	
	@Override
	protected void doAttachToContentAnchorage(Object contentAnchorage, String role) {
		getContent().addConnection((ConnectionModel)contentAnchorage);
	}
	
	@Override
	protected void doDetachFromContentAnchorage(Object contentAnchorage, String role) {
		getContent().removeConnection((ConnectionModel)contentAnchorage);
	}
	
	@Override
	protected SetMultimap<? extends Object, String> doGetContentAnchorages() {
		SetMultimap<Object, String> anchorages = HashMultimap.create();
		for(ConnectionModel cm : getContent().getSourceConnections()) {
			anchorages.put(cm, "link");
		}
		for(ConnectionModel cm : getContent().getTargetConnections()) {
			anchorages.put(cm, "link");
		}
		return anchorages;
	}
	
}
