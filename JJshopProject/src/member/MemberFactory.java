package member;

public class MemberFactory {
	
	private MemberFactory(){}
	
	private static MemberFactory instance = new MemberFactory();
	
	public static MemberFactory getInstance(){
		return instance;
	}
	 
	public CommandIf createCommand(String cmd){
		
		CommandIf cmdIf = null;
		if (cmd.equals("/join.member")){
			cmdIf = new JoinCommander();
		}else if(cmd.equals("/IdOverlapCheck.member")){
			cmdIf = new IdOverlapCheckCommander();
		}else if(cmd.equals("/login.member")){
			cmdIf = new LoginCommander();
		}else if(cmd.equals("/IdSearchForm.member")){
			cmdIf = new IdSearchFormCommander();
		}else if(cmd.equals("/IdSearch.member")){
			cmdIf = new IdSearchCommander();
		}else if(cmd.equals("/PWSearchForm.member")){
			cmdIf = new PWSearchFormCommander();
		}else if(cmd.equals("/PWSearch.member")){
			cmdIf = new PWSearchCommander();
		}else if(cmd.equals("/mypage.member")){
			cmdIf = new MypageCheck();
		}else if(cmd.equals("/mypageCheck.member")){
			cmdIf = new mypageCheckCommander();
		}else if(cmd.equals("/memInfoModify.member")){
			cmdIf = new MemInfoModifyCommander();
		}else if(cmd.equals("/mypageInfoForm.member")){
			cmdIf = new MypageInfoForm();
		}else if(cmd.equals("/joinForm.member")){
			cmdIf = new JoinForm();
		}else if(cmd.equals("/loginForm.member")){
			cmdIf = new LoginForm();
		}else if(cmd.equals("/logout.member")){
			cmdIf = new LogOut();
		}
		
		return cmdIf;
	}
}









