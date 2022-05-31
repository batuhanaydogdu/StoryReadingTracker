package com.impostors.app.ws.storyreadingtrackerws.service.impl;

import com.impostors.app.ws.storyreadingtrackerws.io.entity.PasswordChangeEntity;
import com.impostors.app.ws.storyreadingtrackerws.io.entity.UserEntity;
import com.impostors.app.ws.storyreadingtrackerws.io.repository.mysql.PasswordChangeRepository;
import com.impostors.app.ws.storyreadingtrackerws.io.repository.mysql.UserRepository;
import com.impostors.app.ws.storyreadingtrackerws.service.PasswordChangeService;
import com.impostors.app.ws.storyreadingtrackerws.service.SendMail;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.PasswordChangeDto;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.Utils;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.request.PasswordChangeRequestModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PasswordChangeServiceImpl implements PasswordChangeService {

    @Autowired
    PasswordChangeRepository passwordChangeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public PasswordChangeDto createVerificationCode(String email) {
        UserEntity userEntity=userRepository.findByEmail(email);
        if(userEntity==null)
        {
            throw new RuntimeException("There is no such an email.");
        }

        String verificationCode=utils.generateVerificationCode(6);

        PasswordChangeEntity passwordChangeEntity=new PasswordChangeEntity();

        passwordChangeEntity.setUserDetails(userEntity);
        passwordChangeEntity.setCode(verificationCode);
        Date validDate=new Date();
        validDate.setMinutes(validDate.getMinutes()+5);  //validfor 5 mins
        passwordChangeEntity.setValidUntil(validDate);

        new SendMail().changePasswordCode(userEntity.getEmail(), verificationCode);

        PasswordChangeEntity passwordChangeEntityforReturn=passwordChangeRepository.save(passwordChangeEntity);

        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT); //it has to match with perfectly matching names


        PasswordChangeDto returnValue=modelMapper.map(passwordChangeEntityforReturn,PasswordChangeDto.class);
        returnValue.setEmail(email);
        return returnValue;
    }

    @Override
    public void changePassword(PasswordChangeRequestModel passwordChangeRequestModel) {
        UserEntity userEntity=userRepository.findByEmail(passwordChangeRequestModel.getEmail());
        if(userEntity==null)
        {
            throw new RuntimeException("There is no such an email.");
        }
        List<PasswordChangeEntity> passwordChangeEntityList=new ArrayList<>();

        passwordChangeEntityList=passwordChangeRepository.getAllVerificationCodes(userEntity.getId());
        Date currentDate=new Date();

        for(PasswordChangeEntity passwordChangeEntity: passwordChangeEntityList){
            if(passwordChangeEntity.getCode().equals(passwordChangeRequestModel.getVerificationCode())){
                if(passwordChangeEntity.getValidUntil().after(currentDate)){

                    userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(passwordChangeRequestModel.getNewPassword()));
                    userRepository.save(userEntity);
                    break;
                }
            }
        }






    }
}
