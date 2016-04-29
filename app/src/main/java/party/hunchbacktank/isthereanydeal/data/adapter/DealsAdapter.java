package party.hunchbacktank.isthereanydeal.data.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import party.hunchbacktank.isthereanydeal.R;
import party.hunchbacktank.isthereanydeal.model.deals.Deal;

public class DealsAdapter extends RecyclerView.Adapter<DealsAdapter.MyViewHolder> {

    private List<Deal> dealList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, shop, cut;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            cut = (TextView) view.findViewById(R.id.cut);
            shop = (TextView) view.findViewById(R.id.shop);
        }
    }


    public DealsAdapter(List<Deal> dealList) {
        this.dealList = dealList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.deals, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Deal deal = dealList.get(position);
        holder.title.setText(deal.getTitle());
        holder.cut.setText(deal.getPriceCut() + "%");
        holder.shop.setText(deal.getShop().getName());
    }

    @Override
    public int getItemCount() {
        return dealList.size();
    }
}