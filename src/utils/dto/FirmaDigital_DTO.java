package utils.dto;

public class FirmaDigital_DTO {
    protected String text;
    protected String firma;
    protected String usuario;

    

    public FirmaDigital_DTO(String text , String firma, String usuario){
        this.text=text;
        this.firma=firma;
        this.usuario=usuario;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
}
