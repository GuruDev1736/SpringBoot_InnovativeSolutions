package com.InnovativeSolutions.project.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(
    name = "Users"
)
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(name = "name" , nullable = false)
    private String name ;

    @Column(name = "username" , nullable = false , unique = true)
    private String username ;

    @Column(name = "password" , nullable = false )
    private String password;

    @Column(name = "email" , nullable = false , unique = true)
    private String email;

    @Column(name = "PhoneNo" , nullable = false)
    private String phone;

    @Column(name = "address" , nullable = false)
    private String address;

    @Column(name = "imageurl")
    private String imageUrl;

    @ManyToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles" , joinColumns = @JoinColumn(name = "user_id" , referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id" , referencedColumnName = "id"))
    private Set<Role> roles ;



}
