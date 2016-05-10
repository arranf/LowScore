package party.hunchbacktank.isthereanydeal.display;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageSwitcher;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
 * Created by Arran on 10/05/2016.
 */
public class PicassoSwitcherHelper implements Target{
    private ImageSwitcher imageSwitcher;
    private Context context;

    public PicassoSwitcherHelper(Context context, ImageSwitcher imageSwitcher){
        this.imageSwitcher = imageSwitcher;
        this.context = context;
    }

    @Override
    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
        imageSwitcher.setImageDrawable(new BitmapDrawable(context.getResources(), bitmap));
    }

    @Override
    public void onBitmapFailed(Drawable drawable) {

    }

    @Override
    public void onPrepareLoad(Drawable drawable) {

    }
}
