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
import edu.cnm.deepdive.edgeup.model.entity.Barber;
import edu.cnm.deepdive.edgeup.model.entity.Service;
import edu.cnm.deepdive.edgeup.view.ServiceRecyclerAdapter.Holder;
import java.util.List;

public class ServiceRecyclerAdapter extends RecyclerView.Adapter<Holder> {

  private final Context context;
  private List<Service> services;
  private final OnServiceClickListener listener;

  public ServiceRecyclerAdapter(Context context,
      List<Barber> barbers,
      OnServiceClickListener listener) {
    this.context = context;
    this.services = services;
    this.listener = listener;
  }

  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View root = LayoutInflater.from(context).inflate(R.layout.item_service, parent, false);
    return new Holder(root);
  }


  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    holder.bind(position, services.get(position));
  }

  @Override
  public int getItemCount() {
    return services.size();
  }

  class Holder extends ViewHolder {

    private final TextView name;
    private final TextView clickView;

    public Holder(@NonNull View itemView) {
      super(itemView);
      clickView = itemView.findViewById(R.id.click_view);
      name = itemView.findViewById(R.id.name);
    }

    private void bind(int position, Service service) {
      name.setText(service.getName());
      clickView.setOnClickListener((v) -> listener.onServiceClick(getAdapterPosition(), services));
    }
  }

  @FunctionalInterface
  public interface OnServiceClickListener {
    void onBarberClick(int position, Barber barber);
  }
}
