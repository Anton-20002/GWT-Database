package com.mySampleApplication.client.page1;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class MySampleApplication implements EntryPoint {

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
    final Button button = new Button("Click me");
    final Label label = new Label();


    button.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (label.getText().equals("")) {
          MySampleApplicationService.App.getInstance().getMessage("Hello, World!", new MyAsyncCallback(label));

          MySampleApplicationService.App.getInstance().connection(new AsyncCallback<Void>() {
            @Override
            public void onFailure(Throwable caught) {
              System.out.println("Error");
            }

            @Override
            public void onSuccess(Void result) {
              System.out.println("Norm!");
            }
          });
        } else {
          label.setText("");
        }
      }
    });

    RootPanel.get("slot1").add(button);
    RootPanel.get("slot2").add(label);
  }

  private static class MyAsyncCallback implements AsyncCallback<String> {
    private Label label;

    MyAsyncCallback(Label label) {
      this.label = label;
    }

    public void onSuccess(String result) {
      label.getElement().setInnerHTML(result);
    }

    public void onFailure(Throwable throwable) {
      label.setText("Failed to receive answer from server!");
    }
  }
}
