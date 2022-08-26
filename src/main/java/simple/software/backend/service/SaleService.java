package simple.software.backend.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import simple.software.backend.SaleRepository;
import simple.software.backend.entities.Sale;

@Service
@RequiredArgsConstructor
public class SaleService {

  private final SaleRepository saleRepository;

  @Transactional(readOnly = true)
  public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable){
    final var today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

    final var min = minDate.isEmpty() ? today.minusDays(365) : LocalDate.parse(minDate);
    final var max = maxDate.isBlank() ? today : LocalDate.parse(maxDate);

    return saleRepository.findSales(min, max, pageable);
  }

}
