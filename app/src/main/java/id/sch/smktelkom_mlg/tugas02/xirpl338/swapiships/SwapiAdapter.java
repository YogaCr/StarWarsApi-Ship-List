package id.sch.smktelkom_mlg.tugas02.xirpl338.swapiships;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Sakata Yoga on 06/02/2018.
 */

public class SwapiAdapter extends RecyclerView.Adapter<SwapiAdapter.Holder> {
    List<ShipClass> ship;

    public SwapiAdapter(List<ShipClass> ship) {
        this.ship = ship;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_data, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        ShipClass shipclass = ship.get(position);

        holder.tv_name.setText(shipclass.getName());
        holder.tv_manufacturer.setText("Manufacturer : " + shipclass.getManufacture());
        holder.tv_model.setText("Model : " + shipclass.getModel());
        holder.tv_class.setText("Class : " + shipclass.getShip_class());
        holder.tv_passenger.setText("Passengers : " + shipclass.getPassenger());
    }

    @Override
    public int getItemCount() {
        return ship.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public TextView tv_name;
        public TextView tv_model;
        public TextView tv_manufacturer;
        public TextView tv_class;
        public TextView tv_passenger;

        public Holder(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_ship_name);
            tv_model = itemView.findViewById(R.id.tv_ship_model);
            tv_manufacturer = itemView.findViewById(R.id.tv_ship_manufacturer);
            tv_class = itemView.findViewById(R.id.tv_ship_class);
            tv_passenger = itemView.findViewById(R.id.tv_ship_passenger);
        }
    }
}
