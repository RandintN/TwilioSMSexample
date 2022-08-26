package simple.software.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import simple.software.backend.entities.Sale;
import simple.software.backend.service.SaleService;
import simple.software.backend.service.SmsService;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/sales")
public class SaleController {

  private final SaleService saleService;
  private final SmsService smsService;

  @GetMapping
  public Page<Sale> findSales(@RequestParam(value = "minDate", defaultValue = "") String minDate,
                              @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
                              Pageable pageable) {

    return saleService.findSales(minDate, maxDate, pageable);
  }


  @GetMapping(path = "/{id}/notification")
  public void notifySms(@PathVariable Long id){
    smsService.sendSms(id);
  }
}
