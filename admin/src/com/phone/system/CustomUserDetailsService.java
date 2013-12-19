package com.phone.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.phone.dao.RoleDAO;
import com.phone.dao.UserDAO;
import com.phone.dao.UserRoleDAO;
import com.phone.entity.CustomerUserDetails;
import com.phone.entity.Role;
import com.phone.entity.UserRole;
import com.phone.entity.Users;

@Service(value="customerUserDetailsService")
public class CustomUserDetailsService  implements UserDetailsService{

	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private UserRoleDAO userRoleDAO;
	
	@Autowired
	private RoleDAO roleDAO;
	
	@Autowired
	private MessageSource messageSource;
	
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		Map<String,Object> cond = new HashMap<String,Object>();
		cond.put("userName", userName);
		List<Users> userList = userDao.selectByExample(cond);
		if(userList==null || userList.size()==0){
			throw new RuntimeException(messageSource.getMessage("userDetailService.user.name.notFound",new Object[]{userName},null));
		}
		Users user = userList.get(0);
		String userId = user.getUserId();
		
		List<SimpleGrantedAuthority> authorities  = new ArrayList<SimpleGrantedAuthority>();
		cond = new HashMap<String, Object>();
		cond.put("userId", userId);
		List<UserRole> userRoles= userRoleDAO.selectByExample(cond);
		if(userRoles.size()>0){
			List<String> roleList = new ArrayList<String>();
			for(UserRole tmp : userRoles){
				roleList.add(tmp.getRoleId());
			}
			cond = new HashMap<String, Object>();
			cond.put("roleIdList", roleList);
			cond.put("status", "1");//没有被禁用的角色
			List<Role> roles = roleDAO.selectByExample(cond);
			if(roles!=null){
				for(Role  tmp: roles){
					authorities.add(new SimpleGrantedAuthority(tmp.getRoleName()));
				}
			}
		}
		CustomerUserDetails  userDetails = new CustomerUserDetails(userName, user.getPassword(), user.getStatus()==1 , true, true, true, authorities);
        
		return userDetails;
	}
	
	

}
