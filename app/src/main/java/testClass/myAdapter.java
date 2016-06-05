package testClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.copluk.testcodebycopluk.R;

import org.json.JSONArray;

/**
 * Created by Copluk on 16/6/5.
 */
public class myAdapter extends BaseAdapter {

    private Context _context;
    private JSONArray _dataArray;
    private LayoutInflater _lInflater;

    public myAdapter(Context context , JSONArray data){
        this._context = context;
        this._dataArray = data;
        this._lInflater = LayoutInflater.from(_context);
    }

    @Override
    public int getCount() {
        return _dataArray.length();
    }

    @Override
    public Object getItem(int position) {

        try{
            return _dataArray.getString(position);
        }catch (Exception e){
            return  null;
        }

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = _lInflater.inflate(R.layout.list_view_template, parent, false);
            holder = new ViewHolder();
            holder.textView = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String text = (String) getItem(position);
        holder.textView.setText(text);

        return convertView;
    }

    private static class ViewHolder {
        TextView textView;
    }




}
