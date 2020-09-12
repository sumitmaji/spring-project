package com.sum.hr.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Button;

public class Login extends Composite {

	public Login() {
		
		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		
		Label lblInfo = new Label("Login to HR Application");
		verticalPanel.add(lblInfo);
		
		FlexTable flexTable = new FlexTable();
		verticalPanel.add(flexTable);
		
		Label lblUsername = new Label("UserName:");
		flexTable.setWidget(0, 0, lblUsername);
		
		TextBox textBoxUserName = new TextBox();
		flexTable.setWidget(0, 1, textBoxUserName);
		
		Label lblPassword = new Label("Password:");
		flexTable.setWidget(1, 0, lblPassword);
		
		PasswordTextBox passwordTextBox = new PasswordTextBox();
		flexTable.setWidget(1, 1, passwordTextBox);
		
		CheckBox chckbxRemember = new CheckBox("Remember me on this computer");
		flexTable.setWidget(2, 1, chckbxRemember);
		
		Button btnSignIn = new Button("New button");
		btnSignIn.setText("SignIn");
		flexTable.setWidget(3, 1, btnSignIn);
	}

}
