package com.hyejin.repository;

import com.hyejin.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
}

// jap 레포지토리를 상속받고,
// 제네릭 타입으로 TodoEntity 를 해당 객체의 Id 인 Long 타입으로 정의.
