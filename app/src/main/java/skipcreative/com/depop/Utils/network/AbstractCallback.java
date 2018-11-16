package skipcreative.com.depop.Utils.network;

import android.support.annotation.NonNull;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class AbstractCallback<E> implements Callback<E> {


    protected AbstractCallback() {
    }

    @Override
    public void onResponse(@NonNull Call<E> call, @NonNull Response<E> response) {
        switch (response.code()) {
            case HttpURLConnection.HTTP_OK:
            case HttpURLConnection.HTTP_CREATED:
            case HttpURLConnection.HTTP_UNAUTHORIZED:
                onResultOK(response);
                break;
            case HttpURLConnection.HTTP_NOT_FOUND:
                onNotFound();
                break;

            case HttpURLConnection.HTTP_FORBIDDEN:
            default:
                onFail(response.raw().toString());
        }
    }

    @Override
    public void onFailure(@NonNull Call<E> call, @NonNull Throwable t) {
        onFail(t.getMessage());
    }

    protected abstract void onResultOK(Response<E> response);


    protected abstract void onFail(String msg);


    protected void onNotFound() {
    }

    ;


}