package skipcreative.com.depop.View.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import skipcreative.com.depop.Model.adapter.ArticleAdapter;
import skipcreative.com.depop.Model.adapter.ImageGalleryAdapter;
import skipcreative.com.depop.Model.bean.Object;
import skipcreative.com.depop.R;
import skipcreative.com.depop.Utils.MainSingleton;

public class DetailsFragment extends Fragment implements ImageGalleryAdapter.OnItemSelected  {

    private static int position;
    private OnFragmentInteractionListener mListener;
    List<Object> objectList = new ArrayList<>();
    Toolbar toolbar;
    RecyclerView galleryRecycler;
    ImageGalleryAdapter galleryAdapter;
    ImageView imgView;
    CollapsingToolbarLayout collapsingToolbarLayout;
    CardView cardView;
    TextView descriptionTv;
    TextView priceTv;



    public DetailsFragment() {
        // Required empty public constructor
    }


    public static DetailsFragment newInstance(int elemento) {
        DetailsFragment fragment = new DetailsFragment();
        position= elemento;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_details, container, false);
        collapsingToolbarLayout = root.findViewById(R.id.collapsingToolbar);
        cardView = root.findViewById(R.id.cardView);
        descriptionTv= root.findViewById(R.id.descriptionTv);
        priceTv= root.findViewById(R.id.priceTv);

        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        galleryRecycler = root.findViewById(R.id.galleryRecycler);
        imgView = root.findViewById(R.id.imageView);

        galleryRecycler.setLayoutManager(new GridLayoutManager(getContext(), 1, GridLayoutManager.HORIZONTAL, false));

        objectList = MainSingleton.getInstance().objectList;
        Object object = objectList.get(position);
        collapsingToolbarLayout.setTitle(String.valueOf(object.getUserId()));
        galleryAdapter = new ImageGalleryAdapter(createGalleryList(object) , this,  getActivity());
        galleryRecycler.setAdapter(galleryAdapter);

        setImage(getActivity(), createGalleryList(object).get(0),imgView);
        descriptionTv.setText(object.getDescription());
        priceTv.setText(getResources().getString(R.string.price)+object.getPriceAmount() +" "+getResources().getString(R.string.priceSymbol));

        return root;
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
    public void onItemSelected(String imgUrl) {
        setImage(getActivity(), imgUrl,imgView);

    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(int position, int elemento);
    }
    public List<String> createGalleryList(Object object){
        List<String> galleryList = new ArrayList<>();
        object.getPicturesData().size();
        for(int x = 0; x < object.getPicturesData().size(); x++){
            galleryList.add(object.getPicturesData().get(x).getFormats().getP0().getUrl());
        }


        return galleryList;
    }
    public void setImage(Context context, String url, ImageView imgView){
        Glide.with(context)
                .load(url)
                .into(imgView);
    }

}
