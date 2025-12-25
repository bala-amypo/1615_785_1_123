package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.*;


@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SkillCategory {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Column(unique = true)
private String categoryName;


private String description;
private Boolean active = true;


}package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class SkillCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private boolean active = true;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean getActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
