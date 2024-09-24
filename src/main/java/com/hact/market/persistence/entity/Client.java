package com.hact.market.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 * The Client class represents a client entity in the database.
 */
@Entity
@Table(name = "clientes", schema = "market")
@Getter
@Setter
public class Client {
    /**
     * The unique ID of the client.
     */
    @Id
    @Column(name = "id")
    private String idClient;

    /**
     * The name of the client.
     */
    @Column(name = "nombre")
    private String name;

    /**
     * The last name of the client.
     */
    @Column(name = "apellidos")
    private String lastName;

    /**
     * The phone number of the client.
     */
    @Column(name = "celular")
    private String phone;

    /**
     * The address of the client.
     */
    @Column(name = "direccion")
    private String address;

    /**
     * The email of the client.
     */
    @Column(name = "correo_electronico")
    private String email;

    /**
     * The purchases associated with the client.
     */
    @OneToMany(mappedBy = "client")
    private List<Purchase> purchases;
}
