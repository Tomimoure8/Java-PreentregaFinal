package tomi.coderhouse.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")

public class Product {



    public Product() {}



    public Product(double price, String name) {

        this.price = price;

        this.name = name;

    }



    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;



    @Column

    private String name;



    @Column

    private double price;



    public Long getId() {

        return id;

    }



    public void setId(Long id) {

        this.id = id;

    }



    public String getName() {

        return name;

    }



    public void setName(String name) {

        this.name = name;

    }



    public double getPrice() {

        return price;

    }



    public void setPrice(double price) {

        this.price = price;

    }

    @Column
    private int cantidad;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;

    }

}
