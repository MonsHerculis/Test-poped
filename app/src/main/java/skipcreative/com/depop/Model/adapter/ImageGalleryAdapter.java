package skipcreative.com.depop.Model.adapter;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import skipcreative.com.depop.Model.bean.Object;
import skipcreative.com.depop.R;

public class ImageGalleryAdapter extends RecyclerView.Adapter<ImageGalleryAdapter.ViewHolder> {

    private List<String> list;
    private ImageGalleryAdapter.OnItemSelected onItemSelected;
    Context context;

    public ImageGalleryAdapter(List<String> list, ImageGalleryAdapter.OnItemSelected onItemSelected, Context context) {
        this.list = list;
        this.onItemSelected = onItemSelected;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gallery, parent, false);

        return new ViewHolder(v);
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String imgUrl = list.get(position);
        if(imgUrl != null){
            if(imgUrl != null) {
                Glide.with(holder.itemView.getContext())
                        .load(imgUrl)
                        .into(holder.singleImg);
            }else{
                //ATTENZIONE GESTITO DA
                Glide.with(holder.itemView.getContext())
                        .load(context.getResources().getDrawable(R.drawable.ic_launcher_background))

                        .into(holder.singleImg);
            }
            holder.cardViewSingleImage.setOnClickListener((View v)->{
                onItemSelected.onItemSelected(imgUrl);

            });

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView singleImg;
        CardView cardViewSingleImage;

        ViewHolder(View v) {
            super(v);

            singleImg = v.findViewById(R.id.singleImg);
            cardViewSingleImage = v.findViewById(R.id.cardViewSingleImage);


        }
    }
    public interface OnItemSelected {
        void onItemSelected(String imgUrl);
    }
}

