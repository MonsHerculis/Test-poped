package skipcreative.com.depop.Presenter;

import java.util.List;

import skipcreative.com.depop.Model.bean.Article;
import skipcreative.com.depop.View.interfaces.ArticleView;

public class ArticlePresenter implements ArticleInteractor.ArticleListener {

    private ArticleView articleView;
    private ArticleInteractor articleInteractor;


    public ArticlePresenter(ArticleView articleView) {
        this.articleView = articleView;
        this.articleInteractor = new ArticleInteractor();
    }


    public void getArticle() {
        articleView.showProgress();
        articleInteractor.getArticle(this);
    }


    @Override
    public void onArticle(Article article) {
        if (articleView != null) {
            articleView.hideProgress();
            articleView.onGotArticle(article);
        }
    }

    @Override
    public void onError(String msg) {
        if (articleView != null) {
            articleView.hideProgress();
            articleView.onCallFailed(msg);
        }
    }

    @Override
    public void onCallUnauthorized() {
        if (articleView != null) {
            articleView.hideProgress();
            articleView.onCallUnauthorized();
        }
    }


}
