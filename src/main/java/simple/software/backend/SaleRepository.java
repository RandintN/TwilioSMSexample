package simple.software.backend;

import java.time.LocalDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import simple.software.backend.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

  @Query(value = "SELECT obj FROM tb_sales obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.amount DESC")
  Page<Sale> findSales(LocalDate min, LocalDate max, Pageable pageable);
}
