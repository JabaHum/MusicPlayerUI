package id.ac.polinema.musicplayer.common;


import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.lang.ref.WeakReference;
import java.util.List;

import id.ac.polinema.musicplayer.models.Image;

/**
 * Helper class that is used to load images
 * it's purpose is to make the code independent of the 3rd party library used to load image, like if we decide to use picasso instead of glide, w will just have to update the usage here and not in every occurrence
 */

public class ImageLoader {
    public static void loadImage(Context context, List<Image> imageUrl, int placeHolderResourceID, ImageView imageView) {
        WeakReference<Context> weakReference = new WeakReference<>(context);
        Glide.with(weakReference.get())
                .asBitmap()
                .load(imageUrl.get(0).getText())
                .placeholder(placeHolderResourceID)
                .into(imageView);
    }

    // load image with callbacks
    public static void loadImage(Context context, String imageUrl, int placeHolderResourceID, ImageView imageView, final ImageLoaderCallbacks callbacks) {
        WeakReference<Context> weakReference = new WeakReference<>(context);
        Glide.with(weakReference.get())
                .asBitmap()
                .load(imageUrl)
                .placeholder(placeHolderResourceID)
                .listener(new RequestListener<Bitmap>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {

                        if (callbacks != null) {
                            callbacks.onFail(e);
                        }

                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                        if (callbacks != null) {
                            callbacks.onSuccess();
                        }
                        return false;
                    }
                })
                .into(imageView);
    }

    public interface ImageLoaderCallbacks {
        void onSuccess();

        void onFail(Exception e);
    }
}
