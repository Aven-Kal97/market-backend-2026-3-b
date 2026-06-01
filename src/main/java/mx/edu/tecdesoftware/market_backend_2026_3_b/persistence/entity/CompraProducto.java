package mx.edu.tecdesoftware.market_backend_2026_3_b.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "compras_productos")
public class CompraProducto {
    @Id

    @EmbeddedId
    private CompraProductoPK id;

    private Integer cantidad;
    private double total;
    private Boolean estado;

    //Quiero saber los productos que hay en una compra

    //Unir la tabla de compras
    @ManyToOne
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;


}
