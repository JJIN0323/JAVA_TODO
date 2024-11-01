package com.hyejin.service;

// 여기에서는 기능을 ㅜㄱ현하기 위해 메서드 시그니처를 정의한다.
// 1. todo 리스트 목록에 아이템을 추가
// 2. todo 리스트 전체 목록을 조회
// 3. todo 리스트 목록 중 특정 아이템을 조회
// 4. todo 리스트 특정 아이템을 수정
// 5. todo 리스트 특정 아이템을 삭제
// 6. todo 리스트 전체 목옥을 삭제


import com.hyejin.model.TodoEntity;
import com.hyejin.model.TodoRequest;
import com.hyejin.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor

public class TodoService {

    private final TodoRepository todoRepository;

    // DTO 에 GETTER SETTER 는 없지만 여기서 새로 생성한다.
    // 여기서 인스턴스로 생성한다.
    public TodoEntity add(TodoRequest todoRequest) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setTitle(todoRequest.getTitle());
        todoEntity.setOrder(todoRequest.getOrder());
        todoEntity.setCompleted(todoRequest.getCompleted());
        return this.todoRepository.save(todoEntity);
    }

    public List<TodoEntity> searchAll() {
        return this.todoRepository.findAll();
    }

    public TodoEntity searchById(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "TodoEntity not found"));
    }

    public TodoEntity updateById(Long id, TodoRequest request) {
        TodoEntity todoEntity = this.searchById(id);
        if (request.getTitle() != null) {
            todoEntity.setTitle(request.getTitle());
        }
        if (request.getOrder() != null) {
            todoEntity.setOrder(request.getOrder());
        }
        if (request.getCompleted() != null) {
            todoEntity.setCompleted(request.getCompleted());
        }
        return this.todoRepository.save(todoEntity);
    }

    public void deleteById(Long id) {
        this.todoRepository.deleteById(id);
    }

    public void deleteAll() {
        this.todoRepository.deleteAll();
    }
}