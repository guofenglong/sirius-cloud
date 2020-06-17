/*
 *
 */
package com.sirius.security;


import com.sirius.user.repository.UserDao;
import com.sirius.user.repository.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service(value = "userDetailService")
public class UserDetailService implements UserDetailsService {

    @Resource
    private UserDao userDao;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.queryByAccount(username);
        if (null == user) {
            throw new UsernameNotFoundException("user not exists.");
        }
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        authList.add(new SimpleGrantedAuthority(user.getAuthority()));
        UserDetails userDetail = new org.springframework.security.core.userdetails.User(username, user.getPassword(), authList);
        return userDetail;
    }


}
