package com.hyejin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본 키 생성을 데이터베이스에 위임
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "todoOrder", nullable = false)
    private Long order;

    @Column(nullable = false)
    private Boolean completed;
}

// DB 와 DATA 를 주고 받기 위한 클래스
// 어노테이션을 이용해서 기본키 값, Null 허용 여부를 설정.
// order 는 DB 에서 예약어로 쓰기이 때문에 앞에 todoOrder 로 작성.