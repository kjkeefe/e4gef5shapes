package io.kaje.eclipse.gef.mvc.examples.shapes.models;

import java.util.ArrayList;
import java.util.HashSet;

public class DiagramModel {
	
	private HashSet<ShapeModel> shapes = new HashSet<ShapeModel>();
	private HashSet<ConnectionModel> connections = new HashSet<ConnectionModel>();
	private ArrayList<IDiagramModelListener> listeners = new ArrayList<IDiagramModelListener>();
	
	public boolean addShape(ShapeModel s) {
		if(s != null && shapes.add(s)) {
			notifyShapeAdded(s);
			return true;
		}
		return false;
	}
	
	public ShapeModel[] getShapes() {
		return shapes.toArray(new ShapeModel[shapes.size()]);
	}
	
	public boolean removeShape(ShapeModel s) {
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
	
	public ConnectionModel[] getConnections() {
		return connections.toArray(new ConnectionModel[connections.size()]);
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
	
	
	private void notifyShapeAdded(ShapeModel s) {
		for(IDiagramModelListener l : listeners) {
			l.handleShapeAdded(this, s);
		}
	}
	
	private void notifyShapeRemoved(ShapeModel s) {
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
