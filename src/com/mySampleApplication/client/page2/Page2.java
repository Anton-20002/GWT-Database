package com.mySampleApplication.client.page2;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;

import java.util.List;

public class Page2 implements EntryPoint {
  public void onModuleLoad() {
    ListBox combobox = new ListBox();

    Page2Interface.App.getInstance().getData(new AsyncCallback<List<String>>() {
      @Override
      public void onFailure(Throwable caught) {

      }

      @Override
      public void onSuccess(List<String> result) {
        combobox.addItem("Artem");
        for (String data : result) {
          combobox.addItem(data);
        }
        }

    });





        RootPanel.get("slot1").add(combobox);
}

}
