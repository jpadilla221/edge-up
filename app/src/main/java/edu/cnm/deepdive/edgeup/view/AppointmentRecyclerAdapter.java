package edu.cnm.deepdive.edgeup.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import edu.cnm.deepdive.edgeup.R;
import edu.cnm.deepdive.edgeup.model.entity.Appointment;
import edu.cnm.deepdive.edgeup.model.entity.Barber;
import edu.cnm.deepdive.edgeup.view.BarberRecyclerAdapter.Holder;
import edu.cnm.deepdive.edgeup.view.BarberRecyclerAdapter.OnBarberClickListener;
import java.util.List;

public class AppointmentRecyclerAdapter extends RecyclerView.Adapter<Holder> {

  private final Context context;
  private List<Appointment> appointments;
  private final OnAppointmentClickListener listener;

  public AppointmentRecyclerAdapter(Context context,
      List<Barber> barbers,
      OnBarberClickListener listener) {
    this.context = context;
    this.appointments = appointments;
    this.listener = listener;
  }
  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View root = LayoutInflater.from(context).inflate(R.layout.item_appointment, parent, false);
    return new Holder(root);
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    holder.bind(position, appointments.get(position));
  }

  @Override
  public int getItemCount()  {
    return appointments.size();
    class Holder extends ViewHolder {

      private final TextView name;
      private final TextView clickView;

      public Holder(@NonNull View itemView) {
        super(itemView);
        clickView = itemView.findViewById(R.id.click_view);
        name = itemView.findViewById(R.id.name);
      }

      private void bind(int position, Appointment appointment) {
        name.setText(appointment.getName());
        clickView.setOnClickListener((v) -> listener.onAppointmentClick(getAdapterPosition(), appointment));
      }
    }

    @FunctionalInterface
    public interface OnAppointmentClickListener {
      void onAppointmentClick(int position, Appointment appointment);

  }
}
