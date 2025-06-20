package com.tec.api_candidatura.service.impl;

import com.tec.api_candidatura.entity.User;
import com.tec.api_candidatura.repository.UserRepository;
import com.tec.api_candidatura.service.UserService;
import com.tec.api_candidatura.web.dto.request.UpdateUserDto;
import com.tec.api_candidatura.web.dto.response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDto updateUser(UUID id, UpdateUserDto dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // user.setName(dto.getName());
        user.setEmail(dto.email());
        // user.setRole(dto.getRole());

        userRepository.save(user);
        return toDto(user);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private UserResponseDto toDto(User user) {
        return new UserResponseDto(
                user.getUsername(),
                user.getEmail(),
                user.getRole());
    }
}
