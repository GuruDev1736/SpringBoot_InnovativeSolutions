package com.InnovativeSolutions.project.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id ;

    @Column(nullable = false)
    private String category_name ;

    @Column(nullable = false)
    private String category_description;

//    @OneToMany(mappedBy = "category" , cascade = CascadeType.ALL , orphanRemoval = true)
//    private List<RealTimeDevelopment> realTimeDevelopments;

}
