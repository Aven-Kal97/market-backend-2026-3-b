package mx.edu.tecdesoftware.market_backend_2026_3_b.persistence;

import mx.edu.tecdesoftware.market_backend_2026_3_b.domain.Purchase;
import mx.edu.tecdesoftware.market_backend_2026_3_b.domain.repository.PurchaseRepository;
import mx.edu.tecdesoftware.market_backend_2026_3_b.persistence.crud.CompraCrudRepository;
import mx.edu.tecdesoftware.market_backend_2026_3_b.persistence.entity.Compra;
import mx.edu.tecdesoftware.market_backend_2026_3_b.persistence.mapper.PurchaseMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    private final CompraCrudRepository compraCrudRepository;
    private final PurchaseMapper purchaseMapper;

    public CompraRepository(
            CompraCrudRepository compraCrudRepository,
            PurchaseMapper purchaseMapper
    ) {
        this.compraCrudRepository = compraCrudRepository;
        this.purchaseMapper = purchaseMapper;
    }

    @Override
    public List<Purchase> getAll() {
        List<Compra> compras = new ArrayList<>();
        compraCrudRepository.findAll().forEach(compras::add);

        return purchaseMapper.toPurchases(compras);
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        List<Compra> compras =
                compraCrudRepository.findByIdCliente(clientId);

        if (compras.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(
                purchaseMapper.toPurchases(compras)
        );
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = purchaseMapper.toCompra(purchase);

        if (compra.getCompraProducto() != null) {
            compra.getCompraProducto().forEach(
                    item -> item.setCompra(compra)
            );
        }

        Compra compraGuardada =
                compraCrudRepository.save(compra);

        return purchaseMapper.toPurchase(compraGuardada);
    }
}
