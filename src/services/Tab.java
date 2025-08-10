package services;

public class Tab {

	private String currentUrl;
	private String title;

	public Tab() {
		this.currentUrl = "about:blank";
		this.title = "New tab";
	}

	public void navigateTo(String url) {
		System.out.println("In the tab '" + title + "', navigating to: " + url);
		this.currentUrl = url;
		this.title = "Page of " + url;
	}

	public String getCurrentUrl() {
		return currentUrl;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return "Tab [Title=" + title + ", URL=" + currentUrl + "]";
	}

}
