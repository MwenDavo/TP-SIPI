package ar.edu.uade.sipi.servicios;

import ar.edu.uade.sipi.modelo.entidades.Usuario;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

@Service
public class ServicioCorreo implements IServicioCorreo {
    @Override
    public void enviarCorreoContraseñaProvisoria(Usuario usuario, String contraseñaProvisoria) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.setProperty("mail.smtp.starttls", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.user", "matiasfelau@gmail.com");
        props.setProperty("mail.smtp.ssl.protocol", "TLSv1.2");
        props.setProperty("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props, null);
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("matiasfelau@gmail.com"));
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(usuario.getCorreoElectronico(), usuario.getNombreUsuario()));
            msg.setSubject("Olvido de contraseña.");
            msg.setText("Se te otorgará una contraseña provisoria, usala junto con tu nombre de usuario para ingresar a tu cuenta y actualizar tu contraseña./n" +
                    "La contraseña provisoria es:" + contraseñaProvisoria);
            Transport transport = session.getTransport("smtp");
            transport.connect("matiasfelau@gmail.com", "efrp vimx mwyc mxvd");
            transport.sendMessage(msg, msg.getRecipients(Message.RecipientType.TO));
            transport.close();
        } catch (AddressException e) {
            // ...
        } catch (MessagingException e) {
            // ...
        } catch (UnsupportedEncodingException e) {
            // ...
        }
    }
}
