package talgatdemostoreemail.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import talgatdemostoreemail.model.ItemOrderDto;
import talgatdemostoreemail.model.OrderDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderReceiverService {
    private EmailSenderService emailSender;

    public OrderReceiverService(EmailSenderService emailSender) {
        this.emailSender = emailSender;
    }

    @RabbitListener(queues = "talgat-demo-store-order-queue")
    public void sendEmail(OrderDto order){
        String toEmail = order.getEmail();
        String subject = "Ваш заказ на Talgat's demo store";
        List<ItemOrderDto> items = order.getItems();
        String itemsInOrder = items.stream().map(ItemOrderDto::getName)
                                .collect(Collectors.joining(System.lineSeparator()));

        String body = "Здравствуйте, " + order.getDeliveryName() + "," + System.lineSeparator() + System.lineSeparator() +
                      "Мы получили Ваш заказ и сейчас он находится в обработке." + System.lineSeparator() + System.lineSeparator() +
                      "Вы заказали:" + System.lineSeparator() + System.lineSeparator() +
                       itemsInOrder + System.lineSeparator() + System.lineSeparator() +
                       "С уважением," + System.lineSeparator() +
                       "Talgat's demo store";
        emailSender.sendEmail(toEmail, subject, body);
    }
}
