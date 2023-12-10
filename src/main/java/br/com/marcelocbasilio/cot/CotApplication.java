package br.com.marcelocbasilio.cot;

import br.com.marcelocbasilio.cot.entities.Order;
import br.com.marcelocbasilio.cot.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class CotApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;
	public static void main(String[] args) {
		SpringApplication.run(CotApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Código: ");
		int code = sc.nextInt();
		System.out.print("Valor: ");
		double basic = sc.nextDouble();
		System.out.print("Desconto: ");
		double discount = sc.nextDouble();

		Order order = new Order(code, basic, discount);
		System.out.printf("%nPedido código %d%nValor total: R$ %.2f%n", order.getCode(), orderService.total(order));

		sc.close();
	}
}
