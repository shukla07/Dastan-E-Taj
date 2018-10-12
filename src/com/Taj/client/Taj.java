package com.Taj.client;

import javax.swing.RootPaneContainer;

import com.Taj.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import gwt.material.design.client.ui.MaterialButton;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Taj implements EntryPoint {

	MaterialButton b1=new MaterialButton();
	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub
		b1.setText("CLICK TO ENTER");
		RootPanel.get("d1").add(b1);
		History.addValueChangeHandler(new ValueChangeHandler<String>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<String> event) {
				// TODO Auto-generated method stub
				MySpace.getInstance().func();
			}
		});
		b1.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				RootPanel.get("d1").clear();
				RootPanel.get("d1").add(new Login());
			}
		});
	}
	
}
