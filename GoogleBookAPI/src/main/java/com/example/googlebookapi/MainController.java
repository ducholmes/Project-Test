package com.example.googlebookapi;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javafx.event.ActionEvent;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class MainController {
    @FXML
    private TextField bookTitle;

    @FXML
    private Label resultLabel;

    private final String url = "https://www.googleapis.com/books/v1/volumes?q=";
    private String apiKey = "&key=" + "AIzaSyAeciFGOihXTUDUn4_Z4l1SbYQ6TVU3tqE";

    @FXML
    public void getBookData(ActionEvent event) {
        try {
            JSONObject book = getBookInformation();
            if (book != null) {
                String title = (String) book.get("title");
                JSONArray authorsArray = (JSONArray) book.get("authors");
                String authors = authorsArray != null ? String.join(", ", authorsArray) : "Unknown";
                resultLabel.setText("Title: " + title + "\nAuthor(s): " + authors);
            } else {
                resultLabel.setText("No book found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultLabel.setText("Error fetching book data.");
        }
    }

    public JSONObject getBookInformation() throws MalformedURLException {
        APIConnector apiConnector = new APIConnector(url);
        String query = URLEncoder.encode(bookTitle.getText(), StandardCharsets.UTF_8) + apiKey;
        JSONObject response = apiConnector.getJSONObject(query);
        JSONArray items = (JSONArray) response.get("items"); // Lấy mảng "items" từ JSONObject
        if (items != null && !items.isEmpty()) {
            JSONObject firstBook = (JSONObject) items.get(0); // Lấy cuốn sách đầu tiên
            JSONObject volumeInfo = (JSONObject) firstBook.get("volumeInfo"); // Lấy thông tin chi tiết
            return volumeInfo;
        }
        return null; // Trả về null nếu không tìm thấy sách
    }

}
