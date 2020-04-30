
package com.test.mytest.repository;


import com.test.mytest.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author augustobatz
 */
public interface UsersRepository extends JpaRepository<Users, Integer> {
}
