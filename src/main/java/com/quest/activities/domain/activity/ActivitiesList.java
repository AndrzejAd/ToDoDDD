package com.quest.activities.domain.activity;

import com.ddd.common.annotations.AggregateRoot;
import com.ddd.common.domain.AbstractEntity;
import com.ddd.common.validation.Contract;
import com.quest.activities.domain.user.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;


@AggregateRoot
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ActivitiesList extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    @Getter
    private User user;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "activitiesList")
    private List<Activity> activities = new ArrayList<>();

    public ActivitiesList(User user) {
        super();
        this.user = user;
    }

    public void addActivity(Activity activity){
        Contract.notNull(activity);
        activities.add(activity);
    }

    public List<Activity> getActivities() {
        return Collections.unmodifiableList(activities);
    }

    public double getTotalExperienceForThisList(){
        return activities
                .stream()
                .mapToDouble(Activity::getAward)
                .sum();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActivitiesList)) return false;
        ActivitiesList that = (ActivitiesList) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public String toString() {
        return "ActivitiesList{" +
                ", userID=" + user.getId() +
                ", activities=" + activities +
                '}';
    }
}