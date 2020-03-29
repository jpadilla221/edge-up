package edu.cnm.deepdive.edgeup.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.edgeup.R;
import edu.cnm.deepdive.edgeup.controller.ui.barber.HomeViewModel;
import edu.cnm.deepdive.edgeup.model.entity.Barber;
import edu.cnm.deepdive.edgeup.view.BarberRecyclerAdapter;
import edu.cnm.deepdive.edgeup.viewmodel.MainViewModel;


public class BarberFragment extends Fragment {

  private MainViewModel viewModel;
  private RecyclerView barberList;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_barber, container, false);
    barberList = root.findViewById(R.id.barber_list);
    root.findViewById(R.id.add_barber).setOnClickListener((v) -> editBarber(0));
    return root;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
    viewModel.getBarbers().observe(getViewLifecycleOwner(), (barbers) -> {
      BarberRecyclerAdapter adapter = new BarberRecyclerAdapter(
          getContext(), barbers, (pos, barber) -> editBarber(barber.getId()));
      barberList.setAdapter(adapter);
    });
  }

  private void editBarber(long id) {
    BarberEditFragment fragment = BarberEditFragment.newInstance(id);
    fragment.show(getChildFragmentManager(), fragment.getClass().getName());
  }
}