package com.huoyun.core.user;

public class ErrorCode {
	public final static int Register_Field_Empty = 10001;
	public final static int Register_Invalid_Email_Format = 10002;
	public final static int Register_Password_NotMatch = 10003;
	public final static int Register_Email_Exist = 10004;
	public final static int Register_Email_Already_Invited = 10005;
	public final static int Register_Failed_Email_No_Invite = 10006;
	public final static int Register_Failed_Invite_Code_Error = 10007;
	public final static int Register_Failed_Invite_Code_Expired = 10008;
	public final static int Register_Reinvite_Failed_Due_To_User_Finished_Register = 10009;
	public final static int Login_Failed = 10100;
	public final static int User_Not_Exist = 10101;
	public final static int Logout_Failed_With_No_User = 10200;
	public final static int Session_No_User = 10201;
	public final static int User_Is_Not_Admin = 10202;
	public final static int Set_User_Admin_Failed_Due_To_User_Already_Admin = 10203;
	public final static int ResetPassword_Failed_With_Invalid_Password = 10300;
	public final static int ResetPassword_Failed_With_Same_Password = 10301;
	public final static int ResetPassword_Failed_With_No_Record = 10302;
	public final static int ResetPassword_Failed_With_Code_Error = 10303;
	public final static int ResetPassword_Failed_With_Code_Expired = 10304;

}
