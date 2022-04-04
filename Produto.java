
public class Produto{
  private String nome;
  private double preco;
  private int id;

  //construtor da classe
  Produto(int id, String nome, double preco){
    this.id = id;
    this.nome = nome;
    this.preco = preco;
  }

  public int getId(){
    return id;
  }

  public String getNome() {
      return nome;
  }

  public double getPreco() {
      return preco;
  }


  public String toString() {
      return "Id: "+id+", Nome: "+nome+", Preco: "+preco;
  }

}