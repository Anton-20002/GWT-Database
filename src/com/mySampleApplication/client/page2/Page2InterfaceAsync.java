package com.mySampleApplication.client.page2;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

public interface Page2InterfaceAsync {
  void getData(AsyncCallback<List<String>> async);
}
