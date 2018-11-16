package skipcreative.com.depop.Utils;


import java.util.ArrayList;
import java.util.List;

import skipcreative.com.depop.Model.bean.Article;
import skipcreative.com.depop.Model.bean.Object;

public class MainSingleton {

    private static MainSingleton singletonInstance = null;

    public List<Object> objectList = new ArrayList<>();



    private MainSingleton() {
    }


    public static MainSingleton getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new MainSingleton();
        }
        return singletonInstance;
    }



}
