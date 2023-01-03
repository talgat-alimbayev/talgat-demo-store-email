package talgatdemostoreemail.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import talgatdemostoreemail.model.Item;
import talgatdemostoreemail.model.Order;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderReceiverService {
    private EmailSenderService emailSender;
    private ItemServices itemServices;

    public OrderReceiverService(EmailSenderService emailSender, ItemServices itemServices) {
        this.emailSender = emailSender;
        this.itemServices = itemServices;
    }

    @RabbitListener(queues = "talgat-demo-store-order-queue")
    public void sendEmail(Order order){
        String toEmail = order.getEmail();
        System.out.println(toEmail);
        String subject = "Ваш заказ на Talgat's demo store";
        List<Item> items = itemServices.getItemsById(order.getItemIds().stream().toList());
        String itemsInOrder = items.stream().map(Item::getName)
                                .collect(Collectors.joining(System.lineSeparator()));
        System.out.println(items.toString());
        System.out.println(itemsInOrder);

        String body = "Здравствуйте, " + order.getDeliveryName() + "," + System.lineSeparator() + System.lineSeparator() +
                      "Мы получили Ваш заказ и сейчас он находится в обработке." + System.lineSeparator() + System.lineSeparator() +
                      "Вы заказали:" + System.lineSeparator() + System.lineSeparator() +
                       itemsInOrder + System.lineSeparator() + System.lineSeparator() +
                       "С уважением," + System.lineSeparator() +
                       "Talgat's demo store";
        emailSender.sendEmail(toEmail, subject, body);
    }
}
