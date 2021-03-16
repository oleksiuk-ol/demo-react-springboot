package com.example.demoreactspringboot.dao;

import com.example.demoreactspringboot.entity.TodoTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoTaskDao extends JpaRepository<TodoTask, Long> {
}
