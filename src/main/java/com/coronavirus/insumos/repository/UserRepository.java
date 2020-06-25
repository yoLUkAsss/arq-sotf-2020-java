package com.coronavirus.insumos.repository;

import com.coronavirus.insumos.users.User;


public interface UserRepository extends BaseRepository<User> {

    public User findByEmail(String username);

    public User findByUsername(String username);
}
