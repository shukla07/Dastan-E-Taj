package com.Taj.client;

import com.google.gwt.core.client.GWT;
import com.Taj.client.Login;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
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

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialHeader;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;

public class profile extends Composite {

	private static profileUiBinder uiBinder = GWT.create(profileUiBinder.class);

	interface profileUiBinder extends UiBinder<Widget, profile> {
	}

	GreetingServiceAsync a1 = GWT.create(GreetingService.class);

	@UiField
	MaterialHeader header;
	
	@UiField
	MaterialContainer con;
	
	@UiField
	MaterialButton cp;

	@UiField
	MaterialModal mod;

	@UiField
	MaterialButton bt1;

	@UiField
	MaterialTextBox t0;

	@UiField
	MaterialTextBox t1;

	@UiField
	MaterialTextBox t2;

	@UiField
	MaterialTextBox t3;
	
	@UiField
	MaterialTextBox Un;
	
	@UiField
	MaterialTextBox Uidd;
	
	@UiField
	MaterialTextBox Phn;

	@UiField
	MaterialLink hm;

	@UiField
	MaterialLink lo;

	public profile() {
		initWidget(uiBinder.createAndBindUi(this));
		a1.getpf(Login.ui1, new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				String ss1[]=result.split("@");
				Uidd.setText(ss1[0]);
				Un.setText(ss1[1]);
				Phn.setText(ss1[2]);
			}
		});

		cp.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub

				RootPanel.get().add(mod);
				mod.open();
			}
		});
		
		hm.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				History.newItem("Home");
				MySpace.getInstance().func();
			}
		});

		lo.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				Login.ky=0;
				History.newItem("Logout");
				MySpace.getInstance().func();
			}
		});

		bt1.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				String uid = t0.getText();
				String pwd = t1.getText();
				String pswd = t2.getText();
				a1.check(uid, pwd, new AsyncCallback<String>() {

					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
						if (result == "0") {
							MaterialToast.fireToast("Incorrect User Id or Password");
						} else {
							if (pswd == t3.getText()) {
								a1.put(pswd, uid, new AsyncCallback<String>() {

									@Override
									public void onSuccess(String result) {
										// TODO Auto-generated method stub
										MaterialToast.fireToast("Password changes successfully");
										mod.close();
									}

									@Override
									public void onFailure(Throwable caught) {
										// TODO Auto-generated method stub

									}
								});
							}
							else {
								MaterialToast.fireToast("Password is not Matching");
							}
						}
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}
				});
			}
		});
	}

}
