package edu.cnm.deepdive.edgeup.controller.ui.barber;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.edgeup.R;


public class BarberFragment extends Fragment {

  private HomeViewModel homeViewModel;
  private RecyclerView barberList;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    homeViewModel =
        ViewModelProviders.of(this).get(HomeViewModel.class);
    View root = inflater.inflate(R.layout.fragment_barber, container, false);
    barberList = root.findViewById(R.id.barber_list);
    root.findViewById(R.id.add_barber).setOnClickListener((v) -> editBarber(0));
    return root;
  }

  private void editBarber(long id) {
    //TODO Display get barber edit dialog barber fragment.
  }
}