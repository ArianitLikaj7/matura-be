package com.arianit.maturabe.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Table(name = "subjects")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Subject extends BaseEntity {

    @Column(name = "name_of_subject", unique = true)
    private String nameOfSubject;

    @OneToMany(mappedBy = "subject")
    @JsonManagedReference
    private List<QuestionAnswer> questionAnswerList;

}
