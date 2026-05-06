package com.example.AVI_MESSAGE.service;

import com.example.AVI_MESSAGE.dto.*;
import com.example.AVI_MESSAGE.entity.*;
import com.example.AVI_MESSAGE.repository.*;
import com.example.AVI_MESSAGE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.AVI_MESSAGE.security.JwtService;

import java.time.LocalDateTime;
import java.util.Random;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordResetOtpRepository otpRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private org.springframework.security.crypto.password.PasswordEncoder passwordEncoder;

    // SIGNUP
    @Override
    public UserResponse signup(SignupRequest request) {

        User user = new User();
        user.setName(request.getName());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());

        // 🔐 encrypt password
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setDob(request.getDob());
        user.setGender(request.getGender());

        User saved = userRepository.save(user);

        UserResponse res = new UserResponse();
        res.setId(saved.getId());
        res.setName(saved.getName());
        res.setUsername(saved.getUsername());
        res.setEmail(saved.getEmail());

        return res;
    }

    // LOGIN (JWT GENERATED HERE)
    @Override
    public UserResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 🔐 check password
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtService.generateToken(user.getEmail());

        UserResponse res = new UserResponse();
        res.setId(user.getId());
        res.setName(user.getName());
        res.setUsername(user.getUsername());
        res.setEmail(user.getEmail());
        res.setToken(token); // 🔥 JWT returned

        return res;
    }

    // FORGOT PASSWORD
    @Override
    public String forgotPassword(ForgotPasswordRequest request) {

        String otp = String.valueOf((int)(Math.random() * 900000) + 100000);

        PasswordResetOtp resetOtp = new PasswordResetOtp();
        resetOtp.setEmail(request.getEmail());
        resetOtp.setOtp(otp);
        resetOtp.setExpiryTime(LocalDateTime.now().plusMinutes(5));

        otpRepository.save(resetOtp);

        System.out.println("OTP: " + otp);

        return "OTP sent";
    }

    // RESET PASSWORD
    @Override
    public String resetPassword(ResetPasswordRequest request) {

        PasswordResetOtp record = otpRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("OTP not found"));

        if (!record.getOtp().equals(request.getOtp())) {
            throw new RuntimeException("Invalid OTP");
        }

        if (record.getExpiryTime().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("OTP expired");
        }

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 🔐 encrypt new password
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);

        otpRepository.deleteByEmail(request.getEmail());

        return "Password updated";
    }
}