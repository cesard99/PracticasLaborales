package utils.dto;

public class FirmaDigital_DTO {
    protected String text;
    protected String firma;
    protected String usuario;
    protected String privatekey;
    protected String publickey;

    

   

    public FirmaDigital_DTO(String text , String firma, String usuario , String privateKey, String publickey){
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

    public String getPrivatekey() {
        return privatekey;
    }

    public void setPrivatekey(String privatekey) {
        this.privatekey = privatekey;
    }

    public String getPublickey() {
        return publickey;
    }

    public void setPublickey(String publickey) {
        this.publickey = publickey;
    }
    
}
