package simple.software.backend.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import simple.software.backend.SaleRepository;
import simple.software.backend.entities.Sale;

@Service
@RequiredArgsConstructor
public class SaleService {

  private final SaleRepository saleRepository;

  @Transactional(readOnly = true)
  public List<Sale> findSales(){
    return saleRepository.findAll();
  }

}
