package br.com.unipejet.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import br.com.unipejet.entity.UserProfile;
import br.com.unipejet.service.UserProfileService;

public class RoleToUserProfileConverter implements Converter<Object, UserProfile> {

	static final Logger logger = LoggerFactory.getLogger(RoleToUserProfileConverter.class);
	
	@Autowired
	UserProfileService userProfileService;

	public UserProfile convert(Object element) {
		Integer id = Integer.parseInt((String)element);
		UserProfile profile= userProfileService.findById(id);
		logger.info("Perfil: {}",profile);
		return profile;
	}
}
