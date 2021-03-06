package groupProject.wordsearch;

import org.json.JSONArray;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class ApiThread extends Thread {

	private String category;
	private String[] words;
	private WordSearch search;
	private WordSearchGUI wordSearchGUI;

	public ApiThread(String category, WordSearchGUI gui) {
		this.category = category;
		this.wordSearchGUI = gui;
	}

	@Override
	public void run() {
		HttpResponse<JsonNode> response = null;
		try {

			response = Unirest
					.get("https://twinword-word-associations-v1.p.mashape.com/associations/?entry="
							+ category)
							.header("X-Mashape-Key",
									"lpakBIxMs9mshIh7tb98Xb1iRzDOp1iwtzyjsnqvjWeOEpAL4M")
									.asJson();
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		JSONArray array = response.getBody().getObject()
				.getJSONArray("associations_array");
		words = new String[15];
		for (int i = 0; i < 15; i++) {
			words[i] = array.getString(i).toString();

		}
		search = new WordSearch(words);
		wordSearchGUI.getGamePanel().setGame(words, search.getGrid());
		wordSearchGUI.getCategoryPanel().setVisible(false);
		wordSearchGUI.getCardLayout().show(wordSearchGUI.getCard(), "Game");
	}

	public String[] getWords() {
		return words;
	}

	public WordSearch getWordSearch() {
		return search;
	}

}
