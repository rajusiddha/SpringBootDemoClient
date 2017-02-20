package com.nisum.services;

import com.nisum.domain.UserRole;

public interface UserRoleService {

	UserRole findUserByRole(UserRole role);
}
