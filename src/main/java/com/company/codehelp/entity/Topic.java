package com.company.codehelp.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "TOPIC")
@Getter
@Setter
public class Topic {

    @Id
    @JmixGeneratedValue
    @Column(name = "ID",nullable = false)
    private UUID id;

    @InstanceName
    @Column(name = "name",length = 55)
    @NotNull
    private String name;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


    @Column(name = "description")
    @NotNull
    private String description;

    @Column(name = "content")
    @NotNull
    private String content;

    @JoinColumn(name = "commentators")
    @OneToMany()
    @Composition
    private List<User> commentators;
}
