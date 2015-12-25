package org.katsumi.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "ROLES")
@Getter
@Setter
@EqualsAndHashCode(of = {"roleid"})
@ToString(exclude = {"accountid"})
public class Roles
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLEID")
    private Long roleid;

    @Basic
    @Column(name = "ROLENAME")
    private String rolename;

    @ManyToOne
    @JoinColumn(name = "ACCOUNTID")
    private Accounts accountid;
}
