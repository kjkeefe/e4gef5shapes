package org.eclipse.gef.mvc.examples.shapes.models;

import java.util.ArrayList;

public class ConnectionModel {

	private AbstractNodeModel source;
	private AbstractNodeModel target;
	private ArrayList<IConnectionModelListener> listeners = new ArrayList<IConnectionModelListener>();

	public AbstractNodeModel getSource() {
		return source;
	}

	public AbstractNodeModel getTarget() {
		return target;
	}

	public void setSource(AbstractNodeModel s) {
		if (source != s) {
			AbstractNodeModel oldSource = source;
			source = s;
			notifySourceChanged(oldSource, s);
		}
	}

	public void setTarget(AbstractNodeModel t) {
		if(target != t) {
			AbstractNodeModel oldTarget = target;
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
	
	private void notifySourceChanged(AbstractNodeModel oldSource, AbstractNodeModel s) {
		for(IConnectionModelListener l : listeners)
			l.handleSourceChanged(this, oldSource, s);
	}
	
	private void notifyTargetChanged(AbstractNodeModel oldTarget, AbstractNodeModel t) {
		for(IConnectionModelListener l : listeners) 
			l.handleTargetChanged(this, oldTarget, t);
	}

	

}
