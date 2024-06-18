package com.bosch.realstatemanager.repositories;

import com.bosch.realstatemanager.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findById(long id);
}
