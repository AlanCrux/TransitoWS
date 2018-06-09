package servicios.pojos;


public class RespuestaEmailSMS {
    private String smscode; 
    private boolean emailstatus; 

    public RespuestaEmailSMS() {
    }

    public RespuestaEmailSMS(String smscode, boolean emailstatus) {
        this.smscode = smscode;
        this.emailstatus = emailstatus;
    }

    public String getSmscode() {
        return smscode;
    }

    public void setSmscode(String smscode) {
        this.smscode = smscode;
    }

    public boolean isEmailstatus() {
        return emailstatus;
    }

    public void setEmailstatus(boolean emailstatus) {
        this.emailstatus = emailstatus;
    }
    
    
}
