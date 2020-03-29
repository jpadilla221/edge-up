package edu.cnm.deepdive.edgeup.controller;


import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.edgeup.R;
import edu.cnm.deepdive.edgeup.model.entity.Barber;
import edu.cnm.deepdive.edgeup.viewmodel.MainViewModel;

public class BarberEditFragment extends DialogFragment {

  private static final String ID_KEY = "id";

  private MainViewModel viewModel;
  private View root;
  private long id;
  private Barber barber;
  private EditText name;

  public static BarberEditFragment newInstance(long id) {
    BarberEditFragment fragment = new BarberEditFragment();
    Bundle args = new Bundle();
    args.putLong(ID_KEY, id);
    fragment.setArguments(args);
    return fragment;
  }

  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    id = getArguments().getLong(ID_KEY, 0);
    root = LayoutInflater.from(getContext()).inflate(R.layout.fragment_barber_edit, null);
    name = root.findViewById(R.id.name);
    return new AlertDialog.Builder(getContext())
        .setTitle("Edit Barber")
        .setView(root)
        .setNegativeButton(android.R.string.cancel, (dlg, which) -> {
        })
        .setPositiveButton(android.R.string.ok, (dlg, which) -> {
          barber.setName(name.getText().toString().trim());
          viewModel.save(barber);
        })
        .create();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return root;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
    if (id != 0) {
      viewModel.getBarber().observe(getViewLifecycleOwner(), (barber) -> {
        this.barber = barber;
        name.setText(barber.getName());
      });
      viewModel.setBarberId(id);
    } else {
      barber = new Barber();
    }
  }
}
