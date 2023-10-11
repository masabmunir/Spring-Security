package com.example.springSecurity.service;

import com.example.springSecurity.entity.User;
import com.example.springSecurity.model.UserModel;

public interface UserService {
  public User registerUser(UserModel userModel);
}
