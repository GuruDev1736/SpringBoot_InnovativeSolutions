package com.InnovativeSolutions.project.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BuyProject" , uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
public class BuyProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(nullable = false)
    private String logoUrl;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String createdBy;

    @OneToMany(mappedBy = "buyProject",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<ProjectImages> projectImages =new HashSet<>();

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String features;
    @Column(nullable = false)
    private String technology;

    @Column(nullable = false)
    private Long size;

    @Column(nullable = false)
    private Long cost;

    @Column(nullable = false)
    private String platform ;

    @Column(nullable = false)
    private Long devPhone;

    @Column(nullable = false)
    private Long devWhatsApp;

    @Column(nullable = false)
    private String devWebsite;

    @Column(nullable = false)
    private String email ;

    @OneToMany(mappedBy = "review",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<ProjectReviews> projectReviews = new HashSet<>();

}
