package com.fastcode.aaaloc.domain.core.filmactor;

import javax.persistence.*;
import java.time.*;
import com.fastcode.aaaloc.domain.core.film.FilmEntity;
import com.fastcode.aaaloc.domain.core.actor.ActorEntity;
import com.fastcode.aaaloc.domain.core.abstractentity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "film_actor")
@IdClass(FilmActorId.class)
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class FilmActorEntity extends AbstractEntity {

    @Id
    @EqualsAndHashCode.Include()
    @Column(name = "actor_id", nullable = false)
    private Short actorId;
    
    @Id
    @EqualsAndHashCode.Include()
    @Column(name = "film_id", nullable = false)
    private Short filmId;
    
    @Basic
    @Column(name = "last_update", nullable = true)
    private LocalDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name = "actor_id", insertable=false, updatable=false)
    private ActorEntity actor;

    @ManyToOne
    @JoinColumn(name = "film_id", insertable=false, updatable=false)
    private FilmEntity film;


}



