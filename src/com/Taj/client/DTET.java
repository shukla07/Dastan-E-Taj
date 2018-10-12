package com.Taj.client;

import javax.swing.RootPaneContainer;
import com.Taj.client.Login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
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
import gwt.material.design.client.ui.MaterialCard;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialHeader;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialTextArea;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;

public class DTET extends Composite {

	private static DTETUiBinder uiBinder = GWT.create(DTETUiBinder.class);

	interface DTETUiBinder extends UiBinder<Widget, DTET> {
	}
	GreetingServiceAsync a1 = GWT.create(GreetingService.class);

	@UiField
	MaterialContainer con;

	@UiField
	MaterialHeader header;

	@UiField
	MaterialButton bt1;

	@UiField
	MaterialLink pf;

	@UiField
	MaterialLink lo;
	
	@UiField
	MaterialTextBox lgtd;
	
	@UiField
	MaterialTextBox lttd;
	
	@UiField
	MaterialTextArea dsc;
	
	@UiField
	MaterialTextBox lk;
	
	@UiField
	MaterialTextBox key;
	
	@UiField
	MaterialTextBox name;
	
	@UiField
	MaterialTextBox rd;
	public DTET() {
		initWidget(uiBinder.createAndBindUi(this));

		bt1.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
				String lg=lgtd.getText();
				String lt=lttd.getText();
				String r=rd.getText();
				String ds=dsc.getText();
				String l=lk.getText();
				String k=key.getText();
				String nm=name.getText();
				
				a1.put(lg,lt,nm,ds,r,k,l,new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						MaterialToast.fireToast("Database Connection Lost");
					}

					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
						lgtd.setText("");
						lttd.setText("");
						rd.setText("");
						dsc.setText("");
						lk.setText("");
						key.setText("");
						name.setText("");
						MaterialToast.fireToast("Database Updated");
					}
				});
			}
		});

		pf.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub

				History.newItem("Profile");
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
	}

}
