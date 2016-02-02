package com.huoyun.core.user;

import com.huoyun.core.user.entity.InviteRecord;
import com.huoyun.core.user.entity.ResetPasswordRecord;
import com.huoyun.core.user.entity.User;

public interface MailService {

	void sendInviteRegisterMail(InviteRecord inviteRecord);
	
	void sendRegisterSuccessMail(User user);
	
	void sendResetPasswordMail(ResetPasswordRecord record);
	
	void sendResetPasswordSuccessMail(User user);
}
