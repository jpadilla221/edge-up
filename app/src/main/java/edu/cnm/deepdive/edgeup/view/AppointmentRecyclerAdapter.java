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
import edu.cnm.deepdive.edgeup.model.pojo.AppointmentWithDetails;
import edu.cnm.deepdive.edgeup.view.AppointmentRecyclerAdapter.Holder;
import java.text.DateFormat;
import java.util.List;

public class AppointmentRecyclerAdapter extends RecyclerView.Adapter<Holder> {

  private final Context context;
  private List<AppointmentWithDetails> appointments;
  private final OnAppointmentClickListener listener;
  private final DateFormat dateFormat;
  private final DateFormat timeFormat;

  public AppointmentRecyclerAdapter(Context context,
      List<AppointmentWithDetails> appointments,
      OnAppointmentClickListener listener) {
    this.context = context;
    this.appointments = appointments;
    this.listener = listener;
    dateFormat = android.text.format.DateFormat.getMediumDateFormat(context);
    timeFormat = android.text.format.DateFormat.getTimeFormat(context);
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
  public int getItemCount() {
    return appointments.size();
  }

    class Holder extends ViewHolder {

      private final TextView barber;
      private final TextView client;
      private final TextView service;
      private final TextView date;
      private final TextView duration;
      private final TextView status;
      private final View clickView;

      public Holder(@NonNull View itemView) {
        super(itemView);
        clickView = itemView.findViewById(R.id.click_view);
        barber = itemView.findViewById(R.id.barber);
        client = itemView.findViewById(R.id.client);
        service = itemView.findViewById(R.id.service);
        date = itemView.findViewById(R.id.date);
        duration = itemView.findViewById(R.id.duration);
        status = itemView.findViewById(R.id.status);
      }

      private void bind(int position, AppointmentWithDetails appointment) {
        barber.setText(appointment.getBarber().getName());
        client.setText(appointment.getClient());
        service.setText(appointment.getService().getName());
        date.setText(context.getString(R.string.date_time_format,
            dateFormat.format(appointment.getDate()), timeFormat.format(appointment.getDate())));
        duration.setText(String.valueOf(appointment.getDuration()));
        status.setText(appointment.getStatus().toString());
        clickView.setOnClickListener((v) -> listener.onAppointmentClick(getAdapterPosition(), appointment));
      }
    }

    @FunctionalInterface
    public interface OnAppointmentClickListener {
      void onAppointmentClick(int position, Appointment appointment);

  }
}
