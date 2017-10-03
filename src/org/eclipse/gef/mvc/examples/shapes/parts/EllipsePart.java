package org.eclipse.gef.mvc.examples.shapes.parts;

import org.eclipse.gef.fx.nodes.GeometryNode;
import org.eclipse.gef.geometry.planar.Dimension;
import org.eclipse.gef.geometry.planar.Ellipse;
import org.eclipse.gef.geometry.planar.IShape;
import org.eclipse.gef.mvc.examples.shapes.models.EllipseModel;

public class EllipsePart extends AbstractNodePart {

	@Override
	protected IShape createGeometry() {
		return new Ellipse(0, 0, 0, 0);
	}
	
	@Override
	public EllipseModel getContent() {
		return (EllipseModel)super.getContent();
	}

	@Override
	protected void doRefreshVisual(GeometryNode<IShape> visual) {
		EllipseModel e = getContent();
		((Ellipse)geometry).setBounds(e.getX(), e.getY(), e.getWidth(), e.getHeight());
		
		super.doRefreshVisual(visual);
	}
	
	@Override
	public Dimension getContentSize() {
		EllipseModel em = getContent();
		return new Dimension(em.getWidth(), em.getHeight());
	}

	@Override
	public void setContentSize(Dimension totalSize) {
		EllipseModel em = getContent();
		em.setSize(totalSize.getWidth(), totalSize.getHeight());
	}

	
}
