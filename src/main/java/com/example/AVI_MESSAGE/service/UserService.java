package com.example.AVI_MESSAGE.service;

import com.example.AVI_MESSAGE.dto.*;

public interface UserService {

    UserResponse signup(SignupRequest request);

    UserResponse login(LoginRequest request);

    String forgotPassword(ForgotPasswordRequest request);

    String resetPassword(ResetPasswordRequest request);
}