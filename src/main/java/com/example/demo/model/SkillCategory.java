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


}