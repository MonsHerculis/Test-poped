package skipcreative.com.depop.Utils.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import skipcreative.com.depop.Model.bean.Article;

public interface ApiInterface {

    @GET("popular/?offset_id=")
    Call<Article> getArticle();

}