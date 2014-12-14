package com.print_stack_trace.voogasalad.controller.guiElements.resourceReader;


public class BlankSpaceTextChecker implements TextChecker{
	public BlankSpaceTextChecker(){
	}
	@Override
	public boolean checkText(String text) {
		return (text.length()!=0||!allBlankSpaces(text));
	}
	
	private boolean allBlankSpaces(String text){
		int count=0;
		for (int i=0; i<text.length();  i++){
			if (!(text.charAt(i)==' '))
				return false;
			}
		return true;
	}
	
	public boolean addText(TextChecker newTypeOfCheck, String text){
		return newTypeOfCheck.checkText(text);
	}


}
