package dto;

public class Commerciale extends User{

	
	public Commerciale() {
		super();
		
	}

	public Commerciale(String login, String pwd, String nom, String prenom, String role) {
		super(login, pwd, nom, prenom, role);
		
	}
	
	public String getRole(){
		return "Commerciale";
	}
	

}
