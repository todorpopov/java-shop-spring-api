package shop.project.shops;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends CrudRepository<Shop, Long> {
    Iterable<Shop> findOneByName(String name);
    Boolean existsByName(String name);
}
