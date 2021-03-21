package com.rickie.repository;

import com.rickie.domain.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByName(String name);
    User findByNameOrEmail(String name, String email);
    @Query("select u from User u where u.name like %?1%")
    User findByNameLike(String name);
    @Transactional
    @Modifying
    @Query("update User u set u.name=?1 where u.id=?2")
    int modifyById(String name, Long id);

    List<User> findByEmail(String email);
}
