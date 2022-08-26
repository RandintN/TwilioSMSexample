package simple.software.backend.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import simple.software.backend.SaleRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class SmsService {
  @Value("${twilio.sid}")
  private String twilioSid;

  @Value("${twilio.key}")
  private String twilioKey;

  @Value("${twilio.phone.from}")
  private String twilioPhoneFrom;

  @Value("${twilio.phone.to}")
  private String twilioPhoneTo;

  private final SaleRepository saleRepository;

  public void sendSms(Long saleId){
    final var sale = saleRepository.findById(saleId).orElseThrow(() -> new RuntimeException("Sale not found"));



    Twilio.init(twilioSid, twilioKey);
    final var to = new PhoneNumber(twilioPhoneTo);
    final var from = new PhoneNumber(twilioPhoneFrom);

    final var messageText = String.format("Vendedor %s comprou %s reais no dia %s",
        sale.getSellerName(), sale.getAmount(), sale.getDate());

    final var message = Message.creator(to, from, messageText).create();

    log.info(message.getSid());
    log.info(message.getPrice());
  }

}
