package skipcreative.com.depop.Utils;

import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import skipcreative.com.depop.View.activities.MainActivity;

public class Utils {

    public static boolean checkConnectivity(Context context){
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    }
    /*public static int getScreenDimension(){
        int screenSize = getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK;

        String toastMsg;
        switch(getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK;) {
            case Configuration.SCREENLAYOUT_SIZE_XLARGE:
                toastMsg = "Large screen";

                break;
            case Configuration.SCREENLAYOUT_SIZE_LARGE:
                toastMsg = "Large screen";
                break;
            case Configuration.SCREENLAYOUT_SIZE_NORMAL:
                toastMsg = "Normal screen";
                break;
            case Configuration.SCREENLAYOUT_SIZE_SMALL:
                toastMsg = "Small screen";
                break;
            default:
                toastMsg = "Screen size is neither large, normal or small";
        }
        Toast.makeText(getActivity(), toastMsg, Toast.LENGTH_LONG).show();
    }*/
}
