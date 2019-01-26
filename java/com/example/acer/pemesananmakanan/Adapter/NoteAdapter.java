package com.example.acer.pemesananmakanan.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.acer.pemesananmakanan.CustomOnItemClickListener;
import com.example.acer.pemesananmakanan.FormAddUpdateActivity;
import com.example.acer.pemesananmakanan.R;
import com.example.acer.pemesananmakanan.entity.Note;

import java.util.LinkedList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewholder>{
    private LinkedList<Note> listNotes;
    private Activity activity;

    public NoteAdapter(Activity activity) {
        this.activity = activity;
    }

    public LinkedList<Note> getListNotes() {
        return listNotes;
    }

    public void setListNotes(LinkedList<Note> listNotes) {
        this.listNotes = listNotes;
    }

    @Override
    public NoteViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new NoteViewholder(view);
    }

    @Override
    public void onBindViewHolder(NoteViewholder holder, int position) {
        holder.tvTelepon.setText(getListNotes().get(position).getTelepon());
        holder.tvNama.setText(getListNotes().get(position).getNama());
        holder.tvTanggal.setText(getListNotes().get(position).getTanggal());
        holder.tvAlamat.setText(getListNotes().get(position).getAlamat());
        holder.tvPembelian.setText(getListNotes().get(position).getPembelian());
        holder.tvJumlah.setText(getListNotes().get(position).getJumlah());
        holder.cvNote.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Intent intent = new Intent(activity, FormAddUpdateActivity.class);
                intent.putExtra(FormAddUpdateActivity.EXTRA_POSITION, position);
                intent.putExtra(FormAddUpdateActivity.EXTRA_NOTE, getListNotes().get(position));
                activity.startActivityForResult(intent, FormAddUpdateActivity.REQUEST_UPDATE);
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListNotes().size();
    }

    public class NoteViewholder extends RecyclerView.ViewHolder{
        TextView tvTelepon, tvNama, tvAlamat, tvPembelian, tvJumlah, tvTanggal;
        CardView cvNote;

        public NoteViewholder(View itemView) {
            super(itemView);
            tvTelepon = (TextView)itemView.findViewById(R.id.tv_item_telepon);
            tvNama = (TextView)itemView.findViewById(R.id.tv_item_nama);
            tvAlamat = (TextView)itemView.findViewById(R.id.tv_item_alamat);
            tvPembelian = (TextView)itemView.findViewById(R.id.tv_item_pembelian);
            tvJumlah = (TextView)itemView.findViewById(R.id.tv_item_jumlah);
            tvTanggal = (TextView)itemView.findViewById(R.id.tv_item_tanggal);
            cvNote = (CardView)itemView.findViewById(R.id.cv_item_note);
        }
    }
}
