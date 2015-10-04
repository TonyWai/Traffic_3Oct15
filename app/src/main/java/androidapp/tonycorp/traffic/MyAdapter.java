package androidapp.tonycorp.traffic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by lenovo on 10/4/2015.
 */
public class MyAdapter extends BaseAdapter{
    //Explicit
    private Context objContext;
    private int[] iconInts;
    private String[] titleStrings;

    public MyAdapter(Context objContext, int[] iconInts, String[] titleStrings) {

        //ชื่อตัวแปรต้องตรงกัน ฝั่งซ้ายคือ explicit variable in class = ฝั่งขวา คือ parameters of constructor
        this.objContext = objContext;
        this.iconInts = iconInts;
        this.titleStrings = titleStrings;
    }

    @Override
    public int getCount() {
        return titleStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //open service as standard implementation to work with listview
        LayoutInflater objLayoutInflater = (LayoutInflater) objContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Map xml listView layout
        View objView1 = objLayoutInflater.inflate(R.layout.traffic_listview,viewGroup,false);

        /**traffic_listView มี 2 อย่างอยู่ข้างในคือ imageView and txtView**/

        //Setup Icon
        ImageView iconImageView = (ImageView) objView1.findViewById(R.id.imageView);
        iconImageView.setImageResource(iconInts[i]);

        //Setup Title
        TextView titleTextView = (TextView) objView1.findViewById(R.id.textView2);
        titleTextView.setText(titleStrings[i]);

        return objView1;
    } // getView ไว้ให้ Adapter ค่อยๆ loop วนเข้า listView หรือ Spinner
}
