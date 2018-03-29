package carros.com.br.crecheepreescola.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import carros.com.br.crecheepreescola.R;
import carros.com.br.crecheepreescola.activity.Aluno_Com_Prog_Activity;
import carros.com.br.crecheepreescola.dominio.Turma;



public class ListaTurmaAdapter extends RecyclerView.Adapter<ListaTurmaAdapter.ListaTurmaViewHolder>
        implements View.OnClickListener, View.OnLongClickListener {


    private List<Turma> turmaListItens;
    private Context context;
    private AdapterView.OnItemClickListener onItemClickListener;

    public ListaTurmaAdapter(List<Turma> turmaListItens, Context context) {
        this.turmaListItens = turmaListItens;
        this.context = context;
    }

    public ListaTurmaAdapter(Context context, List<Turma> _turmaListItens) {
        turmaListItens = _turmaListItens;
        this.context = context;
    }

    @Override
    public ListaTurmaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_turma, parent, false);
        final ListaTurmaViewHolder listaTurmaViewHolder = new ListaTurmaViewHolder(view);

        return listaTurmaViewHolder;
    }

    @Override
    public void onBindViewHolder(ListaTurmaViewHolder holder, final int position) {

        final Turma turma = turmaListItens.get(position);


        CardView itemCardViewListaTurma = holder.cardViewListaTurma;
        ImageView itemImagemViewListItemTurma = holder.imagemViewListItemTurma;
        TextView itemTextViewListItemTurma;

        itemTextViewListItemTurma = holder.textViewListItemTurma;

        itemTextViewListItemTurma.setText(turma.getNome());

        holder.list_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "ID: " + turma.getId() + "  Nome: " + turma.getNome(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(view.getContext(), Aluno_Com_Prog_Activity.class);
                intent.putExtra("turmaSelecionada", turma);
                view.getContext().startActivity(intent);

            }
        });

    }




    @Override
    public int getItemCount() {
        //Precisamos do objeto modelo para passar esse layer

        return turmaListItens.size();
    }

    @Override
    public void onClick(View view) {



    }

    @Override
    public boolean onLongClick(View view) {
        return false;
    }

    public static class ListaTurmaViewHolder extends RecyclerView.ViewHolder {

        LinearLayout list_item;
        CardView cardViewListaTurma;
        ImageView imagemViewListItemTurma;
        TextView textViewListItemTurma;

        public ListaTurmaViewHolder(View view) {
            super(view);

            list_item = (LinearLayout) view.findViewById(R.id.list_item);
            cardViewListaTurma = view.findViewById(R.id.listViewTurmas);
            imagemViewListItemTurma = view.findViewById(R.id.imagemViewListItemTurma);
            textViewListItemTurma = view.findViewById(R.id.textViewListItemTurma);


        }

    }

}
