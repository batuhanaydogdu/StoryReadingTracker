package com.impostors.app.ws.storyreadingtrackerws.service.impl;

import com.impostors.app.ws.storyreadingtrackerws.io.entity.RoleEntity;
import com.impostors.app.ws.storyreadingtrackerws.io.entity.UserEntity;
import com.impostors.app.ws.storyreadingtrackerws.io.repository.RoleRepository;
import com.impostors.app.ws.storyreadingtrackerws.io.repository.UserRepository;
import com.impostors.app.ws.storyreadingtrackerws.security.UserPrincipal;
import com.impostors.app.ws.storyreadingtrackerws.service.UserService;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.UserDto;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    RoleRepository roleRepository;



    @Override
    public UserDto getUser(String email) {
        UserEntity userEntity=userRepository.findByEmail(email);
        if(userEntity==null) throw new UsernameNotFoundException(email);

        UserDto returnValue=new UserDto();
        BeanUtils.copyProperties(userEntity, returnValue);

        return returnValue;
    }

    @Override
    public UserDto createUser(UserDto user) {
        //UserEntity deneme=userRepository.findByEmail(user.getEmail());
        if(userRepository.findByEmail(user.getEmail())!=null)
        {
            throw new RuntimeException("Record already exists.");
        }



        //UserEntity userEntity=new UserEntity();
        //BeanUtils.copyProperties(user, userEntity);
        ModelMapper modelMapper=new ModelMapper();
        UserEntity userEntity=modelMapper.map(user, UserEntity.class);



        String publicUserId=utils.generateUserId(30);
        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userEntity.setUserId(publicUserId);


        userEntity.setEmailVerificationStatus(false);


        //set roles
        Collection<RoleEntity> roleEntities=new HashSet<>();
        for(String role: user.getRoles()) {
            RoleEntity roleEntity=roleRepository.findByName(role);
            if(roleEntity!=null) {
                roleEntities.add(roleEntity);
            }

        }
        userEntity.setRoles(roleEntities);

        UserEntity storedUserDetails= userRepository.save(userEntity);

        //UserDto returnValue=new UserDto();
        //BeanUtils.copyProperties(storedUserDetails, returnValue);
        UserDto returnValue=modelMapper.map(storedUserDetails, UserDto.class);
        //Send email
        //new AmazonSES().verifyEmail(returnValue);


        return returnValue;
    }

    @Override
    public UserDto getUserByEmail(String email) {

        if(userRepository.findByEmail(email)==null)
        {
            throw new RuntimeException("Record not exists.");
        }

        UserEntity userEntity=userRepository.findByEmail(email);

        ModelMapper modelMapper=new ModelMapper();

        UserDto returnValue=modelMapper.map(userEntity,UserDto.class);





        return returnValue;
    }

    @Override
    public UserDto getCurrentUser() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }


        UserEntity userEntity=userRepository.findByEmail(username);
        if(userEntity==null) throw new UsernameNotFoundException(username);

        UserDto returnValue=new UserDto();
        BeanUtils.copyProperties(userEntity, returnValue);

        return returnValue;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity=userRepository.findByEmail(email);
        if(userEntity==null) throw new UsernameNotFoundException(email);

        return new UserPrincipal(userEntity);
    }
}
