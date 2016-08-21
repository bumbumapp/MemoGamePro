package org.secuso.privacyfriendlymemory.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import org.secuso.privacyfriendlymemory.common.MemoryLayoutProvider;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hannes on 21.05.2016.
 */
public class MemoryImageAdapter extends BaseAdapter {

    private final Context context;
    private final MemoryLayoutProvider layoutProvider;
    private Map<Integer, Bitmap> positionBitmapCache = new HashMap<>();
    private final Uri notFoundUri;

    public MemoryImageAdapter(Context context, MemoryLayoutProvider layoutProvider) {
        this.context = context;
        this.layoutProvider = layoutProvider;
        this.notFoundUri = Uri.parse("android.resource://org.secuso.privacyfriendlymemory/" + R.drawable.secuso_not_found);
    }

    @Override
    public int getCount() {
        return layoutProvider.getDeckSize();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView card;
        if (convertView == null) {
            card = new ImageView(context);
            int cardSize = layoutProvider.getCardSizePixel();
            card.setLayoutParams(new GridView.LayoutParams(cardSize, cardSize));
            card.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            card = (ImageView) convertView;
        }
        if (layoutProvider.isCustomDeck()) {
            Uri imageUri = layoutProvider.getImageUri(position);
            Bitmap resizedBitmap;

            boolean isCurrentUriNotFoundUri = notFoundUri.toString().equals(imageUri.toString());
            // check if bitmap exist in cache already
            if (positionBitmapCache.get(position) == null || isCurrentUriNotFoundUri) {
                resizedBitmap = decodeUri(imageUri, layoutProvider.getCardSizePixel());
                if (!isCurrentUriNotFoundUri) {
                    positionBitmapCache.put(position, resizedBitmap);
                }
            } else {
                resizedBitmap = positionBitmapCache.get(position);

            }
            card.setImageBitmap(resizedBitmap);
        } else{
            card.setImageResource(layoutProvider.getImageResID(position));
        }
        return card;
    }


    public int dpToPx(int dps) {
        final float scale = context.getResources().getDisplayMetrics().density;
        int pixels = (int) (dps * scale + 0.5f);

        return pixels;
    }

    private Bitmap decodeUri(Uri uri, final int requiredSize) {
        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeStream(context.getContentResolver().openInputStream(uri), null, o);
        } catch (IOException e) {
        }
        int width_tmp = o.outWidth, height_tmp = o.outHeight;
        int scale = 1;

        while (true) {
            if (width_tmp / 2 < requiredSize || height_tmp / 2 < requiredSize)
                break;
            width_tmp /= 2;
            height_tmp /= 2;
            scale *= 2;
        }

        BitmapFactory.Options o2 = new BitmapFactory.Options();
        o2.inSampleSize = scale;
        try {
            return BitmapFactory.decodeStream(context.getContentResolver().openInputStream(uri), null, o2);
        } catch (IOException e) {
        }
        return null;
    }
}