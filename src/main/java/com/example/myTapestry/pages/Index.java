package com.example.myTapestry.pages;


import com.example.myTapestry.entities.User;
import com.example.myTapestry.services.myServices.IUserService;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.util.List;

/**
 * Start page of application myTapestryProject.
 */
public class Index {

  @Inject
  private IUserService userService;

  @Property
  private List<User> users;

  @Property
  private User user;

//  @Inject
//  private Logger logger;
//
//  @Inject
//  private AjaxResponseRenderer ajaxResponseRenderer;
//
//  @Property
//  @Inject
//  @Symbol(SymbolConstants.TAPESTRY_VERSION)
//  private String tapestryVersion;
//
//  @InjectPage
//  private About about;
//
//  @Inject
//  private Block block;
//
//
//  // Handle call with an unwanted context
//  Object onActivate(EventContext eventContext)
//  {
//    return eventContext.getCount() > 0 ?
//        new HttpError(404, "Resource not found") :
//        null;
//  }
//
//
//  Object onActionFromLearnMore()
//  {
//    about.setLearn("LearnMore");
//
//    return about;
//  }
//
//  @Log
//  void onComplete()
//  {
//    logger.info("Complete call on Index page");
//  }
//
//  @Log
//  void onAjax()
//  {
//    logger.info("Ajax call on Index page");
//
//    ajaxResponseRenderer.addRender("middlezone", block);
//  }
//
//
//  public Date getCurrentTime()
//  {
//    return new Date();
//  }

  void onActivate(){
    try {
      users = userService.getUsers();
      int count = users.size();
    } catch (Exception e){
      e.printStackTrace();
    }

  }
}
