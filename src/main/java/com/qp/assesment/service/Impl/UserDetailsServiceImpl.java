package com.qp.assesment.service.Impl;

import com.qp.assesment.entity.UserEntity;
import com.qp.assesment.mapper.UserMapper;
import com.qp.assesment.model.UserModel;
import com.qp.assesment.repository.UserRepo;
import com.qp.assesment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService, UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByEmail(username).orElseThrow(() ->
                new UsernameNotFoundException("User not found with username " + username));
    }

    @Override
    public void registerUser(UserModel userModel) {
        //userRepo.save(userMapper.toUserEntity(userModel));
    }
}
