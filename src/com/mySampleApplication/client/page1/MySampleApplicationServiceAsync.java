package com.mySampleApplication.client.page1;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MySampleApplicationServiceAsync {
  void getMessage(String msg, AsyncCallback<String> async);

  void connection(AsyncCallback<Void> async);
}
