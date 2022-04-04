public  abstract class Pessoa { //implementar nome.
    private String nome;
    private String cpf;
    private String end;
    private String cel;

    //contrutor da classe
    Pessoa(String nome, String cpf, String end, String cel){
        this.nome = nome;
        this.cpf = cpf;
        this.end = end;
        this.cel = cel;
    }

    public String getNome(){
        return this.nome;
    }

    public String getCPF(){
        return this.cpf;
    }

    public String getEnd(){
        return this.end;
    }

    public String getCel(){
        return this.cel;
    }

    //serão implementados na classe filha
    public abstract String toString();
    public abstract int getId();

}
