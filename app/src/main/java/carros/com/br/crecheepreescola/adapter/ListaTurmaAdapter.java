package carros.com.br.crecheepreescola.adapter;

import android.content.Context;
import android.support.annotation.BinderThread;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindInt;
import butterknife.BindView;

import butterknife.BindViews;
import butterknife.ButterKnife;
import carros.com.br.crecheepreescola.R;
import carros.com.br.crecheepreescola.dominio.Turma;


public class ListaTurmaAdapter extends RecyclerView.Adapter<ListaTurmaAdapter.ListaTurmaViewHolder>{


    private List<Turma> turmaListItens;

    public ListaTurmaAdapter(Context context,List<Turma> _turmaListItens){
        turmaListItens = _turmaListItens;
    }

    @Override
    public ListaTurmaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_turma, parent, false);
        ListaTurmaViewHolder listaTurmaViewHolder = new ListaTurmaViewHolder(view);
        return listaTurmaViewHolder;
    }

    @Override
    public void onBindViewHolder(ListaTurmaViewHolder holder, int position) {

        //holder.textViewListItemTurma.setText((CharSequence) turmaListItens.get(position).);

        Turma turma = turmaListItens.get(position);

        CardView itemCardViewListaTurma = holder.cardViewListaTurma;
        ImageView itemImagemViewListItemTurma = holder.imagemViewListItemTurma;
        TextView itemTextViewListItemTurma;

        itemTextViewListItemTurma = holder.textViewListItemTurma;

        itemTextViewListItemTurma.setText(turma.getNome());

    }

    @Override
    public int getItemCount() {
        //Precisamos do objeto modelo para passar esse layer

        return turmaListItens.size();
    }

    public static class ListaTurmaViewHolder extends RecyclerView.ViewHolder{

        CardView cardViewListaTurma;
        ImageView imagemViewListItemTurma;
        TextView textViewListItemTurma;

        public ListaTurmaViewHolder(View view){
            super(view);

            cardViewListaTurma = view.findViewById(R.id.listViewTurmas);
            imagemViewListItemTurma = view.findViewById(R.id.imagemViewListItemTurma);
            textViewListItemTurma = view.findViewById(R.id.textViewListItemTurma);




        }



    }

}
