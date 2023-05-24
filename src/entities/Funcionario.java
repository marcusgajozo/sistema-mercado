package entities;

public class Funcionario extends Pessoa{
  private double salario;
  private String funcao;
  int id;

  //construtor da classe;
  public Funcionario(int id, String nome, String cpf, String end, String cel, String funcao, double salario) {
    super(nome, cpf, end, cel);
    this.funcao = funcao;
    this.salario = salario;
    this.id = id;
  }

  //retorna informação do funcionario
  public String toString() {
    return "Id: "+id+", Nome: "+super.getNome()+", Funcao: "+funcao+", Salario: "+salario;
  }

  public int getId() {
    return id;
  }
}