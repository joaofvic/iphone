package entities.components;

import services.InternetBrowser;
import services.Tab;

public class SafariBrowser implements InternetBrowser {

	private String currentPage;

	@Override
	public void showPage(String url) {
		System.out.println("Showing the page: " + url);
		this.currentPage = url;
	}

	@Override
	public Tab addNew() {
		System.out.println("New tab added.");
		return new Tab();
	}

	@Override
	public void updatePage() {
		if (this.currentPage != null) {
			System.out.println("Updating the page: " + this.currentPage);
		} else {
			System.out.println("No pages to refresh.");
		}
	}

}
