package com.example.module13;

import com.example.module13.model.UserEntity;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Optional;


public class UserCrudApp {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";

    private static final Gson gson = new Gson();


    public static UserEntity createUser() {
        try {
            URL url = new URL(BASE_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String requestBody = "{\"name\":\"Tony Stark\",\"username\":\"Panda\",\"email\":\"catname235@gmail.com\",\"address\":{\"street\":\"123street\",\"suite\":\"Apt. 2\",\"city\":\"New-York\",\"zipcode\":\"874356-34\",\"geo\":{\"lat\":\"-21.455434\",\"lng\":\"5.6486\"}},\"phone\":\"1-770-736-8031 x56442\",\"website\":\"hildegard.org\",\"company\":{\"name\":\"Romaguera-Crona\",\"catchPhrase\":\"Multi-layered client-server neural-net\",\"bs\":\"harness real-time e-markets\"}}";

            try (OutputStream outputStream = connection.getOutputStream()) {
                outputStream.write(requestBody.getBytes());
                outputStream.flush();
            }

            int responseCode = connection.getResponseCode();
            if (HttpURLConnection.HTTP_CREATED == responseCode) {
                return getUserEntity(connection);
            }
            connection.disconnect();
        } catch (IOException e) {
            throw new RuntimeException("Something goes wrong");
        }
        return null;
    }


    public static UserEntity updateUser(int id) {
        try {
            URL url = new URL(BASE_URL + "/" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String requestBody = "{\"id\":2,\"name\":\"Danil\",\"username\":\"fishrock\",\"email\":\"nakau@fgg.yr\",\"address\":{\"street\":\"5667golf\",\"suite\":\"Suite 8\",\"city\":\"Dream City\",\"zipcode\":\"4569846-345345\",\"geo\":{\"lat\":\"-435.223\",\"lng\":\"-3284.999\"}},\"phone\":\"00-43243-34 y234897\",\"website\":\"anastasia.net\",\"company\":{\"name\":\"Deckow-Crist\",\"catchPhrase\":\"Proactive didactic contingency\",\"bs\":\"synergize scalable supply-chains\"}}";

            try (OutputStream outputStream = connection.getOutputStream()) {
                outputStream.write(requestBody.getBytes());
                outputStream.flush();
            }

            int responseCode = connection.getResponseCode();
            if (HttpURLConnection.HTTP_OK == responseCode) {
                return getUserEntity(connection);
            }

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static boolean deleteUser(int id) {
        try {
            URL url = new URL(BASE_URL + "/" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            int responseCode = connection.getResponseCode();
            connection.disconnect();
            return responseCode >= HttpURLConnection.HTTP_OK && responseCode < HttpURLConnection.HTTP_MULT_CHOICE;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }


    public static List<UserEntity> getUsers() {
        try {
            URL url = new URL(BASE_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (HttpURLConnection.HTTP_OK == responseCode) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    StringBuilder response = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    Type userListType = new TypeToken<List<UserEntity>>() {
                    }.getType();
                    return gson.fromJson(response.toString(), userListType);
                }
            }
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static Optional<UserEntity> getUserById(int id) {
        try {
            URL url = new URL(BASE_URL + "/" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    StringBuilder response = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    UserEntity user = gson.fromJson(response.toString(), UserEntity.class);
                    return Optional.ofNullable(user);
                }
            }

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }


    public static Optional<UserEntity> getUserByUsername(String username) {
        try {
            URL url = new URL(BASE_URL + "?username=" + username);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (HttpURLConnection.HTTP_OK == responseCode) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    StringBuilder response = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    Type userListType = new TypeToken<List<UserEntity>>() {
                    }.getType();
                    List<UserEntity> users = gson.fromJson(response.toString(), userListType);
                    if (!users.isEmpty()) {
                        return Optional.of(users.get(0));
                    }
                }
            }

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    private static UserEntity getUserEntity(HttpURLConnection connection) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            return gson.fromJson(response.toString(), UserEntity.class);
        }
    }

    public static void printOpenTasksForUser(int userId) {
        try {
            URL url = new URL(BASE_URL + "/" + userId + "/todos");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    JsonArray todosArray = JsonParser.parseReader(reader).getAsJsonArray();
                    for (JsonElement element : todosArray) {
                        JsonObject todoObject = element.getAsJsonObject();
                        boolean completed = todoObject.get("completed").getAsBoolean();
                        if (!completed) {
                            int taskId = todoObject.get("id").getAsInt();
                            String taskTitle = todoObject.get("title").getAsString();
                            System.out.println("Task ID: " + taskId);
                            System.out.println("Title: " + taskTitle);
                            System.out.println();
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getCommentsForPostAndWriteToFile(int userId, int postId) {
        try {
            URL postUrl = new URL(BASE_URL + "/" + userId + "/posts");
            HttpURLConnection postConnection = (HttpURLConnection) postUrl.openConnection();
            postConnection.setRequestMethod("GET");

            int postResponseCode = postConnection.getResponseCode();
            if (postResponseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader postReader = new BufferedReader(new InputStreamReader(postConnection.getInputStream()))) {
                    JsonArray postsArray = JsonParser.parseReader(postReader).getAsJsonArray();
                    JsonObject lastPost = postsArray.get(postsArray.size() - 1).getAsJsonObject();
                    int lastPostId = lastPost.get("id").getAsInt();

                    URL commentsUrl = new URL(BASE_URL + "/" + lastPostId + "/comments");
                    HttpURLConnection commentsConnection = (HttpURLConnection) commentsUrl.openConnection();
                    commentsConnection.setRequestMethod("GET");

                    int commentsResponseCode = commentsConnection.getResponseCode();
                    if (commentsResponseCode == HttpURLConnection.HTTP_OK) {
                        try (BufferedReader commentsReader = new BufferedReader(new InputStreamReader(commentsConnection.getInputStream()))) {
                            JsonArray commentsArray = JsonParser.parseReader(commentsReader).getAsJsonArray();

                            String fileName = "user-" + userId + "-post-" + postId + "-comments.json";
                            try (Writer writer = new FileWriter("src/main/resources/" + fileName)) {
                                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                                gson.toJson(commentsArray, writer);
                            }

                            System.out.println("Comments for post " + lastPostId + " written to file: " + fileName);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}