package skipcreative.com.depop.View.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import skipcreative.com.depop.Model.adapter.ArticleAdapter;
import skipcreative.com.depop.Model.bean.Article;
import skipcreative.com.depop.Model.bean.Object;
import skipcreative.com.depop.Presenter.ArticlePresenter;
import skipcreative.com.depop.R;
import skipcreative.com.depop.Utils.MainSingleton;
import skipcreative.com.depop.Utils.Utils;
import skipcreative.com.depop.View.interfaces.ArticleView;


public class ListFragment extends Fragment implements ArticleAdapter.OnItemSelected, ArticleView{
    ArticlePresenter articlePresenter;
    private OnFragmentInteractionListener mListener;
    RecyclerView recyclerView;
    ArticleAdapter articleAdapter;
    Toolbar toolbar;
    ConstraintLayout noSignalContainer;

    public ListFragment() {
        // Required empty public constructor
    }

    public static ListFragment newInstance() {
        ListFragment fragment = new ListFragment( );

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        toolbar = root.findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.toolbar_name));

        noSignalContainer = root.findViewById(R.id.containerEmptyConnectivity);

        articlePresenter = new ArticlePresenter(this);


        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(Utils.checkConnectivity(getActivity())){
            noSignalContainer.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            articlePresenter.getArticle();

        }else{
            recyclerView.setVisibility(View.GONE);
            noSignalContainer.setVisibility(View.VISIBLE);
            noSignalContainer.setOnClickListener((View v)->{
                onResume();
            });
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemSelected(int elemento) {
        mListener.onFragmentInteraction(2, elemento);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onCallUnauthorized() {

    }

    @Override
    public void onCallFailed(String error) {
        Log.d("CALL", error);
    }

    @Override
    public void onGotArticle(Article articleList) {
            MainSingleton.getInstance().objectList = articleList.getObjects();

            articleAdapter = new ArticleAdapter(articleList.getObjects() , this,  getActivity());
            recyclerView.setAdapter(articleAdapter);
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(int position, int elemento);
    }
}
