package com.example.ondecomprar.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

// Se o nome do seu pacote for diferente, mude este caminho!
import com.example.ondecomprar.databinding.ProdutosBinding;
import java.util.List;
import java.util.Collections; // Para o caso de uma lista vazia

public class ProdutoListAdapter extends RecyclerView.Adapter<ProdutoListAdapter.ViewHolder> {

    // 1. Definição dos campos
    private final List<String> produtos;

    // 2. Construtor Java (agora mais limpo)
    public ProdutoListAdapter(List<String> produtos) {
        // Usa Collections.emptyList() se a lista for nula (boa prática)
        this.produtos = produtos != null ? produtos : Collections.emptyList();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // 3. Inflar o layout usando a classe ProdutosBinding
        ProdutosBinding binding = ProdutosBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );

        // 4. Retornar a nova instância, PASSANDO O OBJETO BINDING INTEIRO
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String produtoAtual = produtos.get(position);

        // 5. ACESSAR o TextView 'title' DIRETAMENTE do Binding no ViewHolder
        holder.binding.title.setText(produtoAtual);
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    // --- CLASSE INTERNA OBRIGATÓRIA (ViewHolder) ---
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public final ProdutosBinding binding; // <<< ARMAZENA O BINDING

        // 6. CONSTRUTOR RECEBE O OBJETO BINDING
        public ViewHolder(@NonNull ProdutosBinding binding) {
            super(binding.getRoot()); // Passa a View raiz para a superclasse
            this.binding = binding;
        }
    }
}