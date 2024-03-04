package utils.dto;

public class Registrer_DTO {
    
    protected String name;
   protected String pss;
    

    public Registrer_DTO(String name, String pss) {
        this.name = name;
        this.pss=pss;
        
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
    