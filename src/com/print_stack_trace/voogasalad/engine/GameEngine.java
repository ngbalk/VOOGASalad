package com.print_stack_trace.voogasalad.engine;

public class GameEngine {
	private static GameEngine singletonInstance;
	private LevelModel currentLevel;
	
	//-------------------CONSTRUCTORS-------------------//
	
	/**
	 * Constructor Method. It is private because this class is designed to only
	 * be used as a Singleton. Call the static method getSharedInstance to
	 * access the Singleton.
	 */
	private GameEngine() {
		//TODO: Implement Constructor
	}
	
	//-------------------PUBLIC METHODS-------------------//
	
	public RuntimeModel getStatus() {
		RuntimeModel ret = new RuntimeModel();
		/*TODO: Implement -- this is looks like an accessor to everyone else but
		 *a RuntimeModel should be created at the time it is called and built 
		 *from all of the various at time of call. */
		return ret;
	}
	
	//-------------------ACCESSORS-------------------//
	
	public LevelModel getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(LevelModel currentLevel) {
		this.currentLevel = currentLevel;
		loadLevel(currentLevel);
	}

	public static GameEngine getSharedInstance() {
		if(singletonInstance == null) {
			singletonInstance = new GameEngine();
		}
		return singletonInstance;
	}
	
	//-------------------PRIVATE METHODS-------------------//
	
	private void loadLevel(LevelModel level) {
		//TODO: Implement -- Will be used for setLevel but also reseting level.
	}
}
