package com.InnovativeSolutions.project.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RealTimeDevelopement")
public class RealTimeDevelopment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long development_id ;

    @Column(nullable = false)
    private String topic ;

    @Column(nullable = false)
    private String requirement;

    @Column(nullable = false)
    private Long phone;

    @Column(nullable = false)
    private String email ;

    @Column(nullable = false)
    private Long whatsappNo ;

    @Column(nullable = false)
    private Long budget ;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category ;






}
