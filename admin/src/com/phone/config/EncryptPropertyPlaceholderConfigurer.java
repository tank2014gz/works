package com.phone.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;

import com.phone.commons.enhance.ByteFormat;
import com.phone.commons.enhance.XXTeaTool;

public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	protected String convertProperty(String propertyName, String propertyValue) {
		//return XXTeaTool.decrypt(propertyValue, "UTF-8", ByteFormat.toHex("028phone".getBytes()));
		return propertyValue;
	}

}
