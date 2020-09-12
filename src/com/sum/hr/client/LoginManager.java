package com.sum.hr.client;

import com.google.gwt.user.client.ui.PopupPanel;

public class LoginManager extends PopupPanel {

	public LoginManager() {
		super(true);
		
		Login login = new Login();
		setWidget(login);
		login.setSize("283px", "139px");
	}

}
