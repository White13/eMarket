package dto;

public class Internaute extends User{

	public Internaute() {
		super();
		
	}
	public Internaute(String login, String pwd, String nom, String prenom, String role) {
		super(login, pwd, nom, prenom, role);
		
	}
	public String getRole(){
		return "Internaute";
	}


	
		
}
		


