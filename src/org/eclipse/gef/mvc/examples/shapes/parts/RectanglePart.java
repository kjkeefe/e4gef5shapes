package org.eclipse.gef.mvc.examples.shapes.parts;

import org.eclipse.gef.fx.nodes.GeometryNode;
import org.eclipse.gef.geometry.planar.Dimension;
import org.eclipse.gef.geometry.planar.IShape;
import org.eclipse.gef.geometry.planar.Rectangle;
import org.eclipse.gef.mvc.examples.shapes.models.RectangleModel;

public class RectanglePart extends AbstractNodePart {

	@Override
	protected IShape createGeometry() {
		return new Rectangle();
	}
	
	@Override
	public RectangleModel getContent() {
		return (RectangleModel) super.getContent();
	}
	
	@Override
	protected void doRefreshVisual(GeometryNode<IShape> visual) {
		RectangleModel r = getContent();
		((Rectangle)geometry).setBounds(r.getX(), r.getY(), r.getWidth(), r.getHeight());

		super.doRefreshVisual(visual);
	}
	
	@Override
	public Dimension getContentSize() {
		RectangleModel rm = getContent();
		return new Dimension(rm.getWidth(), rm.getHeight());
	}

	@Override
	public void setContentSize(Dimension totalSize) {
		RectangleModel rm = getContent();
		rm.setSize(totalSize.getWidth(), totalSize.getHeight());
	}
}
