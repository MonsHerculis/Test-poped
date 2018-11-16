package skipcreative.com.depop.Utils;


import android.content.Context;
import android.content.SharedPreferences;



public class PreferenceManager {

    private static SharedPreferences preferences;

    public static void init(Context context) {
        if (preferences == null)
            preferences = context.getSharedPreferences(Constants.Preferences.PREFERENCE_FILE_NAME, Context.MODE_PRIVATE);
    }

   /* public static void saveUsername(String username) {
        preferences.edit().putString(Constants.Preferences.USERNAME, username).apply();
    }
    public static String getUsername() {
        return preferences.getString(Constants.Preferences.USERNAME, "");
    }*/


}
