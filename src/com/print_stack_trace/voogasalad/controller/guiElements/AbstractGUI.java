package com.print_stack_trace.voogasalad.controller.guiElements;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import com.print_stack_trace.voogasalad.model.engine.GameEngine;
import com.print_stack_trace.voogasalad.utilities.Reflection;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;



public abstract class AbstractGUI extends BorderPane implements AbstractViewDelegate {
	private double myWidth;
	private double myHeight;
	private Node focusPane=new Pane();
	protected String myStyle;
	HashMap<String, String> locations=new HashMap<String, String>();
	protected final static String DEFAULT_LAYOUT_RESOURCE="./com/print_stack_trace/voogasalad/controller/guiResources/GUILayout.Properties";
	public AbstractGUI(Number width, Number height){
		setPrefSize(width.doubleValue(), height.doubleValue());
		myWidth= width.doubleValue();
		myHeight=height.doubleValue();
		createLayout();
		makeLayoutMap();

	}
	public enum LayoutNodeLocation{
		CENTER,
		LEFT,
		RIGHT,
		TOP,
		BOTTOM
	}
	private void createLayout(){
		for (LayoutNodeLocation loc: LayoutNodeLocation.values()){
			locations.put(loc.name(), null);
		}
	}

	protected Node setCenterPane(Object engine){
		focusPane=styleNode(createNode(locations.get(LayoutNodeLocation.CENTER.name()), engine));
		ScrollBarPane myScroll=new ScrollBarPane(myWidth, myHeight, focusPane);
		setBorderAndBackgroundStyle(focusPane);
		return myScroll;
	}

	protected Node setTopPane(Object engine){
		return createNode(locations.get(LayoutNodeLocation.TOP.name()), engine);
	}

	protected Node setBottomPane(Object engine){
		return createNode(locations.get(LayoutNodeLocation.BOTTOM.name()), engine);
	}

	protected Node setLeftPane(Object engine){
		return createNode(locations.get(LayoutNodeLocation.LEFT.name()), engine);
	}

	protected Node setRightPane(Object engine){
		return createNode(locations.get(LayoutNodeLocation.RIGHT.name()), engine);
	}
	private Node createNode(String value, Object engine){
		String className=value;
		double width=0;
		double height=0;
		if (value.contains(";")){
			String[] values=value.split(";");
			Iterator<String> myIterator=Arrays.asList(values).iterator();
			className=(myIterator.hasNext())? myIterator.next():null;
			width=(myIterator.hasNext())? Double.parseDouble(myIterator.next()): 0;
			height=(myIterator.hasNext())? Double.parseDouble(myIterator.next()): 0;
		}

		LayoutNode myNode=(LayoutNode) new Reflection().createInstance(className, width*myWidth, height*myHeight, focusPane, engine, this);
		return styleNode(myNode.show());
	}

	protected Node styleNode(Node toBeStyled){
		Node styleNode=toBeStyled;
		if (styleNode!=null){
			setStyle(styleNode);
		}
		return styleNode;
	}
	protected void makeLayoutMap(){
		ResourceReader myResource=new ResourceReader(DEFAULT_LAYOUT_RESOURCE);
		HashMap<String, String> typeOfLayout=myResource.getProperties();
		for (String loc: typeOfLayout.keySet()){
			if (locations.containsKey(loc)){
				locations.put(loc, typeOfLayout.get(loc));
			}
		}

	}
	protected abstract void setBorderAndBackgroundStyle(Node stylePane);
	protected abstract void setStyle(Node stylePane);
	protected abstract void setBorderStyle(Node stylePane);
	public Group initialize(GameEngine gameEngine) {
		setCenter(setCenterPane(gameEngine));
		setBottom(setBottomPane(gameEngine));
		setLeft(setLeftPane(gameEngine));
		setRight(setRightPane(gameEngine));
		setTop(setTopPane(gameEngine));
		this.setVisible(true);
		Group root = new Group();
		root.getChildren().add(this);
		return root;
	}
	public void open(){};
	public void save(){};
	public void switchRightAndLeftNode(){
		System.out.println("WHAT");
		Node myRight=this.getRight();
		Node myLeft=this.getLeft();
		this.getChildren().remove(myRight);
		this.getChildren().remove(myLeft);
		this.setLeft(myRight);
		this.setRight(myLeft);
	}
	public void switchTopAndBottomNode(){
		System.out.println("WHAT");
		Node myTop=this.getTop();
		Node myBottom=this.getBottom();
		this.getChildren().remove(myBottom);
		this.getChildren().remove(myTop);
		this.setBottom(myTop);
		this.setTop(myBottom);
	}
}
