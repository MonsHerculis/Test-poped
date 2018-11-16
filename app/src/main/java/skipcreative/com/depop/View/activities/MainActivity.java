package skipcreative.com.depop.View.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import skipcreative.com.depop.Model.bean.Article;
import skipcreative.com.depop.Presenter.ArticlePresenter;
import skipcreative.com.depop.R;
import skipcreative.com.depop.Utils.MainSingleton;
import skipcreative.com.depop.Utils.Utils;
import skipcreative.com.depop.View.fragments.DetailsFragment;
import skipcreative.com.depop.View.fragments.ListFragment;
import skipcreative.com.depop.View.interfaces.ArticleView;

public class MainActivity extends AppCompatActivity implements  ListFragment.OnFragmentInteractionListener, DetailsFragment.OnFragmentInteractionListener {

    private FragmentManager fragmentManager;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @Override
    protected void onResume() {
        super.onResume();
         fragmentManager = getSupportFragmentManager();
         fragmentManager.beginTransaction()
                .replace(R.id.contentFrame, ListFragment.newInstance())
                .commit();
    }

    @Override
    public void onFragmentInteraction(int pos, int elemento) {
        ft = getSupportFragmentManager().beginTransaction();
        switch (pos){
            case 1:
                ft.replace(R.id.contentFrame, ListFragment.newInstance());
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.contentFrame, DetailsFragment.newInstance(elemento));
                ft.commit();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (currentFragment instanceof DetailsFragment) {
            ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.contentFrame, new ListFragment());
            ft.commit();
        }else{
            super.onBackPressed();
        }
    }
}
