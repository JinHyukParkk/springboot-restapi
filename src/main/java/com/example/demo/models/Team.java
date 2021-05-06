package com.example.demo.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
@Getter @Setter @EqualsAndHashCode(of = "id")
@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teamno;

    private String teamname;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    public List<Employee> emps;

    public boolean addEmp(Employee emp) {
        if (emps == null) {
            emps = new ArrayList<>();
        }

        return this.emps.add(emp);
    }
}
