package franciscojavierjimenezjaimes.edu.tesoem.itics.prodatossqlite7t11fjjj;

import androidx.cardview.widget.CardView;

public interface adapter {

    int MAX_ELEVATION = 8;

    float getBaseElevation();

    CardView getCardViewAt(int position);

    int getCount();
}
