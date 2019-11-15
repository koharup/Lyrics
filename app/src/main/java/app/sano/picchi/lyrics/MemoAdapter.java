package app.sano.picchi.lyrics;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MemoAdapter extends ArrayAdapter<Memo> {

    private LayoutInflater layoutinflater;

    MemoAdapter(Context context, int textViewResourceId, List<Memo> objects) {
        super(context, textViewResourceId, objects);
        layoutinflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Memo memo = getItem(position);

        if (convertView == null) {
            convertView = layoutinflater.inflate(R.layout.layout_item_memo, null);
        }

        TextView titleText = (TextView) convertView.findViewById(R.id.titleText);
        TextView contentText = (TextView) convertView.findViewById(R.id.contentText);
        //TextView mainwordText = (TextView) convertView.findViewById(R.id.mainwordEditText);
        //TextView word2Text = (TextView) convertView.findViewById(R.id.subwordEditText);

        titleText.setText(memo.title);
        contentText.setText(memo.content);
        //mainwordText.setText(memo.mainword);

        return convertView;
    }
}