package org.eclipse.gef.mvc.examples.shapes.models;

import java.util.ArrayList;

public class ConnectionModel {

	private ShapeModel source;
	private ShapeModel target;
	private ArrayList<IConnectionModelListener> listeners = new ArrayList<IConnectionModelListener>();

	public ShapeModel getSource() {
		return source;
	}

	public ShapeModel getTarget() {
		return target;
	}

	public void setSource(ShapeModel s) {
		if (source != s) {
			ShapeModel oldSource = source;
			source = s;
			notifySourceChanged(oldSource, s);
		}
	}

	public void setTarget(ShapeModel t) {
		if(target != t) {
			ShapeModel oldTarget = target;
			target = t;
			notifyTargetChanged(oldTarget, t);
		}
	}

	public void addListener(IConnectionModelListener l) {
		if (!listeners.contains(l))
			listeners.add(l);
	}

	public boolean removeListener(IConnectionModelListener l) {
		return listeners.remove(l);
	}
	
	private void notifySourceChanged(ShapeModel oldSource, ShapeModel s) {
		for(IConnectionModelListener l : listeners)
			l.handleSourceChanged(this, oldSource, s);
	}
	
	private void notifyTargetChanged(ShapeModel oldTarget, ShapeModel t) {
		for(IConnectionModelListener l : listeners) 
			l.handleTargetChanged(this, oldTarget, t);
	}

	

}
