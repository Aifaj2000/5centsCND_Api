package com.ecommerce.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.RoleDao;
import com.ecommerce.dao.UserDao;
import com.ecommerce.entity.Role;
import com.ecommerce.entity.User;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void initRoleAndUser() {
    	
    	 Role superadminRole = new Role();
         superadminRole.setRoleName("SuperAdmin");
         superadminRole.setRoleDescription("SuperAdmin role");
         roleDao.save(superadminRole);

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleDao.save(userRole);

        User adminUser = new User();
//        adminUser.setUserName("admin123");
//        adminUser.setUserPassword(getEncodedPassword("admin@pass"));
//        adminUser.setUserFirstName("admin");
//        adminUser.setUserLastName("admin");
        adminUser.setUserName("aifaz123");
        adminUser.setUserPassword(getEncodedPassword("aifaz@pass"));
        adminUser.setUserFirstName("aifaz");
        adminUser.setUserLastName("aifaz");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);
        
        User superadminUser = new User();
        superadminUser.setUserName("superadmin");
        superadminUser.setUserPassword(getEncodedPassword("superadmin"));
        superadminUser.setUserFirstName("superadmin");
        superadminUser.setUserLastName("superadmin");
      Set<Role> superadminRoles = new HashSet<>();
      superadminRoles.add(superadminRole);
      superadminUser.setRole(superadminRoles);
      userDao.save(superadminUser);
        

        User user = new User();
        user.setUserName("raj123");
        user.setUserPassword(getEncodedPassword("raj@123"));
        user.setUserFirstName("raj");
        user.setUserLastName("sharma");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userDao.save(user);
    }

    public User registerNewUser(User user) {
        Role role = roleDao.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));

        return userDao.save(user);
    }
    
    public User registerNewAdminUser(User adminUser) {
        Role adminRole = roleDao.findById("Admin").get();
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        adminUser.setUserPassword(getEncodedPassword(adminUser.getUserPassword()));

        return userDao.save(adminUser);
       
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
