package com.example.demo.models;

import lombok.*;

import javax.persistence.*;

@Data @AllArgsConstructor @NoArgsConstructor
@Getter @Setter @EqualsAndHashCode(of = "id")
@Entity @Table(name = "emp")
public class Employee {
    private static final long serialVersion = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empno;

    private String ename;

    @ManyToOne(targetEntity = Team.class, cascade = CascadeType.ALL)
    @JoinColumn(name="team_id")
    private Team team;

    private Integer sal;
}
