package com.impostors.app.ws.storyreadingtrackerws.service.impl;

import com.impostors.app.ws.storyreadingtrackerws.io.entity.RoleEntity;
import com.impostors.app.ws.storyreadingtrackerws.io.entity.UserEntity;
import com.impostors.app.ws.storyreadingtrackerws.io.repository.mysql.RoleRepository;
import com.impostors.app.ws.storyreadingtrackerws.io.repository.mysql.UserRepository;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.RoleDto;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.UserDto;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.management.relation.Role;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userService;


    @Mock
    UserRepository userRepository;

    @Mock
    Utils utils;

    @Mock
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Mock
    RoleRepository roleRepository;

    String userId="wedd2d23d32";
    String encyreptedPassword="be12e12e21e21";
    UserEntity userEntity;

    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        userEntity=new UserEntity();
        userEntity.setId(1L);
        userEntity.setFirstName("batuhan");
        userEntity.setUserId(userId);
        userEntity.setEncryptedPassword(encyreptedPassword);
        userEntity.setGender("Male");
        userEntity.setEmail("fortest@test.com");
        userEntity.setEmailVerificationToken("qewqwewqewq");
    }

    @Test
    final void testGetUser(){

        when(userRepository.findByEmail(anyString())).thenReturn(userEntity);
        UserDto userDto=userService.getUser("fortest2@test.com");

        assertNotNull(userDto);
        assertEquals("batuhan",userDto.getFirstName());

    }
    @Test()
    final void testGetUser_UsernameNotFoundException(){
        when(userRepository.findByEmail(anyString())).thenReturn(null);
        assertThrows(UsernameNotFoundException.class,
                ()->{
            userService.getUser("test@test.com");
                }
                );
    }
    @Test()
    final void testCreateUser_RunTimeException(){
        when(userRepository.findByEmail(anyString())).thenReturn(userEntity);
        UserDto userDto=new UserDto();
        userDto.setPassword("123");
        userDto.setFirstName("batuhan");
        userDto.setEmail("fortest2@test.com");

        assertThrows(RuntimeException.class,
                ()->{
                    userService.createUser(userDto);
                }
        );
    }
    @Test
    final void testCreateUser(){
        RoleEntity roleEntity=new RoleEntity();
        when(userRepository.findByEmail(anyString())).thenReturn(null);
        when(utils.generateUserId(anyInt())).thenReturn(userId);
        when(roleRepository.findByName(anyString())).thenReturn(roleEntity);
        when(bCryptPasswordEncoder.encode(anyString())).thenReturn(encyreptedPassword);

        when(userRepository.save(any(UserEntity.class))).thenReturn(userEntity);

        Collection<String> roleDtoList=new ArrayList<>();
        roleDtoList.add("ADMIN");
        roleDtoList.add("USER");

        UserDto userDto=new UserDto();
        userDto.setPassword("123");
        userDto.setFirstName("batuhan");
        userDto.setEmail("fortest2@test.com");

        userDto.setRoles(roleDtoList);
        UserDto storedUserDetails=userService.createUser(userDto);

        assertNotNull(storedUserDetails);
        assertEquals(userEntity.getFirstName(),storedUserDetails.getFirstName());
        assertEquals(userEntity.getLastName(),storedUserDetails.getLastName());
        assertNotNull(storedUserDetails.getUserId());
       // assertEquals(storedUserDetails.getRoles().size(),userEntity.getRoles().size());
        verify(bCryptPasswordEncoder,times(1)).encode("123");
        verify(userRepository,times(1)).save(any(UserEntity.class));
    }

}
