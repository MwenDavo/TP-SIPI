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
        Session session = Session.getDefaultInstance(props, null);
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("studymentorSIPI@gmail.com"));
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(usuario.getCorreoElectronico(), usuario.getNombreUsuario()));
            msg.setSubject("Olvido de contraseña.");
            msg.setText("Se te otorgará una contraseña provisoria, usala junto con tu nombre de usuario para ingresar a tu cuenta y actualizar tu contraseña./n" +
                    "La contraseña provisoria es:" + contraseñaProvisoria);
            Transport.send(msg);
        } catch (AddressException e) {
            // ...
        } catch (MessagingException e) {
            // ...
        } catch (UnsupportedEncodingException e) {
            // ...
        }
    }
}
