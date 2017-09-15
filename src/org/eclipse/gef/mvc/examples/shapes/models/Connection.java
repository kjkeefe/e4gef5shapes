package org.eclipse.gef.mvc.examples.shapes.models;

import java.util.ArrayList;

public class Connection {

	private Shape source;
	private Shape target;
	private ArrayList<IConnectionListener> listeners = new ArrayList<IConnectionListener>();

	public Shape getSource() {
		return source;
	}

	public Shape getTarget() {
		return target;
	}

	public void setSource(Shape s) {
		if (source != s) {
			Shape oldSource = source;
			source = s;
			notifySourceChanged(oldSource, s);
		}
	}

	public void setTarget(Shape t) {
		if(target != t) {
			Shape oldTarget = target;
			target = t;
			notifyTargetChanged(oldTarget, t);
		}
	}

	public void addListener(IConnectionListener l) {
		if (!listeners.contains(l))
			listeners.add(l);
	}

	public boolean removeListener(IConnectionListener l) {
		return listeners.remove(l);
	}
	
	private void notifySourceChanged(Shape oldSource, Shape s) {
		for(IConnectionListener l : listeners)
			l.handleSourceChanged(this, oldSource, s);
	}
	
	private void notifyTargetChanged(Shape oldTarget, Shape t) {
		for(IConnectionListener l : listeners) 
			l.handleTargetChanged(this, oldTarget, t);
	}

	

}
