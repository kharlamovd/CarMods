package io.minecraftapps.carmods.uifactories;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;

import io.minecraftapps.carmods.Mod;
import io.minecraftapps.carmods.ModInstallOnClickListener;
import io.minecraftapps.carmods.R;


public class ModCardFactory {

    private final Context context;
    private final ModStatsFactory statsFactory;

    private static final int TITLE_TEXT_SIZE_SP = 20;

    public ModCardFactory(Context context) {
        this.context = context;
        statsFactory = new ModStatsFactory(context);
    }

    public CardView createModCard(Mod mod, boolean demo) {

        CardView cardView = new CardView(context);
        LinearLayout.LayoutParams layoutparams;

        if (demo)
            layoutparams = new LinearLayout.LayoutParams(
                    (int) context.getResources().getDimension(R.dimen.demo_addon_card_width),
                    (int) context.getResources().getDimension(R.dimen.demo_addon_card_height)
        );
        else
            layoutparams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    (int) context.getResources().getDimension(R.dimen.addon_card_height)
            );

        int margin = (int) context.getResources().getDimension(R.dimen.card_margin);
        int cardElevation = (int) context.getResources().getDimension(R.dimen.card_elevation);
        float cardCornerRadius = context.getResources().getDimension(R.dimen.card_corner_radius);

        layoutparams.setMargins(margin, margin, margin, margin);

        cardView.setLayoutParams(layoutparams);
        cardView.setCardElevation(cardElevation);
        cardView.setRadius(cardCornerRadius);

        LinearLayout cardLayout = createModCardLayout(mod, demo);
        cardView.addView(cardLayout);

        return cardView;

    }

    private LinearLayout createModCardLayout(Mod mod, boolean demo) {

        LinearLayout cardLayout = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        cardLayout.setLayoutParams(layoutParams);
        cardLayout.setOrientation(LinearLayout.VERTICAL);

        int[] screens = mod.getScreenIds();

        ImageView modTitleImage = createModImage(context.getDrawable(screens[0]), demo);
        cardLayout.addView(modTitleImage);

        //if (mod.getType() != ModType.SKIN) {
            TextView titleView = createModTitle(mod.getTitle());
            cardLayout.addView(titleView);
        //}


        LinearLayout bottomLayout = new LinearLayout(context);
        LinearLayout.LayoutParams bottomParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        bottomLayout.setLayoutParams(bottomParams);
        bottomLayout.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout statsLayout = statsFactory.createStatsLayout(mod);
        bottomLayout.addView(statsLayout);

        View stub = createSpaceStubView();
        bottomLayout.addView(stub);

        CardView cardView = new CardView(context);
        LinearLayout.LayoutParams wrapParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        int margin = (int) context.getResources().getDimension(R.dimen.margin);
        layoutParams.setMargins(margin, margin, margin, margin);
        cardView.setLayoutParams(wrapParams);

        float cardCornerRadius = context.getResources().getDimension(R.dimen.card_corner_radius);
        cardView.setRadius(cardCornerRadius);

        AppCompatButton installButton = createInstallButton(mod);
        cardView.addView(installButton);
        bottomLayout.addView(cardView);

        cardLayout.addView(bottomLayout);

        return cardLayout;

    }

    private ImageView createModImage(Drawable drawable, boolean demo) {

        ImageView imageView = new ImageView(context);
        LinearLayout.LayoutParams layoutParams;
        if (demo)
            layoutParams = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    (int) context.getResources().getDimension(R.dimen.demo_addon_imageview_height)
            );
        else
            layoutParams = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    (int) context.getResources().getDimension(R.dimen.addon_imageview_height)
            );

        imageView.setLayoutParams(layoutParams);
        imageView.setImageDrawable(drawable);

        return imageView;

    }

    private TextView createModTitle(String title) {

        TextView titleTextView = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        int margin = (int) context.getResources().getDimension(R.dimen.card_margin);
        layoutParams.setMargins(margin, margin, 0, 0);

        titleTextView.setLayoutParams(layoutParams);
        titleTextView.setText(title);
        titleTextView.setTypeface(titleTextView.getTypeface(), Typeface.BOLD);
        titleTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, TITLE_TEXT_SIZE_SP);

        return titleTextView;

    }

    private View createSpaceStubView() {
        View stub = new View(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, 0);
        layoutParams.weight = 1;
        stub.setLayoutParams(layoutParams);

        return stub;
    }

    private AppCompatButton createInstallButton(Mod mod) {
        AppCompatButton button = new AppCompatButton(context);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
        int margin = (int) context.getResources().getDimension(R.dimen.card_margin);
        button.setLayoutParams(layoutParams);

        button.setText(R.string.install);
        button.setBackgroundColor(context.getResources().getColor(R.color.main));
        button.setPadding(margin, 0, margin, 0);
        button.setTextColor(context.getResources().getColor(R.color.white));
        button.setOnClickListener(new ModInstallOnClickListener(mod.getModFileId(), mod.getFileExtension()));

        return button;
    }

}

