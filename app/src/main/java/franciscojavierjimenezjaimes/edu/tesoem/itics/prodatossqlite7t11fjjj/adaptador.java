package franciscojavierjimenezjaimes.edu.tesoem.itics.prodatossqlite7t11fjjj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class adaptador extends PagerAdapter implements adapter{

    private List<CardView> mViews;
    private  List<carditem> mdata;
    private float mBaseElavtion;


    public adaptador(){
        mViews = new ArrayList<>();
        mdata = new ArrayList<>();
    }
    public void addCardItem(carditem item){
        mViews.add(null);
        mdata.add(item);
    }

    @Override
    public float getBaseElevation() {
        return mBaseElavtion;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return mdata.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.activity_menu,container,false);
        container.addView(view);
        bind(mdata.get(position),view);
        CardView cardView = view.findViewById(R.id.menubu);
        if (mBaseElavtion == 0){
            mBaseElavtion = cardView.getCardElevation();
        }
        cardView.setMaxCardElevation(mBaseElavtion * MAX_ELEVATION);
        mViews.set(position,cardView);
        return view;
    }
    private void bind(carditem carditem, View view){
        Button agregar = view.findViewById(R.id.add);
        Button mostrar = view.findViewById(R.id.list);
        Button actualizar = view.findViewById(R.id.upd);
        Button eliminar = view.findViewById(R.id.del);


    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
        mViews.set(position,null);
    }
}
