package com.Jagoanrektor.tipin;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DialogForm extends DialogFragment {
    String nama,haritanggal,note,other,salary;
    DatabaseReference database= FirebaseDatabase.getInstance().getReference();

    public DialogForm() {
        this.nama = nama;
        this.haritanggal = haritanggal;
        this.note = note;
        this.other = other;
        this.salary = salary;
    }

    TextView et_nama;
    TextView et_haritanggal;
    TextView et_note;
    TextView et_other;
    TextView et_salary;
    Button btn_simpan;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.input_form,container,false);

        et_nama = view.findViewById(R.id.et_nama);
        et_haritanggal = view.findViewById(R.id.et_haritanggal);
        et_note = view.findViewById(R.id.et_note);
        et_other = view.findViewById(R.id.et_other);
        et_salary = view.findViewById(R.id.et_salary);

        et_nama.setText(nama);
        et_haritanggal.setText(haritanggal);
        et_note.setText(note);
        et_other.setText(other);
        et_salary.setText(salary);

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = et_nama.getText().toString();
                String haritanggal = et_haritanggal.getText().toString();
                String note = et_note.getText().toString();
                String other = et_other.getText().toString();
                String salary = et_salary.getText().toString();

                if (TextUtils.isEmpty(nama)) {
                    input((EditText) et_nama, "nama");
                } else if (TextUtils.isEmpty(haritanggal)) {
                    input((EditText) et_haritanggal, "Haritanggal");
                } else if (TextUtils.isEmpty(note)) {
                    input((EditText) et_note, "note");
                } else if (TextUtils.isEmpty(other)) {
                    input((EditText) et_other, "other");
                } else if (TextUtils.isEmpty(salary)) {
                    input((EditText) et_salary, "salary");
                } else {
                    database.child("Data").push().setValue(new order(nama, haritanggal, note, other, salary)).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(view.getContext(), "Data tersimpan", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(view.getContext(), "Data tersimpan", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        return view;

    }
    public void onStart() {

        super.onStart();
        Dialog dialog=getDialog();
        if (dialog!=null){
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
    }}


    private void input (EditText txt, String s){
    txt.setError(s+"Tidak boleh kosong");
    txt.requestFocus();
    }
    }