package servicios;

import gateway.sms.JaxSms;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import modelo.mybatis.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import servicios.pojos.Conductor;
import servicios.pojos.Reporte;
import servicios.pojos.RespuestaEmailSMS;
import servicios.pojos.Vehiculo;

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

    @POST
    @Path("registrarusuario")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean registrarUsuario(
            @FormParam("numLicencia") String numLicencia,
            @FormParam("nombre") String nombre,
            @FormParam("fechaNacimiento") Date fechaNacimiento,
            @FormParam("celular") String celular,
            @FormParam("clave") String clave,
            @FormParam("verificado") boolean verificado
    ) {
        SqlSession conn = null;
        Conductor conductor = new Conductor();
        conductor.setNumLicencia(numLicencia);
        conductor.setNombre(nombre);
        conductor.setFechaNacimiento(fechaNacimiento);
        conductor.setCelular(celular);
        conductor.setClave(clave);
        conductor.setVerificado(verificado);
        try {
            conn = MyBatisUtils.getSession();
            conductor = conn.selectOne("Conductor.insertarConductor", conductor);
        } catch (IOException ex) {
            return false;
        }
        return true;
    }

    @POST
    @Path("registrarvehiculo")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean registrarVehiculo(
            @FormParam("placas") String placas,
            @FormParam("anio") Date anio,
            @FormParam("color") String color,
            @FormParam("numPoliza") String numPoliza,
            @FormParam("idAseguradora") int idAseguradora,
            @FormParam("numLicencia") String numLicencia,
            @FormParam("idModelo") int idModelo
    ) {
        SqlSession conn = null;
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setAnio(anio);
        vehiculo.setColor(color);
        vehiculo.setIdAseguradora(idAseguradora);
        vehiculo.setIdModelo(idModelo);
        vehiculo.setNumLicencia(numLicencia);
        vehiculo.setNumPoliza(numPoliza);
        vehiculo.setPlacas(placas);

        try {
            conn = MyBatisUtils.getSession();
            vehiculo = conn.selectOne("Vehiculo.insertarVehiculo", vehiculo);
        } catch (IOException ex) {
            return false;
        }
        return true;
    }

    @GET
    @Path("obtenerreportes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reporte> obtenerReportes() {
        List<Reporte> reportes = new ArrayList<Reporte>();
        SqlSession conn = null;
         try {
            conn = MyBatisUtils.getSession();
            reportes = conn.selectOne("Reporte.obtenerReportes");
        } catch (IOException ex) {
            
        }
        return reportes;
    }
    
    @POST
    @Path("actualizarusuario")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean actualizarUsuario(
            @FormParam("numLicencia") String numLicencia,
            @FormParam("nombre") String nombre,
            @FormParam("fechaNacimiento") Date fechaNacimiento,
            @FormParam("celular") String celular,
            @FormParam("clave") String clave,
            @FormParam("verificado") boolean verificado
    ) {
        SqlSession conn = null;
        Conductor conductor = new Conductor();
        conductor.setNumLicencia(numLicencia);
        conductor.setNombre(nombre);
        conductor.setFechaNacimiento(fechaNacimiento);
        conductor.setCelular(celular);
        conductor.setClave(clave);
        conductor.setVerificado(verificado);
        try {
            conn = MyBatisUtils.getSession();
            conductor = conn.selectOne("Conductor.insertarConductor", conductor);
        } catch (IOException ex) {
            return false;
        }
        return true;
    }
}
