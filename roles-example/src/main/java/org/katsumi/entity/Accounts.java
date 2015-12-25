package org.katsumi.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ACCOUNTS")
@Getter
@Setter
@EqualsAndHashCode(of = {"accountid"})
@ToString(exclude = {"roles"})
public class Accounts
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNTID")
    private Long accountid;

    @Basic
    @Column(name = "EMAIL")
    private String email;

    @Basic
    @Column(name = "PASSWORD")
    private String password;

    @OneToMany(mappedBy = "accountid", cascade = CascadeType.ALL)
    private List<Roles> roles;
}
