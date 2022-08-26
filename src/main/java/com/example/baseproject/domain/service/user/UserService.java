package com.example.baseproject.domain.service.user;

import com.example.baseproject.domain.controller.user.dto.request.UserRequest;
import com.example.baseproject.domain.controller.user.dto.response.MessageResponse;

public interface UserService {

    MessageResponse join(UserRequest request);

    MessageResponse editMember(UserRequest request);
}
