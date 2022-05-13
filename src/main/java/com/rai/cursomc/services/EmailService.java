package com.rai.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.rai.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
