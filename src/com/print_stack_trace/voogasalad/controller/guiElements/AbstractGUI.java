package com.print_stack_trace.voogasalad.controller.guiElements;
import com.print_stack_trace.voogasalad.model.engine.GameEngine;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;



public abstract class AbstractGUI extends BorderPane {
	private double myWidth;
	private double myHeight;
	private Node gamePane;
	protected String myStyle;
	
	public AbstractGUI(Number width, Number height){
		setPrefSize(width.doubleValue(), height.doubleValue());
		myWidth= width.doubleValue();
		myHeight=height.doubleValue();

	}
	protected Node setCenterPane(GameEngine myGameEngine){
		LayoutNode myCenterNode=new GameMainLayoutNode(myWidth, myHeight, myGameEngine);
		gamePane=styleNode(myCenterNode.show());
		ScrollBarPane myScroll=new ScrollBarPane(myWidth, myHeight, gamePane);
		setBorderAndBackgroundStyle(gamePane);
		return myScroll;
	}
	protected Node setTopPane(){
		LayoutNode myTopNode=new GameFileMenuLayoutNode(myWidth, 20, null);
		return styleNode(myTopNode.show());
	}
	protected Node setBottomPane(DecisionTable table){
		LayoutNode myBottomNode=new GameAuthorBottomLayoutNode(myWidth, myHeight, gamePane, table);
		return styleNode(myBottomNode.show());
	}
	protected Node setLeftPane(){
		LayoutNode myLeftNode=new NullLayoutNode(myWidth, myHeight, null);
		return styleNode(myLeftNode.show());
	}
	protected Node setRightPane(){
		LayoutNode myRightNode=new MultipleLibraryLayoutNode(400, myHeight-130, gamePane);
		return styleNode(myRightNode.show());
	}
	protected Node styleNode(Node toBeStyled){
		Node styleNode=toBeStyled;
		if (styleNode!=null){
			setStyle(styleNode);
		}
		return styleNode;
	}
	protected abstract void setBorderAndBackgroundStyle(Node stylePane);
	protected abstract void setStyle(Node stylePane);
	protected abstract void setBorderStyle(Node stylePane);
	public Group initialize(GameEngine gameEngine) {
		DecisionTable dt = new DecisionTable();
		setCenter(setCenterPane(gameEngine));
		setBottom(setBottomPane(dt));
		setLeft(setLeftPane());
		setRight(setRightPane());
		setTop(setTopPane());
		this.setVisible(true);
		Group root = new Group();
		root.getChildren().add(this);
		return root;
	}
}
