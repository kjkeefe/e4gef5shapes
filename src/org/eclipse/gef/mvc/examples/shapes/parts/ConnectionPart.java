package org.eclipse.gef.mvc.examples.shapes.parts;

import java.util.List;

import org.eclipse.gef.fx.nodes.Connection;
import org.eclipse.gef.mvc.fx.parts.AbstractContentPart;
import org.eclipse.gef.mvc.fx.parts.IBendableContentPart;

import com.google.common.collect.SetMultimap;

public class ConnectionPart extends AbstractContentPart<Connection>
implements IBendableContentPart<Connection> {

	@Override
	public List<BendPoint> getContentBendPoints() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setContentBendPoints(List<BendPoint> bendPoints) {
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
	protected Connection doCreateVisual() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void doRefreshVisual(Connection visual) {
		// TODO Auto-generated method stub
		
	}

}
