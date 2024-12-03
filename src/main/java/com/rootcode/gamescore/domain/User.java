package com.rootcode.gamescore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Entity(name = "gameuser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String email;

    @ManyToOne
    @JoinColumn(name = "game_id")
    @JsonIgnore
    private Game game;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Score> scoreList;

}
