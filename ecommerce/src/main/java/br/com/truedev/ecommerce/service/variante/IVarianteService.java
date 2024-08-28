package br.com.truedev.ecommerce.service.variante;

import br.com.truedev.ecommerce.model.Produto;
import br.com.truedev.ecommerce.model.Variante;

import java.util.List;

public interface IVarianteService {
    public Variante adicionarNova(Variante nova);
    public Variante alterarDados(Variante variante);
    public List<Variante> recuperarPorProduto(Produto p);
    public Variante recuperarPorId(int id);
}
