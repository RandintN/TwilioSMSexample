package simple.software.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import simple.software.backend.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

}
