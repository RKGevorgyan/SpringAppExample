package ru.stc.springbootdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stc.springbootdemo.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
