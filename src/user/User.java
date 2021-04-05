package user;

public class User {

	private int id=1;
	private String nomCreate;
	private String prenomCreate;
	private String emailCreate;
	private String passewordCreate;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String nomCreate, String prenomCreate, String emailCreate, String passewordCreate) {
		super();
		this.nomCreate = nomCreate;
		this.prenomCreate = prenomCreate;
		this.emailCreate = emailCreate;
		this.passewordCreate = passewordCreate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomCreate() {
		return nomCreate;
	}

	public void setNomCreate(String nomCreate) {
		this.nomCreate = nomCreate;
	}

	public String getPrenomCreate() {
		return prenomCreate;
	}

	public void setPrenomCreate(String prenomCreate) {
		this.prenomCreate = prenomCreate;
	}

	public String getEmailCreate() {
		return emailCreate;
	}

	public void setEmailCreate(String emailCreate) {
		this.emailCreate = emailCreate;
	}

	public String getPassewordCreate() {
		return passewordCreate;
	}

	public void setPassewordCreate(String passewordCreate) {
		this.passewordCreate = passewordCreate;
	}

	
	
	
}
