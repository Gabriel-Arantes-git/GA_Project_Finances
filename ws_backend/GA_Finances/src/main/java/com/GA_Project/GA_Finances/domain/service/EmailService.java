package com.GA_Project.GA_Finances.domain.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender enviadorEmail;

    public EmailService(JavaMailSender enviadorEmail) {this.enviadorEmail = enviadorEmail;}

    @Async
    public void enviarTokenRecuperacao(String token,String email){
        try{
            MimeMessage mensagemHTML = enviadorEmail.createMimeMessage();

            MimeMessageHelper emailDestino = new MimeMessageHelper(mensagemHTML, true, "UTF-8");

            emailDestino.setTo(email);
            emailDestino.setSubject("Recuperação de Senha");

            String htmlContent = """
                <html>
                <body style="font-family: Arial, sans-serif; color: #333;">
                    <h2 style="color:#2c3e50;">Recuperação de Senha</h2>
                    <p>Olá,</p>
                    <p>Você solicitou a recuperação de senha.</p>
                    <p>Seu token de recuperação é:</p>
                    <h1 style="background:#f4f4f4; padding:10px; display:inline-block; border-radius:5px; color:#2c3e50;">
                        %s
                    </h1>
                    <p><b>Atenção:</b> este token expira em 5 minutos.</p>
                    <br>
                    <hr>
                    <p style="font-size:12px; color:gray;">
                        Se você não solicitou esta alteração, ignore este e-mail.
                    </p>
                </body>
                </html>
                """.formatted(token);

            emailDestino.setText(htmlContent, true);
            enviadorEmail.send(mensagemHTML);
        }catch (MessagingException e){
            throw new RuntimeException("Erro ao enviar o email",e);
        }
    }
}
