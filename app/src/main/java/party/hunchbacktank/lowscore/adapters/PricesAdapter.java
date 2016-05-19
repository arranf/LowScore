package party.hunchbacktank.lowscore.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import party.hunchbacktank.lowscore.R;
import party.hunchbacktank.lowscore.model.isthereanydeal.prices.Price;


public class PricesAdapter extends RecyclerView.Adapter<PricesAdapter.PricesHolder> {

    private List<Price> prices = new ArrayList<>();
    private RecyclerView recyclerView;
    private final ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    private PriceListOnClick priceListOnClick = new PriceListOnClick();

    public PricesAdapter(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public void setPrices(List<Price> priceList){
        if (!prices.isEmpty()){
            prices.clear();
        }
        prices.addAll(priceList);
        notifyDataSetChanged();
    }

    public class PricesHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.list_stores_store_name) TextView storeName;
        @BindView(R.id.list_stores_price_context) TextView priceContext;
        @BindView(R.id.list_stores_price) TextView price;
        @BindView(R.id.list_stores_cheap) TextView cheapComparison;
        @BindView(R.id.list_stores_drm_icon) ImageView storeDRMIcon;

        public PricesHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public PricesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_stores, parent, false);
        itemView.setOnClickListener(priceListOnClick);
        itemView.setLayoutParams(layoutParams);
        return new PricesHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PricesHolder holder, int position) {
        Price price = prices.get(position);
        holder.storeName.setText(price.getShop().getName());
        holder.price.setText(Double.toString(price.getPriceNew()));
    }

    @Override
    public int getItemCount() {
        return prices.size();
    }


    public class PriceListOnClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Context context = view.getContext();
            int itemPosition = recyclerView.getChildAdapterPosition(view);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(prices.get(itemPosition).getUrl()));
            context.startActivity(intent);
        }
    }
}