package com.phone.system;
import org.apache.log4j.Logger;
import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;


@Service("customerAccessDecisionManager")
public class CustomerAccessDecisionManager implements AccessDecisionManager {
	
	private static final Logger logger = Logger.getLogger(CustomerAccessDecisionManager.class);
	
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
		if (logger.isDebugEnabled()) {
			logger.debug("decide(Authentication, Object, Collection<ConfigAttribute>) - start");
		}
		if (configAttributes == null) {
			if (logger.isDebugEnabled()) {
				logger.debug("decide(Authentication, Object, Collection<ConfigAttribute>) - end");
			}
			return;
		}else{
			String visitURL = object.toString();
			if (logger.isDebugEnabled()){
				logger.debug("user visit url="+visitURL);
			}
			Iterator<ConfigAttribute> ite = configAttributes.iterator();
			while (ite.hasNext()) {
				ConfigAttribute ca = ite.next();
				logger.debug("needRole is£º"+ca.getAttribute());
				String needRole = ((SecurityConfig) ca).getAttribute();
				for (GrantedAuthority ga : authentication.getAuthorities()) {
					logger.debug("permisson role£º"+ga.getAuthority());
					if (needRole.equals(ga.getAuthority())) {
						if (logger.isDebugEnabled()) {
							logger.debug("needRole is:"+needRole+",user role contains role:"+ga.getAuthority()+", match!");
							logger.debug("decide(Authentication, Object, Collection<ConfigAttribute>) - end");
						}
						return;
					}
				}
			}
			throw new AccessDeniedException("User no right to visit url="+visitURL);
		}
		
		
	}
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}
	public boolean supports(Class<?> clazz) {
		return true;
	}
}