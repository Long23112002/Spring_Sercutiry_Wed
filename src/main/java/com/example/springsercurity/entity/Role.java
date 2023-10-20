package com.example.springsercurity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "Roles")
public class Role {
    @Id
    @SequenceGenerator(
        name = "roles_sequence",
        sequenceName = "roles_sequence",
        allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO , generator = "roles_sequence")
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    @Fetch(value = FetchMode.SELECT)
    @JsonIgnore
    private Set<User> users = new HashSet<>();

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Role( String name) {
        this.name = name;
    }
}
