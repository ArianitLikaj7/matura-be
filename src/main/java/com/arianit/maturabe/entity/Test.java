package com.arianit.maturabe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.*;
import org.hibernate.annotations.ColumnTransformer;


@Table(name = "tests")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Test extends BaseEntity {

    @Column(name = "name_of_test")
    private String nameOfTest;

    @Column(name = "number_of_test")
    private Long numberOfTest;

    @Column(name = "question_answers", columnDefinition = "json")
    @ColumnTransformer(
            read = "question_answers::json",
            write = "CAST(? AS json)"
    )
    private String questionsAnswers;

}
