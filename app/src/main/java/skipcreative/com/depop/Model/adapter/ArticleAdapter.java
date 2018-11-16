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

import skipcreative.com.depop.Model.bean.Article;
import skipcreative.com.depop.Model.bean.Object;
import skipcreative.com.depop.R;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private List<Object> objectList;
    private ArticleAdapter.OnItemSelected onItemSelected;
    Context context;

    public ArticleAdapter(List<Object> objectList, ArticleAdapter.OnItemSelected onItemSelected, Context context) {
        this.objectList = objectList;
        this.onItemSelected = onItemSelected;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);

        return new ViewHolder(v);
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Object object = objectList.get(position);
        if(object != null){
            holder.usernameTv.setText(String.valueOf(object.getUserId()));
            holder.shortDescriptionTv.setText(object.getSlug());
            if(object.getPicturesData().get(0) != null) {
                Glide.with(holder.itemView.getContext())
                        .load(object.getPicturesData().get(0).getFormats().getP1().getUrl())

                        .into(holder.previewImg);
            }else{
                Glide.with(holder.itemView.getContext())
                        .load(context.getResources().getDrawable(R.drawable.ic_launcher_background))

                        .into(holder.previewImg);
            }
            holder.cardView.setOnClickListener((View v)->{
                onItemSelected.onItemSelected(position);

            });

        }
    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        final TextView usernameTv;
        final TextView shortDescriptionTv;
        ImageView previewImg;
        CardView cardView;

        ViewHolder(View v) {
            super(v);
            usernameTv = v.findViewById(R.id.usernameTv);
            shortDescriptionTv = v.findViewById(R.id.shortDescriptionTv);
            previewImg = v.findViewById(R.id.previewImg);
            cardView = v.findViewById(R.id.cardView);


        }
    }
    public interface OnItemSelected {
        void onItemSelected(int elemento);
    }
}

