public class Cliente extends Pessoa{ //extende de pessoa
  int id;
  
  //construtor
  Cliente(int id, String nome, String cpf, String end, String cel) {
    super(nome, cpf, end, cel);
    this.id = id;
  }
  
  //retorna informações de cliente
  public String toString() {
    return "Id: "+id+", Nome: "+super.getNome()+", Numero: "+super.getCel();
  }

  //retorna o id do cliente
  public int getId() {
    return id;
  }

  
}