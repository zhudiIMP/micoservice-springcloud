package org.imp.cloud.micoserviceprovideruser.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.imp.cloud.micoserviceprovideruser.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
