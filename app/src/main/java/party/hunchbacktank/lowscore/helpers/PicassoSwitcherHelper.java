package party.hunchbacktank.lowscore.helpers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
 * Created by Arran on 10/05/2016.
 */
public class PicassoSwitcherHelper implements Target {
    private ImageSwitcher imageSwitcher;
    private Context context;
    private View view;

    public PicassoSwitcherHelper(Context context, ImageSwitcher imageSwitcher, View view){
        this.imageSwitcher = imageSwitcher;
        this.context = context;
        this.view = view;
    }

    @Override
    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
        BitmapDrawable drawable = new BitmapDrawable(context.getResources(), bitmap);
        imageSwitcher.setImageDrawable(new BitmapDrawable(context.getResources(), bitmap));
        //Calculates what the height should be. Can't fetch height from imageswitcher as it returns 0 as image hasn't loaded.
        double isWidth = imageSwitcher.getMeasuredWidth();
        double bpWidth = bitmap.getWidth();
        double scaleFactor = isWidth/bpWidth;
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.height = (int)Math.floor(bitmap.getHeight()*scaleFactor);
        view.setLayoutParams(params);
        view.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBitmapFailed(Drawable drawable) {
    }

    @Override
    public void onPrepareLoad(Drawable drawable) {

    }
}
