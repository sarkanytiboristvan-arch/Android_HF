package com.example.hf4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class CurrencyAdapter extends ArrayAdapter<CurrencyItem> {

    public CurrencyAdapter(Context context, ArrayList<CurrencyItem> currencies) {
        super(context, 0, currencies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CurrencyItem currency = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_currency_adapter, parent, false);
        }

        TextView codeText = convertView.findViewById(R.id.currencyCode);
        TextView nameText = convertView.findViewById(R.id.currencyName);
        TextView countryText = convertView.findViewById(R.id.currencyCountry);
        TextView buyRateText = convertView.findViewById(R.id.buyRate);
        TextView sellRateText = convertView.findViewById(R.id.sellRate);
        android.widget.ImageView flagImage = convertView.findViewById(R.id.flagImage);

        codeText.setText(currency.getCode());
        nameText.setText(currency.getName());
        countryText.setText(currency.getCountry());
        buyRateText.setText(String.format("%.2f RON", currency.getBuyRate()));
        sellRateText.setText(String.format("%.2f RON", currency.getSellRate()));
        flagImage.setImageResource(currency.getFlagResId());

        return convertView;
    }
}