package mx.edu.tecdesoftware.market_backend_2026_3_b.persistence.crud;

import mx.edu.tecdesoftware.market_backend_2026_3_b.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public interface ProductoCrudRepository extends CrudRepository<Producto , Integer> {


    //Obtener la lista de productos filtros por cagegorio y ordenados ascendetemente por name

    //Formato SQL
    // SELECT * FROM Categorias WHERE id_categoria = ? ORDER BY Nombre ADC

    List<Producto> findByIdCategoriaOrderByNombreAsc (int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado (int cantidad, boolean estado);


}
