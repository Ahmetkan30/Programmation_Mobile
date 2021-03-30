package com.example.tp.ui.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.tp.R;

import java.util.Locale;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        switch (position) {
            case 1:
                return NatureFragment.newInstance(1, mContext.getString(R.string.titre_section0));
            case 2:
                return NatureFragment.newInstance(2, mContext.getString(R.string.titre_section1));
            case 3:
                return NatureFragment.newInstance(3, mContext.getString(R.string.titre_section2));
            case 4:
                return NatureFragment.newInstance(4,mContext.getString(R.string.titre_section3));
            case 0:
                return NatureFragment.newInstance(0, mContext.getString(R.string.menu_section));
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        String titre = "";
        Drawable icone = null;
        if( position == 0 ){
            titre = mContext.getString(R.string.menu_section).toUpperCase(l);
            return new SpannableString(titre);
        }
        switch (position) {
            case 1:
                titre = mContext.getString(R.string.titre_section0).toUpperCase(l);
                icone =  getIcon(R.drawable.hiver_icone);
                break;
            case 2:
                titre = mContext.getString(R.string.titre_section1).toUpperCase(l);
                icone = getIcon(R.drawable.printemps_icone);
                break;
            case 3:
                titre = mContext.getString(R.string.titre_section2).toUpperCase(l);
                icone =  getIcon(R.drawable.ete_icone);
                break;
            case 4:
                titre = mContext.getString(R.string.titre_section3).toUpperCase(l);
                icone =  getIcon(R.drawable.automne_icone);
        }
        SpannableString sb = new SpannableString(" " + titre);
// un espace est ajouté pour séparer le texte de l'image

        icone.setBounds(0, 0, icone.getIntrinsicWidth(), icone.getIntrinsicHeight());
        ImageSpan span = new ImageSpan(icone, ImageSpan.ALIGN_BASELINE);
        sb.setSpan(span, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return sb;
    }
    private Drawable getIcon(int drawable){
        return  ResourcesCompat.getDrawable(mContext.getResources(),drawable,null);
    }
    @Override
    public int getCount() {
        // Nombre de pages à considérer.
        return 5;
    }
}
