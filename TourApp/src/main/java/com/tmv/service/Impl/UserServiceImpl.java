/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.service.Impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tmv.pojos.User;
import com.tmv.repository.UserRepository;
import com.tmv.service.UserService;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PC
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public User getUserByID(int userId) {
        return this.userRepository.getUserById(userId);
    }
    
    @Override
    public boolean addUser(User user) {
        try {
            String pass = user.getPassword();
            user.setPassword(this.passwordEncoder.encode(pass));
            user.setUserRole(User.USER);
            
            Map r = this.cloudinary.uploader().upload(user.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            
            user.setAvatar((String) r.get("secure_url"));
            
            
            return this.userRepository.addUser(user);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> getUser(String username) {
        return this.userRepository.getUser(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = this.getUser(username);
        if (users.isEmpty()) {
            throw new UsernameNotFoundException("Không tìm thấy user");
        }
        User u = users.get(0);

        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(u.getUserRole()));
        
        return new org.springframework.security.core.userdetails.User(
                u.getUsername(), u.getPassword(), authorities);
    }
     
}
