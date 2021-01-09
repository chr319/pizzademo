package com.ccccccc.pizzademo.data;

import com.ccccccc.pizzademo.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserName(String userName);
}
