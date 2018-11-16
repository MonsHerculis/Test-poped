package skipcreative.com.depop.Utils.network;


import java.net.HttpURLConnection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import skipcreative.com.depop.Model.bean.Article;
import skipcreative.com.depop.Presenter.ArticleInteractor;

public class RetrofitHelper {

    public void getArticle(  final ArticleInteractor.ArticleListener listener) {
        ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        Call<Article> call = apiInterface.getArticle();
        call.enqueue(new AbstractCallback<Article>() {
            @Override
            protected void onResultOK(Response<Article> response) {
                if ((response.code() == HttpURLConnection.HTTP_OK || response.code() == HttpURLConnection.HTTP_CREATED)) {
                    listener.onArticle(response.body());
                } else if (response.code() == HttpURLConnection.HTTP_UNAUTHORIZED || response.code() == HttpURLConnection.HTTP_FORBIDDEN) {
                     listener.onCallUnauthorized();
                }
            }

            @Override
            protected void onFail(String msg) {
                listener.onError(msg);
            }
        });
    }

}