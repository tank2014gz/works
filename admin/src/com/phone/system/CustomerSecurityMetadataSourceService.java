package com.phone.system;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import com.phone.dao.ResourceDAO;
import com.phone.dao.RoleDAO;
import com.phone.dao.RoleResourceDAO;
import com.phone.entity.Resource;
import com.phone.entity.Role;
import com.phone.entity.RoleResource;

@Service("customerSecurityMetadataSourceService")
public class CustomerSecurityMetadataSourceService implements
		FilterInvocationSecurityMetadataSource {
	private static final Logger logger = Logger.getLogger(CustomerSecurityMetadataSourceService.class);
	
	//private static final ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();

	private PathMatcher urlMatcher = new AntPathMatcher();
	private static final Map<String, List<ConfigAttribute>> urlRolesMap = new ConcurrentHashMap<String, List<ConfigAttribute>>();
	
	
	@Autowired
	private RoleDAO roleDAO;
	
	@Autowired
	private RoleResourceDAO roleResourceDAO;
	
	@Autowired
	private ResourceDAO resourceDAO;

	
	public  void init(){
		Map<String,Object> cond = new HashMap<String, Object>();
		List<Role> roles = roleDAO.selectByExample(cond);
		List<Resource> resources = resourceDAO.selectByExample(cond);
		List<RoleResource> roleResources = roleResourceDAO.selectByExample(cond);
		
		Map<String,Resource> resourceMap = new HashMap<String, Resource>();
		for(Resource tmp : resources){
			resourceMap.put(tmp.getResourceId(), tmp);
		}
		Map<String,Role> roleMap = new HashMap<String, Role>();
		for(Role tmp : roles){
			roleMap.put(tmp.getRoleId(), tmp);
		}
		
		for(RoleResource item : roleResources){
             String resourceId = item.getResourceId();
             String roleId = item.getRoleId();
             Role role = roleMap.get(roleId);
             Resource resource = resourceMap.get(resourceId);
             String resourceUrl = resource.getResourceUrl();
             List<ConfigAttribute> cas = urlRolesMap.get(resourceUrl);
             if(cas==null){
            	 cas = new ArrayList<ConfigAttribute>();
             }
             ConfigAttribute ca = new SecurityConfig(role.getRoleName());
        	 cas.add(ca);
        	 urlRolesMap.put(resourceUrl, cas); 
		}
	
	}
	
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		if (logger.isDebugEnabled()) {
			logger.debug("getAttributes(Object) - start"); //$NON-NLS-1$
		}
		String url = ((FilterInvocation) object).getRequestUrl();
		Iterator<String> ite = urlRolesMap.keySet().iterator();
		while (ite.hasNext()) {
			String resURL = ite.next();
			if (urlMatcher.match(resURL, url)) {
				Collection<ConfigAttribute> returnCollection = urlRolesMap.get(resURL);
				if (logger.isDebugEnabled()) {
					logger.debug("getAttributes(Object) - end");
				}
				return returnCollection;
			}
		}
		if (logger.isDebugEnabled()) {
			logger.debug("getAttributes(Object) - end");
		}
		return null;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}
}