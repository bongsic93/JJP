package board;

public class BoardFactory {
	
	private BoardFactory(){}
	
	private static BoardFactory instance = new BoardFactory();
	
	public static BoardFactory getInstance(){
		return instance;
	}
	 
	public CommandIf createCommand(String cmd){
		CommandIf cmdIf = null;
		if (cmd.equals("/list.board")){
			cmdIf = new ListCommand();
		}
		return cmdIf;
	}
}









