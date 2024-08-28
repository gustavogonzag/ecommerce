package br.com.truedev.ecommerce.service.produto;

import br.com.truedev.ecommerce.model.Categoria;
import br.com.truedev.ecommerce.model.Produto;

import java.util.List;

public interface IProdutoService {

    public Produto cadastrarNovo(Produto novo);
    public Produto alterarProduto(Produto produto);
    public List<Produto> recuperarTodos();
    public List<Produto> recuperarPorPalavraChave(String palavraChave);
    public Produto buscarPeloId(Integer id);
    public List<Produto> buscarPorCategoria(Categoria categoria);
}
