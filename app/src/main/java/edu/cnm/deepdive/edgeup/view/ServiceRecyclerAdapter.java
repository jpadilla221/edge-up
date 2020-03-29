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
      List<Service> services,
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
    private final TextView description;
    private final TextView duration;
    private final View clickView;

    public Holder(@NonNull View itemView) {
      super(itemView);
      clickView = itemView.findViewById(R.id.click_view);
      name = itemView.findViewById(R.id.name);
      description = itemView.findViewById(R.id.description);
      duration = itemView.findViewById(R.id.duration);
    }

    private void bind(int position, Service service) {
      name.setText(service.getName());
      description.setText(service.getDescription());
      duration.setText(String.valueOf(service.getDuration()));
      clickView.setOnClickListener((v) -> listener.onServiceClick(getAdapterPosition(), service));
    }
  }

  @FunctionalInterface
  public interface OnServiceClickListener {
    void onServiceClick(int position, Service service);
  }
}
