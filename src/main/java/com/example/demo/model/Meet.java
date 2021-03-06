package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "Meet")
public class Meet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true, name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private State state;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_bet", referencedColumnName = "id")
    private Bet bet;

    @OneToMany(fetch = FetchType.EAGER)//, mappedBy="meet"
    private Set<User> users = new HashSet<>();

    public Meet() {
    }

    public Set<User> getUsers() {
        return users;
    }


    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
