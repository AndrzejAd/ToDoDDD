package com.todo.activities.domain;

import com.ddd.common.annotations.AggregateRoot;
import com.ddd.common.domain.AbstractEntity;
import com.ddd.common.validation.Contract;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@AggregateRoot
@Entity
@AllArgsConstructor
public class Activities extends AbstractEntity {
    private long totalExperience;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "activities")
    private Set<Activity> activities = new HashSet<>();

    public Activities(long initialExperience, User user) {
        this.totalExperience = initialExperience;
        this.user = user;
    }

    public void addActivity(Activity activity){
        Contract.notNull(activity);
        activities.add(activity);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}