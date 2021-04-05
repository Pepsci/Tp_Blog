package article;

public class Article {

	private int id;
	private String titre;
	private String article;
	private String resume;
	
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Article(String titre, String article, String resume) {
		super();
		id++;
		this.titre = titre;
		this.article = article;
		this.resume = resume;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}
	
	
	
}
