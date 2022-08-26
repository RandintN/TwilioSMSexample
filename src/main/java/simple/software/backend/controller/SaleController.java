package simple.software.backend.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import simple.software.backend.SaleRepository;
import simple.software.backend.entities.Sale;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/sales")
public class SaleController {

  private final SaleRepository saleRepository;

  @GetMapping
  public List<Sale> findSales(){
    return saleRepository.findAll();
  }
}
