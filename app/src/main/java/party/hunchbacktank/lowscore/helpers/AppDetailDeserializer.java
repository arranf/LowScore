package party.hunchbacktank.lowscore.helpers;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import party.hunchbacktank.lowscore.model.steam.appdetails.AppDetail;

/**
 * Created by Arran on 18/05/2016.
 */
public class AppDetailDeserializer implements JsonDeserializer<AppDetail>
{
    @Override
    public AppDetail deserialize(JsonElement je, Type type,
                                     JsonDeserializationContext jdc)
            throws JsonParseException {
        JsonObject obj = je.getAsJsonObject();
            if (obj.get("data").getAsJsonObject().get("mac_requirements").isJsonArray()) {
                obj.get("data").getAsJsonObject().remove("mac_requirements");
            }
            if (obj.get("data").getAsJsonObject().get("linux_requirements").isJsonArray()) {
                obj.get("data").getAsJsonObject().remove("linux_requirements");
            }
            if (obj.get("data").getAsJsonObject().get("pc_requirements").isJsonArray()) {
                obj.get("data").getAsJsonObject().remove("pc_requirements");
            }
        return new Gson().fromJson(obj, AppDetail.class);
    }
}