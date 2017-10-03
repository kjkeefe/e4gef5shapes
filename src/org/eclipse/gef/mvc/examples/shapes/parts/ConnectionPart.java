package org.eclipse.gef.mvc.examples.shapes.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.gef.fx.anchors.IAnchor;
import org.eclipse.gef.fx.nodes.Connection;
import org.eclipse.gef.fx.nodes.GeometryNode;
import org.eclipse.gef.fx.nodes.PolyBezierInterpolator;
import org.eclipse.gef.mvc.examples.shapes.models.AbstractNodeModel;
import org.eclipse.gef.mvc.examples.shapes.models.ConnectionModel;
import org.eclipse.gef.mvc.fx.parts.AbstractContentPart;
import org.eclipse.gef.mvc.fx.parts.IBendableContentPart;
import org.eclipse.gef.mvc.fx.parts.IVisualPart;
import org.eclipse.gef.mvc.fx.providers.IAnchorProvider;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.SetMultimap;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeLineCap;

public class ConnectionPart extends AbstractContentPart<Connection>
implements IBendableContentPart<Connection> {
	
	protected Paint stroke;
	protected double strokeWidth;
	
	public ConnectionPart() {
		stroke = Color.BLACK;
		strokeWidth = 1;
	}
	
	public static class ArrowHead extends Polygon {
		public ArrowHead() {
			super(0, 0, 10, 3, 10, -3);
			setFill(Color.BLACK);
		}
	}
	
	private final ArrowHead END_ARROW_HEAD = new ArrowHead();

	@Override
	public List<BendPoint> getContentBendPoints() {
		List<BendPoint> bendPoints = new ArrayList<>();

		return bendPoints;
	}

	

	@Override
	protected List<? extends Object> doGetContentChildren() {
		return Collections.emptyList();
	}

	@Override
	protected Connection doCreateVisual() {
		Connection visual = new Connection();
		visual.setInterpolator(new PolyBezierInterpolator());
		((GeometryNode<?>) visual.getCurve()).setStrokeLineCap(StrokeLineCap.BUTT);
		return visual;
	}
	
	@Override
	public ConnectionModel getContent() {
		return (ConnectionModel)super.getContent();
	}

	
	@Override
	protected void doAttachToAnchorageVisual(IVisualPart<? extends Node> anchorage, String role) {
		IAnchor anchor = anchorage.getAdapter(IAnchorProvider.class).get(this, role);
		if (role.equals(SOURCE_ROLE)) {
			getVisual().setStartAnchor(anchor);
		} else if(role.equals(TARGET_ROLE)) {
			getVisual().setEndAnchor(anchor);
		} else {
			throw new IllegalStateException("Cannot attach to anchor with role <" + role + ">.");
		}
	}
	
	@Override
	protected void doAttachToContentAnchorage(Object contentAnchorage, String role) {
		AbstractNodeModel anm = (AbstractNodeModel)contentAnchorage;
		if(SOURCE_ROLE.equals(role)) {
			getContent().setSource(anm);
		} else if(TARGET_ROLE.equals(role)) {
			getContent().setTarget(anm);
		}
	}
	
	@Override
	protected void doDetachFromAnchorageVisual(IVisualPart<? extends Node> anchorage, String role) {
		if(role.equals(SOURCE_ROLE)) {
			getVisual().setStartPoint(getVisual().getStartPoint());
		} else if(role.equals(TARGET_ROLE)) {
			getVisual().setStartPoint(getVisual().getStartPoint());
		}
	}
	
	@Override
	protected void doDetachFromContentAnchorage(Object contentAnchorage, String role) {
		if(SOURCE_ROLE.equals(role)) {
			getContent().setSource(null);
		} else if(TARGET_ROLE.equals(role)) {
			getContent().setTarget(null);
		}
	}
	
	@Override
	protected SetMultimap<? extends Object, String> doGetContentAnchorages() {
		SetMultimap<Object, String> anchorages = HashMultimap.create();
		anchorages.put(getContent().getSource(), SOURCE_ROLE);
		anchorages.put(getContent().getTarget(), TARGET_ROLE);
		return anchorages;
	}
	
	@Override
	protected void doRefreshVisual(Connection visual) {
		
		if (visual.getEndDecoration() == null || !(visual.getEndDecoration() instanceof ArrowHead)) {
			visual.setEndDecoration(END_ARROW_HEAD);
		}
		
		Shape endDecorationVisual = (Shape) visual.getEndDecoration();
		
		if(endDecorationVisual.getStroke() != stroke)
			endDecorationVisual.setStroke(stroke);
		
		//How can I get the edge of these shapes instead of the upper left point?
		visual.setStartPoint(getContent().getSource().getPoint());
		visual.setEndPoint(getContent().getTarget().getPoint());
	}



	@Override
	public void setContentBendPoints(List<BendPoint> bendPoints) {
		
	}
	
}
