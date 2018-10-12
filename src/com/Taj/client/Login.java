package com.Taj.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sun.prism.Material;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialFooter;
import gwt.material.design.client.ui.MaterialHeader;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialLoader;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;

public class Login extends Composite {

	private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);

	interface LoginUiBinder extends UiBinder<Widget, Login> {
	}

	static int ky=0;
	static String ui1="";
	
	GreetingServiceAsync a1 = GWT.create(GreetingService.class);
	
	@UiField
	MaterialHeader header;

	@UiField
	MaterialContainer con;

	@UiField
	MaterialButton bt1;
	
	@UiField
	MaterialModal mod3;

	@UiField
	MaterialModal mod1;

	@UiField
	MaterialModal mod2;

	@UiField
	MaterialButton s1;

	@UiField
	MaterialButton s2;

	@UiField
	MaterialButton s3;

	@UiField
	MaterialLink bt2;

	@UiField
	MaterialTextBox usi;

	@UiField
	MaterialTextBox pswd;

	@UiField
	MaterialTextBox ui;

	@UiField
	MaterialTextBox mn;

	@UiField
	MaterialTextBox t2;
	
	@UiField
	MaterialTextBox t3;
	
	public Login() {
		initWidget(uiBinder.createAndBindUi(this));
		bt1.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				String uid = usi.getText();
				String pwd = pswd.getText();
				a1.check(uid, pwd, new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
						if (result == "true") {
							ky=1;
							MaterialLoader.showLoading(true);
							int a = 0;
							for (int i = 0; i < 200000; i++) {
								a += 1;
							}
							History.newItem("Login");
							MySpace.getInstance().func();
							MaterialLoader.showLoading(false);
							ui1=uid;
							usi.setText("");
							pswd.setText("");
						}

						if (result == "false") {
							MaterialToast.fireToast("Wrong Userid or Password", 2000);
						}
					}

				});
			}
		});

		bt2.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub

				RootPanel.get().add(mod1);
				mod1.open();
			}
		});

		s1.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				String ss1 = ui.getText();
				String ss2 = mn.getText();
				a1.chec(ss1, ss2, new AsyncCallback<String>() {

					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
						if (result == "true") {
							mod1.close();
							RootPanel.get().add(mod2);
							mod2.open();
						} else {
							MaterialToast.fireToast("Invalid User");
						}
					}
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
					}
				});
			}
		});

		s2.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub

				RootPanel.get().add(mod3);
				mod2.close();
				mod3.open();
			}
		});

		s3.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub

				String ss1=ui.getText();
				String ss3=t2.getText();
				String ss2=t3.getText();
				if(ss3==ss2)
				{
					a1.put(ss3, ss1, new AsyncCallback<String>() {
						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void onSuccess(String result) {
							// TODO Auto-generated method stub
							if(result!="0")
							{
								MaterialToast.fireToast("Password changes successfully");
								mod1.close();
								mod2.close();
								mod3.close();
							}
							else {
								MaterialToast.fireToast("Invalid User");
							}
						}
					});
				}
				else {
					MaterialToast.fireToast("Password didn't match");
				}
			}
		});
	}
}
