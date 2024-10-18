package tomi.coderhouse.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tomi.coderhouse.example.model.Factura;
import tomi.coderhouse.example.entity.Product;
import tomi.coderhouse.example.model.FacturaService;
import tomi.coderhouse.example.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductService productoService;

    @Autowired
    private FacturaService facturaService;

    @PostMapping ("/facturas")
    public ResponseEntity<Factura> crearFactura (@RequestBody List<Product> productos) {
        Factura factura = facturaService.crearNuevaFactura(productos);
        return ResponseEntity.status(HttpStatus.CREATED).body(factura);
    }

    // Obtener todos los productos
    @GetMapping("/productos")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productoService.findAll());
    }

    // Obtener un producto por ID
    @GetMapping("/productos/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear una nueva factura
    @PostMapping("/facturas")
    public ResponseEntity<Factura> createFactura(@RequestBody List<Product> productos) {
        // Lógica para crear una nueva factura
        Factura factura = new Factura();

        factura.setProductos(productos);
        factura.setTotal(productoService.calcularTotal(productos));

        return ResponseEntity.status(HttpStatus.CREATED).body(factura);
    }

    // ... otros métodos para actualizar, eliminar productos, etc.
}
