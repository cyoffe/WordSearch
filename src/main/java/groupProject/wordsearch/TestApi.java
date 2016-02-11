package groupProject.wordsearch;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

//import HttpResponse;
//import TestApi.JsonNode;

public class TestApi {

	public static void main(String[] args) {

		HttpResponse<JsonNode> response = null;
		try {

			response = Unirest
					.get("https://twinword-word-associations-v1.p.mashape.com/associations/?entry=fruit")
					.header("X-Mashape-Key",
							"ijMTkO7tLDmshXQd8GckF53vZu0Yp17GXs8jsnu99o7YmrQMMu")
					.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JSONArray array = response.getBody().getObject()
				.getJSONArray("associations_array");
		String[] words = new String[20];
		for (int i = 0; i < 20; i++) {
			words[i] = array.getString(i).toString();
			System.out.println(words[i]);

		}
		
		WordSearch wordSearch = new WordSearch(words);
		char[][] letters = wordSearch.getGrid();
		System.out.print("|");
		for(int i = 0; i < 20; i++){
			for(int j = 0; j < 20; j++){
				System.out.print(letters[i][j]+"|");
			}
			System.out.print("\n|");
		}
	}
}
