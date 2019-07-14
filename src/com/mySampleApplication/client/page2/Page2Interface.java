package com.mySampleApplication.client.page2;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.core.client.GWT;

import java.util.List;

@RemoteServiceRelativePath("Page2Interface")
public interface Page2Interface extends RemoteService {
  /**
   * Utility/Convenience class.
   * Use Page2Interface.App.getInstance() to access static instance of Page2InterfaceAsync
   */
  public static class App {
    private static final Page2InterfaceAsync ourInstance = (Page2InterfaceAsync) GWT.create(Page2Interface.class);

    public static Page2InterfaceAsync getInstance() {
      return ourInstance;
    }
  }

  List<String> getData();


}
