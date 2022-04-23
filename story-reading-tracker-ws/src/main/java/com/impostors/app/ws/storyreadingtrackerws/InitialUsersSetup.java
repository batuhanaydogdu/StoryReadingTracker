package com.impostors.app.ws.storyreadingtrackerws;

import java.util.Arrays;
import java.util.Collection;

import com.impostors.app.ws.storyreadingtrackerws.io.entity.AuthorityEntity;
import com.impostors.app.ws.storyreadingtrackerws.io.entity.RoleEntity;
import com.impostors.app.ws.storyreadingtrackerws.io.entity.UserEntity;
import com.impostors.app.ws.storyreadingtrackerws.io.repository.AuthorityRepository;
import com.impostors.app.ws.storyreadingtrackerws.io.repository.RoleRepository;
import com.impostors.app.ws.storyreadingtrackerws.io.repository.UserRepository;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.Roles;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class InitialUsersSetup {

	@Autowired
	AuthorityRepository authorityRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	Utils utils;
	
	@Autowired
	BCryptPasswordEncoder bCyrptPasswordEncoder;
	
	@Autowired
	UserRepository userRepository;
	
	
	@EventListener
	@Transactional
	public void onApplicationEvent(ApplicationReadyEvent event) {
		System.out.println("denemstarttttttt");
		
		AuthorityEntity readAuthority=createAuthority("READ_AUTHORITY");
		AuthorityEntity writeAuthority=createAuthority("WRITE_AUTHORITY");
		AuthorityEntity deleteAuthority=createAuthority("DELETE_AUTHORITY");
	
		RoleEntity roleUser=createRole(Roles.ROLE_ADMIN.name(), Arrays.asList(readAuthority,writeAuthority));
		RoleEntity roleAdmin=createRole(Roles.ROLE_USER.name(), Arrays.asList(readAuthority,writeAuthority,deleteAuthority));
		
		if(roleAdmin==null) return;
		
		if(userRepository.findByEmail("fortest@test.com")!=null) return;
		UserEntity adminUser=new UserEntity();
		adminUser.setFirstName("batuhan");
		adminUser.setLastName("aydoğdu");
		adminUser.setEmail("fortest@test.com");
		adminUser.setEmailVerificationStatus(true);
		adminUser.setAge(23);
		adminUser.setGender("Male");
		adminUser.setTermsAndPoliciesAccepted(true);
		adminUser.setPoints(999);
		adminUser.setUserId(utils.generateUserId(30));
		adminUser.setEncryptedPassword(bCyrptPasswordEncoder.encode("123"));
		adminUser.setRoles(Arrays.asList(roleAdmin,roleUser));
		
		userRepository.save(adminUser);
		
	}
	
	@Transactional
	 AuthorityEntity createAuthority(String name) {
		AuthorityEntity authority = authorityRepository.findByName(name);
		if(authority==null) {
			authority= new AuthorityEntity(name);
			authorityRepository.save(authority);
		}
		return authority;
	}
	
	@Transactional
	 RoleEntity createRole(
			String name,
			Collection<AuthorityEntity> authorities) {
		
		
		RoleEntity role = roleRepository.findByName(name);
		if(role==null) {
			role= new RoleEntity(name);
			role.setAuthorities(authorities);
			roleRepository.save(role);
		}
		return role;
	}
	
	
}
