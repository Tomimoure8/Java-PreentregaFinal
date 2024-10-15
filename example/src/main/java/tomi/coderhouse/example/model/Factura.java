package tomi.coderhouse.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import tomi.coderhouse.example.entity.DetalleFactura;
import tomi.coderhouse.example.entity.Product;
import java.util.Date;
import java.util.List;

@Entity
public class Factura {
    private Long id;
    private Date fecha;
    private List<Product> productos;
    private Double total;

    @OneToMany(mappedBy = "factura")
    private List<DetalleFactura> detallesFactura;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public
    List<Product> getProductos() {
        return productos;
    }

    public void setProductos(List<Product> productos) {
        this.productos = productos;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total
 = total;
    }
}

