import java.util.*;

public class Caixa{
  private Funcionario funcionario;
  private Cliente cliente;
  private List<Produto> produtos = new ArrayList<>();
  private int id;

  //construtor da classe
  Caixa(int id, Funcionario funcionario, Cliente cliente){
    this.id = id;
    this.funcionario = funcionario;
    this.cliente = cliente;
  }

  public int getId() {
    return id;
  }

  //adiciona o produto na lista
  public boolean add_produto(Produto produto){
    produtos.add(produto);
    return true;
  }

  public String FNome(){
    return funcionario.getNome();
  }

  public String CNome(){
    return cliente.getNome();
  }

  //imprime o nome e preco dos itens da lista
  public void ListProdutos(){
    for(int i = 0; i < produtos.size(); i++){
      System.out.println(produtos.get(i).toString());
    }
  }

  //soma o valor da compra
  public double ValorTotal(){
    double soma = 0;
    for(int i = 0; i < produtos.size(); i++){
      soma+=produtos.get(i).getPreco();
    }
    return soma;
  }
}