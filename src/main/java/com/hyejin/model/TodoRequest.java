package com.hyejin.model;

// 요청을 받가외 위해 필요한 클래스
// private 로 정의한다.

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TodoRequest {

    private String title;
    private Long order;
    private  Boolean completed;

}
