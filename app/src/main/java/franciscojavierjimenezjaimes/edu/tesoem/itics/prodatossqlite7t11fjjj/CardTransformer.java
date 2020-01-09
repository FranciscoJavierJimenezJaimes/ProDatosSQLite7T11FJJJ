package franciscojavierjimenezjaimes.edu.tesoem.itics.prodatossqlite7t11fjjj;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

public class CardTransformer implements ViewPager.OnPageChangeListener, ViewPager.PageTransformer {
    private ViewPager mViewPager;
    private adaptador adaptador;
    private float mLastOffset;
    private boolean mScalingEnabled;

    public CardTransformer(ViewPager mViewPager, adaptador adaptador){
        this.mViewPager = mViewPager;
        mViewPager.addOnPageChangeListener(this);
        this.adaptador = adaptador;

    }


    public void enableScaling(boolean enable){
        if (mScalingEnabled && !enable){
            CardView currencard = adaptador.getCardViewAt(mViewPager.getCurrentItem());
            if (currencard!=null){
                currencard.animate().scaleX(1);
                currencard.animate().scaleY(1);
            }
        }else if(!mScalingEnabled && enable){
            CardView currentcard = adaptador.getCardViewAt(mViewPager.getCurrentItem());
            if (currentcard!=null){
                currentcard.animate().scaleX(1.1f);
                currentcard.animate().scaleY(1.1f);
            }
        }
            mScalingEnabled = enable;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        int realCurrentPosition;
        int nextPosition;
        float baseElevation = adaptador.getBaseElevation();
        float realOffSet;
        boolean goingLeft = mLastOffset > positionOffset;
        if (goingLeft){
            realCurrentPosition = position+1;
            nextPosition = position;
            realOffSet = 1 - positionOffset;

        }else {
            nextPosition =position +1;
            realCurrentPosition = position;
            realOffSet = positionOffset;
        }
        if (nextPosition > adaptador.getCount()-1 || realCurrentPosition > adaptador.getCount()-1)
            return;
             CardView currentcard = adaptador.getCardViewAt(realCurrentPosition);

             if (currentcard!=null){
                 if (mScalingEnabled){
                     currentcard.setScaleX((float) (1 + 0.1 * (1-realOffSet)));
                     currentcard.setScaleY((float) (1 + 0.1 * (1-realOffSet)));

                 }
                 currentcard.setMaxCardElevation(baseElevation+baseElevation*(adaptador.MAX_ELEVATION-1) * (1-realOffSet));
             }

             CardView  nextcard = adaptador.getCardViewAt(nextPosition);
             if (nextcard!=null){
                 if (mScalingEnabled){
                     nextcard.setScaleX((float) ( 1 + 0.1) * (realOffSet));
                     nextcard.setScaleY((float) (1 +0.1) * (realOffSet));
                 }
                 nextcard.setMaxCardElevation((baseElevation+baseElevation * (adaptador.MAX_ELEVATION - 1 * (realOffSet))));
             }
             mLastOffset = positionOffset;
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void transformPage(@NonNull View page, float position) {

    }
}
