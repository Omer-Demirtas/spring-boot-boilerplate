package com.boilerplate.service;

import com.boilerplate.domain.RefreshToken;
import com.boilerplate.domain.User;

public interface RefreshTokenService {
    String createRefreshToken(User user);

    boolean isRefreshExpired(RefreshToken token);

    RefreshToken getByUser(Long userId);
}
