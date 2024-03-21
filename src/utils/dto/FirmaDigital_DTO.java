package utils.dto;

public class FirmaDigital_DTO {
    protected int id;
    protected String text;
    protected String firma;
    protected int usuario_id;
    protected String privatekey;
    protected String publickey;


    public FirmaDigital_DTO(int id ,String text , String firma, int usuario , String privateKey, String publickey){
        this.id = id;
        this.text=text;
        this.firma=firma;
        this.usuario_id=usuario;
        this.privatekey=privateKey;
        this.publickey=publickey;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public int getUsuario() {
        return usuario_id;
    }

    public void setUsuario(int usuario) {
        this.usuario_id = usuario;
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
