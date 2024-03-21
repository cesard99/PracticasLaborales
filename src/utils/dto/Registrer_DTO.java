package utils.dto;

public class Registrer_DTO {
    protected int id;
    protected String name;
    protected String pss;
    

    public Registrer_DTO(String name, String pss,int id) {
		this.id = id;
        this.name = name;
        this.pss=pss;
        
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPss() {
		return pss;
	}


	public void setPss(String pss) {
		this.pss = pss;
	}
}
    