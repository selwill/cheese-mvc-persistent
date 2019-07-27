package com.selwill.track.service;

import com.selwill.track.model.User;

public interface UserService {

    public User findUserByEmail(String email);

    public void saveUser(User user);
}