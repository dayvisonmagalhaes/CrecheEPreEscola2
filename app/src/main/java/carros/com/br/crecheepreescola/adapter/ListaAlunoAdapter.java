package carros.com.br.crecheepreescola.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

import carros.com.br.crecheepreescola.activity.Diario_Comun_Calendario_Msg_Activity;
import carros.com.br.crecheepreescola.activity.Diario_Msg_Activity;
import carros.com.br.crecheepreescola.dominio.Aluno;

public class ListaAlunoAdapter extends RecyclerView.Adapter<ListaAlunoAdapter.ListaAlunoViewHolder>
         {
    private List<Aluno> alunoListItens;
    private Context context;
    private AdapterView.OnItemClickListener onItemClickListener;
    private int idResponsavel = 0;

    public ListaAlunoAdapter(Context context, List<Aluno> alunoListItens) {
        this.alunoListItens = alunoListItens;
        this.context = context;
    }

    public ListaAlunoAdapter(Context context, List<Aluno> _alunoListItens, int idResponsavel) {
        alunoListItens = _alunoListItens;
        this.context = context;
        this.idResponsavel = idResponsavel;
    }

    @Override
    public ListaAlunoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_aluno, parent, false);
        final ListaAlunoViewHolder listaAlunoViewHolder = new ListaAlunoViewHolder(view);

        return listaAlunoViewHolder;
    }

    @Override
    public void onBindViewHolder(ListaAlunoViewHolder holder, final int position) {

        final Aluno aluno = alunoListItens.get(position);
        CardView itemCardViewListaAluno = holder.cardViewListaAluno;
        ImageView itemImagemViewListItemAluno = holder.imagemViewListItemAluno;
        TextView itemTextViewListItemAluno;
        itemTextViewListItemAluno = holder.textViewListItemAluno;
        itemTextViewListItemAluno.setText(aluno.getNome());

        holder.list_item_aluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "ID: " + aluno.getId() + "  Nome: " + aluno.getNome(), Toast.LENGTH_SHORT).show();
                Log.i("Alunos_Adapter" , "aluno: " + "ID: " + aluno.getId() + "  Nome: " + aluno.getNome()  );
                if (idResponsavel != 0){
                    Intent intent = new Intent(view.getContext(), Diario_Comun_Calendario_Msg_Activity.class);//Activity do responsável
                    intent.putExtra("alunoSelecionado", aluno);
                    view.getContext().startActivity(intent);
                }else {
                    Intent intent = new Intent(view.getContext(), Diario_Msg_Activity.class);//Activity do Professor
                    intent.putExtra("alunoSelecionado", aluno);
                    view.getContext().startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        //Precisamos do objeto modelo para passar esse layer
        return alunoListItens.size();
    }

//    @Override
//    public void onClick(View view) {
//
//
//
//    }
//
//    @Override
//    public boolean onLongClick(View view) {
//        return false;
//    }

    public static class ListaAlunoViewHolder extends RecyclerView.ViewHolder {
        LinearLayout list_item_aluno;
        CardView cardViewListaAluno;
        ImageView imagemViewListItemAluno;
        TextView textViewListItemAluno;

        public ListaAlunoViewHolder(View view) {
            super(view);
            list_item_aluno = (LinearLayout) view.findViewById(R.id.list_item_aluno);
            cardViewListaAluno = view.findViewById(R.id.listViewAlunos);
            imagemViewListItemAluno = view.findViewById(R.id.imagemViewListItemAluno);
            textViewListItemAluno = view.findViewById(R.id.textViewListItemAluno);
        }
    }
}
