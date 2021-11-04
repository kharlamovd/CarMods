package io.minecraftapps.carmods.uifactories;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import io.minecraftapps.carmods.Mod;
import io.minecraftapps.carmods.R;


public class ModStatsFactory {

    private final Context context;

    public ModStatsFactory(Context context) {
        this.context = context;
    }

    public LinearLayout createStatsLayout(Mod mod) {
        LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        int margin = (int) context.getResources().getDimension(R.dimen.margin);
        linearLayoutParams.setMargins(0, margin, 0, 0);

        LinearLayout parent = new LinearLayout(context);
        parent.setOrientation(LinearLayout.HORIZONTAL);
        parent.setLayoutParams(linearLayoutParams);

        TextView downloadsStat = createStatTextView(R.drawable.outline_speed_24, mod.getSpeed());
        parent.addView(downloadsStat);

        TextView sizeStat = createStatTextView(R.drawable.outline_file_download_24, mod.getSize());
        parent.addView(sizeStat);

        return parent;
    }

    private TextView createStatTextView(int iconId, String text) {

        TextView statView = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        int margin = (int) context.getResources().getDimension(R.dimen.card_margin);
        layoutParams.setMargins(margin, 0, 0, 0);

        statView.setLayoutParams(layoutParams);
        statView.setText(text);
        statView.setCompoundDrawablesWithIntrinsicBounds(iconId, 0, 0, 0);

        return statView;

    }

}
