package org.epal.client_service.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    private Long id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;

}
