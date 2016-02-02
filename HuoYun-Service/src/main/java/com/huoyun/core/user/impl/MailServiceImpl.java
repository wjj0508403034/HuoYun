package com.huoyun.core.user.impl;

import org.springframework.stereotype.Service;

import com.huoyun.core.user.MailService;
import com.huoyun.core.user.entity.InviteRecord;
import com.huoyun.core.user.entity.ResetPasswordRecord;
import com.huoyun.core.user.entity.User;

@Service(value = "UserMailService")
public class MailServiceImpl implements MailService {

	@Override
	public void sendInviteRegisterMail(InviteRecord inviteRecord) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendRegisterSuccessMail(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendResetPasswordMail(ResetPasswordRecord record) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendResetPasswordSuccessMail(User user) {
		// TODO Auto-generated method stub

	}

}
