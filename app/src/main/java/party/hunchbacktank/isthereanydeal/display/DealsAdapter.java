package party.hunchbacktank.isthereanydeal.display;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import party.hunchbacktank.isthereanydeal.activities.DisplayGameActivity;
import party.hunchbacktank.isthereanydeal.R;
import party.hunchbacktank.isthereanydeal.model.deals.Deal;

public class DealsAdapter extends RecyclerView.Adapter<DealsAdapter.MyDealHolder> {

    private List<Deal> dealList;
    private RecyclerView recyclerView;
    private final OnClickListener onClickListener = new DealListOnClick();

    public class MyDealHolder extends RecyclerView.ViewHolder {
        public TextView title, shop, cut;
        public String plain;

        public MyDealHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            cut = (TextView) view.findViewById(R.id.cut);
            shop = (TextView) view.findViewById(R.id.shop);
        }
    }


    public DealsAdapter(RecyclerView recyclerView, List<Deal> dealList) {
        this.recyclerView = recyclerView;
        this.dealList = dealList;
    }

    @Override
    public MyDealHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.deals, parent, false);
        itemView.setOnClickListener(onClickListener);
        return new MyDealHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyDealHolder holder, int position) {
        Deal deal = dealList.get(position);
        holder.plain = deal.getPlain();
        holder.title.setText(deal.getTitle());
        holder.cut.setText(deal.getPriceCut() + "%");
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