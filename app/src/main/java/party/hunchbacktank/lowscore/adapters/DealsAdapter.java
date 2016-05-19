package party.hunchbacktank.lowscore.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import party.hunchbacktank.lowscore.R;
import party.hunchbacktank.lowscore.activities.DisplayGameActivity;
import party.hunchbacktank.lowscore.model.isthereanydeal.recommendeddeal.Deal;

public class DealsAdapter extends RecyclerView.Adapter<DealsAdapter.DealHolder> {

    private List<Deal> dealList;
    private RecyclerView recyclerView;
    private final OnClickListener onClickListener = new DealListOnClick();
    private final ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

    public DealsAdapter(RecyclerView recyclerView, List<Deal> dealList) {
        this.recyclerView = recyclerView;
        this.dealList = dealList;
    }

    public class DealHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title) TextView title;
        @BindView(R.id.cut) TextView cut;
        @BindView(R.id.shop) TextView shop;

        public DealHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    @Override
    public DealHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_deals, parent, false);
        itemView.setOnClickListener(onClickListener);
        itemView.setLayoutParams(layoutParams);
        return new DealHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DealHolder holder, int position) {
        Deal deal = dealList.get(position);
        holder.title.setText(deal.getTitle());
        holder.cut.setText(String.format("%s%%", String.valueOf(deal.getPriceCut())));
        holder.shop.setText(deal.getShop().getName());
    }

    @Override
    public int getItemCount() {
        return dealList.size();
    }

    public class DealListOnClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Context context = view.getContext();
            Intent intent = new Intent(context, DisplayGameActivity.class);
            int itemPosition = recyclerView.getChildAdapterPosition(view);
            intent.putExtra("plainName", dealList.get(itemPosition).getPlain());
            context.startActivity(intent);
        }
    }
}