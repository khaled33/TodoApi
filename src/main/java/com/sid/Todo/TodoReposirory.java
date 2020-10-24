package com.sid.Todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TodoReposirory extends JpaRepository<Todo,Long> {
    int countByStatus(String name);
}
