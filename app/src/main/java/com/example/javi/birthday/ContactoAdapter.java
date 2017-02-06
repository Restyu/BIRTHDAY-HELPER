package com.example.javi.birthday;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;



public class ContactoAdapter extends BaseAdapter {

    private Context context;
    private List<Contacto> contactos;

    public ContactoAdapter(Context context, List<Contacto> contactos) {
        this.context = context;
        this.contactos = contactos;
    }

    @Override
    public int getCount() {
        return contactos.size();
    }

    @Override
    public Object getItem(int position) {
        return contactos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return contactos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        if (convertView == null) {
            // Create a new view into the list.
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.list_contacto, parent, false);
        }

        // Set data into the view.
        ImageView ivItem = (ImageView) rowView.findViewById(R.id.ivItem);
        TextView ivNombre = (TextView) rowView.findViewById(R.id.ivNombre);
        TextView ivTelefono = (TextView) rowView.findViewById(R.id.ivTelefono);
        TextView ivFecha = (TextView) rowView.findViewById(R.id.ivFecha);
        TextView ivNotify = (TextView) rowView.findViewById(R.id.ivNotify);

        Contacto item = this.contactos.get(position);
        ivNombre.setText(item.getNombre());
        ivTelefono.setText(item.getTelefono());
        ivFecha.setText(item.getFechaNacimiento());
        ivNotify.setText(item.getTipoNotificacion());
        ivItem.setImageResource(item.getImagen());

        return rowView;
    }
}
