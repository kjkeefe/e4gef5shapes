package org.eclipse.gef.mvc.examples.shapes.models;

import java.util.ArrayList;
import java.util.HashSet;

public class DiagramModel {
	
	private HashSet<AbstractNodeModel> shapes = new HashSet<AbstractNodeModel>();
	private HashSet<ConnectionModel> connections = new HashSet<ConnectionModel>();
	private ArrayList<IDiagramModelListener> listeners = new ArrayList<IDiagramModelListener>();
	
	public boolean addShape(AbstractNodeModel s) {
		if(s != null && shapes.add(s)) {
			notifyShapeAdded(s);
			return true;
		}
		return false;
	}
	
	public ArrayList<AbstractNodeModel> getShapes() {
		return new ArrayList<AbstractNodeModel>(shapes);
	}
	
	public boolean removeShape(AbstractNodeModel s) {
		if(s != null && shapes.remove(s)) {
			for(ConnectionModel c : s.getSourceConnections())
				removeConnection(c);
			for(ConnectionModel c : s.getTargetConnections())
				removeConnection(c);
			notifyShapeRemoved(s);
			return true;
		}
		return false;
	}
	
	public boolean addConnection(ConnectionModel c) {
		if(c != null && connections.add(c)) {
			notifyConnectionAdded(c);
			return true;
		}
		return false;
	}
	
	public ArrayList<ConnectionModel> getConnections() {
		return new ArrayList<ConnectionModel>(connections);
	}
	
	public boolean removeConnection(ConnectionModel c) {
		if(c != null && connections.remove(c)) {
			c.setSource(null);
			c.setTarget(null);
			notifyConnectionRemoved(c);
			return true;
		}
		return false;
	}

	public void addListener(IDiagramModelListener l) {
		if(!listeners.contains(l))
			listeners.add(l);
	}
	
	public boolean removeListener(IDiagramModelListener l) {
		return listeners.remove(l);
	}
	
	
	private void notifyShapeAdded(AbstractNodeModel s) {
		for(IDiagramModelListener l : listeners) {
			l.handleShapeAdded(this, s);
		}
	}
	
	private void notifyShapeRemoved(AbstractNodeModel s) {
		for(IDiagramModelListener l : listeners) {
			l.handleShapeRemoved(this, s);
		}
	}
	
	private void notifyConnectionAdded(ConnectionModel c) {
		for(IDiagramModelListener l : listeners) {
			l.handleConnectionAdded(this, c);
		}
	}

	private void notifyConnectionRemoved(ConnectionModel c) {
		for(IDiagramModelListener l : listeners) {
			l.handleConnectionRemoved(this, c);
		}
	}
}
