package skipcreative.com.depop.Presenter;

import java.util.List;

import skipcreative.com.depop.Model.bean.Article;
import skipcreative.com.depop.Utils.network.RetrofitHelper;

public class ArticleInteractor {


    public interface ArticleListener {

        void onArticle(Article article);


        void onError(String msg);
        void onCallUnauthorized();


    }


    public void getArticle(ArticleListener listener) {
        new RetrofitHelper().getArticle(listener);
    }

}
