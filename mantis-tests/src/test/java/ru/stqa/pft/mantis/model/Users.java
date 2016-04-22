package ru.stqa.pft.mantis.model;/* Created by Vrstiv on 23.04.2016  */


import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


public class Users extends ForwardingSet<UserData> {

  private Set<UserData> delegate;

  public Users(Collection<UserData> users) {
    this.delegate = new HashSet<UserData>(users);
  }

  @Override
  protected Set<UserData> delegate() {
    return delegate;
  }


}