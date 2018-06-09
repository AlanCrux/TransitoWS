package servicios;

import gateway.sms.JaxSms;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import modelo.mybatis.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import servicios.pojos.Conductor;
import servicios.pojos.RespuestaEmailSMS;

/**
 * REST Web Service
 *
 * @author Alan Yoset Garcia Cruz
 */
@Path("generic")
public class TransitoWS {

    @Context
    private UriInfo context;

    public TransitoWS() {
    }

    @POST
    @Path("autenticarusuario")
    @Produces(MediaType.APPLICATION_JSON)
    public Conductor autenticarUsuario(
            @FormParam("celular") String celular,
            @FormParam("clave") String clave
    ) {
        SqlSession conn = null;
        Conductor conductor = new Conductor();
        conductor.setCelular(celular);
        conductor.setClave(clave);
        try {
            conn = MyBatisUtils.getSession();
            conductor = conn.selectOne("Conductor.autenticarConductor", conductor);
        } catch (IOException ex) {
            Logger.getLogger(TransitoWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conductor;
    }

    @POST
    @Path("Enviar")
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaEmailSMS enviarSMS(
            @FormParam("numero") String numero,
            @FormParam("mensaje") String mensaje
    ) {
        RespuestaEmailSMS res = new RespuestaEmailSMS();
        JaxSms jax = new JaxSms();
        String respuesta = jax.enviar(numero, mensaje);
        res.setSmscode(respuesta);
        return res;
    }
}
