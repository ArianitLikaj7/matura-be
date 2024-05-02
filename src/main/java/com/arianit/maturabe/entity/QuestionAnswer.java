package com.arianit.maturabe.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "questions_answers")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class QuestionAnswer extends BaseEntity{

    @Column(name = "subject_id")
    private Long subjectId;

    @ManyToOne
    @JoinColumn(name = "subject_id", insertable = false, updatable = false)
    @JsonBackReference
    private Subject subject;

    @Column(name = "question")
    private String [] question;

    @Column(name = "answer")
    private String answer;

    @Column(name = "url_of_photo")
    private String urlOfPhoto;

}
