package com.print_stack_trace.voogasalad.controller.guiElements.layout;

import java.util.HashMap;

import com.print_stack_trace.voogasalad.controller.guiElements.gameAuthor.AbstractViewDelegate;
import com.print_stack_trace.voogasalad.controller.guiElements.resourceReader.ResourceReader;

import javafx.scene.Node;

public abstract class AbstractLayoutNode implements LayoutNode {
	protected Node myNode;
	protected String DEFAULT_RESOURCE="./com/print_stack_trace/voogasalad/controller/guiResources/MenuAndButtonLabels.Properties";
	protected HashMap<String, String> myResource;
	public AbstractLayoutNode(double width, double height, Node focus, Object engine, AbstractViewDelegate delegate){
		myResource=new ResourceReader(DEFAULT_RESOURCE).getProperties();
		this.initialize(width, height, focus, engine, delegate);
		
	}
	@Override
	public Node show(){
		return myNode;
	}
	@Override
	public abstract void initialize(double width, double height);
	@Override
	public abstract void initialize(double width, double height, Node myLinkedObject, Object engine, AbstractViewDelegate delegate);
	public abstract Number getHeight();
	public abstract Number getWidth();

}
