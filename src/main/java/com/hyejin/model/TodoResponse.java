package com.hyejin.model;

// 요청에 응답하기 위해 필요한 클래스
// 응답할 때 Entity 의 모든 값을 정의해 주어야 하기 때문에
// 기본 생성자를 이용해서 각 컬럼에 받는다.
// 요청을 편하게 처리하기 위해 TodoEntity 를 파라메터로 받는다.

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TodoResponse {

    private Long id;
    private String title;
    private Long order;
    private Boolean completed;
    private String url;

    public TodoResponse(TodoEntity todoEntry) {
        this.id = todoEntry.getId();
        this.title = todoEntry.getTitle();
        this.order = todoEntry.getOrder();
        this.completed = todoEntry.getCompleted();

        this.url = "http://loaclhost:8888/" + this.id;
    }
}
