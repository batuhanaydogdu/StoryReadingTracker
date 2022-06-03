package com.impostors.app.ws.storyreadingtrackerws;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.impostors.app.ws.storyreadingtrackerws.io.document.Contour;
import com.impostors.app.ws.storyreadingtrackerws.io.document.FaceExperienceDocument;
import com.impostors.app.ws.storyreadingtrackerws.io.entity.AuthorityEntity;
import com.impostors.app.ws.storyreadingtrackerws.io.entity.AvatarEntity;
import com.impostors.app.ws.storyreadingtrackerws.io.entity.RoleEntity;
import com.impostors.app.ws.storyreadingtrackerws.io.entity.UserEntity;
import com.impostors.app.ws.storyreadingtrackerws.io.repository.mongodb.FaceExperienceRepository;
import com.impostors.app.ws.storyreadingtrackerws.io.repository.mysql.AuthorityRepository;
import com.impostors.app.ws.storyreadingtrackerws.io.repository.mysql.AvatarRepository;
import com.impostors.app.ws.storyreadingtrackerws.io.repository.mysql.RoleRepository;
import com.impostors.app.ws.storyreadingtrackerws.io.repository.mysql.UserRepository;
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
	AvatarRepository avatarRepository;
	
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

		AvatarEntity avatar1=new AvatarEntity();
		AvatarEntity avatar2=new AvatarEntity();
		AvatarEntity avatar3=new AvatarEntity();
		AvatarEntity avatar4=new AvatarEntity();

		avatar1.setAvatarId("lmd7j5lL");
		avatar1.setAvatarName("avatar1");
		avatar1.setAvatarPrice(1);
		avatar1.setAvatarURL("avatar1.jpg");
		if(avatarRepository.findByAvatarName("avatar1")==null){
			avatarRepository.save(avatar1);
		};

		avatar2.setAvatarId("qc6cGDqE");
		avatar2.setAvatarName("avatar2");
		avatar2.setAvatarPrice(1);
		avatar2.setAvatarURL("avatar2.jpg");
		if(avatarRepository.findByAvatarName("avatar2")==null){
			avatarRepository.save(avatar2);
		};

		avatar3.setAvatarId("sY95Ztuu");
		avatar3.setAvatarName("avatar3");
		avatar3.setAvatarPrice(1);
		avatar3.setAvatarURL("avatar3.jpg");
		if(avatarRepository.findByAvatarName("avatar3")==null){
			avatarRepository.save(avatar3);
		};

		avatar4.setAvatarId("Gqh2H658");
		avatar4.setAvatarName("avatar4");
		avatar4.setAvatarPrice(1);
		avatar4.setAvatarURL("avatar4.jpg");
		if(avatarRepository.findByAvatarName("avatar4")==null){
			avatarRepository.save(avatar4);
		};




		AuthorityEntity readAuthority=createAuthority("READ_AUTHORITY");
		AuthorityEntity writeAuthority=createAuthority("WRITE_AUTHORITY");
		AuthorityEntity deleteAuthority=createAuthority("DELETE_AUTHORITY");
	
		RoleEntity roleUser=createRole(Roles.ROLE_ADMIN.name(), Arrays.asList(readAuthority,writeAuthority));
		RoleEntity roleAdmin=createRole(Roles.ROLE_USER.name(), Arrays.asList(readAuthority,writeAuthority,deleteAuthority));
		
		if(roleAdmin==null) return;
		
		if(userRepository.findByEmail("fortest2@test.com")!=null) return;
		UserEntity adminUser=new UserEntity();
		adminUser.setFirstName("batuhan2");
		adminUser.setLastName("aydoğdu2");
		adminUser.setEmail("fortest2@test.com");
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
