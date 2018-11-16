package skipcreative.com.depop.View.interfaces;


import java.util.List;

import skipcreative.com.depop.Model.bean.Article;

public interface ArticleView {

    void showProgress();

    void hideProgress();

    void onCallUnauthorized();

    void onCallFailed(String error);

    void onGotArticle(Article articleList);
}
