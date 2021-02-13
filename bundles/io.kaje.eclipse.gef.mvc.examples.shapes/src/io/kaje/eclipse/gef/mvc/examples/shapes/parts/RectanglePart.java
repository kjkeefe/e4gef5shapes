package io.kaje.eclipse.gef.mvc.examples.shapes.parts;

import java.util.List;

import org.eclipse.gef.fx.nodes.GeometryNode;
import org.eclipse.gef.geometry.planar.Dimension;
import org.eclipse.gef.geometry.planar.IShape;
import org.eclipse.gef.mvc.fx.parts.AbstractContentPart;
import org.eclipse.gef.mvc.fx.parts.IResizableContentPart;
import org.eclipse.gef.mvc.fx.parts.ITransformableContentPart;

import com.google.common.collect.SetMultimap;

import javafx.scene.transform.Affine;

public class RectanglePart extends AbstractContentPart<GeometryNode<IShape>>
implements ITransformableContentPart<GeometryNode<IShape>>, IResizableContentPart<GeometryNode<IShape>> {

	@Override
	public Dimension getContentSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setContentSize(Dimension totalSize) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Affine getContentTransform() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setContentTransform(Affine totalTransform) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected SetMultimap<? extends Object, String> doGetContentAnchorages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<? extends Object> doGetContentChildren() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected GeometryNode<IShape> doCreateVisual() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void doRefreshVisual(GeometryNode<IShape> visual) {
		// TODO Auto-generated method stub
		
	}

}
