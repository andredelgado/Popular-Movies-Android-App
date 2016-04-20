package xyz.adelgado.popularmovies.data.api;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

/**
 * Created by andredelgado on 20/04/16.
 */
public class MoviesDeserializer<T> implements JsonDeserializer<T> {

  @Override public T deserialize(JsonElement json, Type type, JsonDeserializationContext context)
      throws JsonParseException {

    JsonElement content = json.getAsJsonObject().get("results");

    return new Gson().fromJson(content, type);
  }
}
