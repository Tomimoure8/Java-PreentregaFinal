package tomi.coderhouse.example.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tomi.coderhouse.example.entity.Product;
import tomi.coderhouse.example.repository.ProductoRepository;
import tomi.coderhouse.example.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

@Service
public class FacturaService {
    @Autowired
    private ProductService productoService;
    private static final Logger log = LoggerFactory.getLogger(FacturaService.class);

    public Factura crearNuevaFactura(List<Product> productos) {
        // Validaciones
        if (productos == null || productos.isEmpty()) {
            throw new IllegalArgumentException("La lista de productos no puede estar vacía");
        }

        log.info("Creando una nueva factura...");
        Factura factura = new Factura();
        factura.setFecha(new Date()); // Establece la fecha actual
        factura.setProductos(productos);
        factura.setTotal(productoService.calcularTotal(productos));
        log.info("Factura creada con éxito: {}", factura);
        return factura;
    }
}
