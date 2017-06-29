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
		}else if (cmd.equals("/write_form.board")){
			cmdIf = new WriteFormCommand();	
		}else if (cmd.equals("/write_pro.board")){
			cmdIf = new WriteProCommand();
		}else if (cmd.equals("/content.board")){
			cmdIf = new ContentCommand();
		}else if (cmd.equals("/delete_form.board")){
			cmdIf = new DeleteFormCommand();
		}else if (cmd.equals("/delete_pro.board")){
			cmdIf = new DeleteProCommand();
		}else if (cmd.equals("/update_form.board")){
			cmdIf = new UpdateFormCommand();
		}else if (cmd.equals("/update_pro.board")){
			cmdIf = new UpdateProCommand();
		}
		return cmdIf;
	}
}









