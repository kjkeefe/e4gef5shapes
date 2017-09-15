package org.eclipse.gef.mvc.examples.shapes.models;

import java.util.ArrayList;
import java.util.HashSet;

public class Diagram {
	
	private HashSet<Shape> shapes = new HashSet<Shape>();
	private HashSet<Connection> connections = new HashSet<Connection>();
	private ArrayList<IDiagramListener> listeners = new ArrayList<IDiagramListener>();
	
	public boolean addShape(Shape s) {
		if(s != null && shapes.add(s)) {
			notifyShapeAdded(s);
			return true;
		}
		return false;
	}
	
	public Shape[] getShapes() {
		return shapes.toArray(new Shape[shapes.size()]);
	}
	
	public boolean removeShape(Shape s) {
		if(s != null && shapes.remove(s)) {
			for(Connection c : s.getSourceConnections())
				removeConnection(c);
			for(Connection c : s.getTargetConnections())
				removeConnection(c);
			notifyShapeRemoved(s);
			return true;
		}
		return false;
	}
	
	public boolean addConnection(Connection c) {
		if(c != null && connections.add(c)) {
			notifyConnectionAdded(c);
			return true;
		}
		return false;
	}
	
	public Connection[] getConnections() {
		return connections.toArray(new Connection[connections.size()]);
	}
	
	public boolean removeConnection(Connection c) {
		if(c != null && connections.remove(c)) {
			c.setSource(null);
			c.setTarget(null);
			notifyConnectionRemoved(c);
			return true;
		}
		return false;
	}

	public void addListener(IDiagramListener l) {
		if(!listeners.contains(l))
			listeners.add(l);
	}
	
	public boolean removeListener(IDiagramListener l) {
		return listeners.remove(l);
	}
	
	
	private void notifyShapeAdded(Shape s) {
		for(IDiagramListener l : listeners) {
			l.handleShapeAdded(this, s);
		}
	}
	
	private void notifyShapeRemoved(Shape s) {
		for(IDiagramListener l : listeners) {
			l.handleShapeRemoved(this, s);
		}
	}
	
	private void notifyConnectionAdded(Connection c) {
		for(IDiagramListener l : listeners) {
			l.handleConnectionAdded(this, c);
		}
	}

	private void notifyConnectionRemoved(Connection c) {
		for(IDiagramListener l : listeners) {
			l.handleConnectionRemoved(this, c);
		}
	}
}
