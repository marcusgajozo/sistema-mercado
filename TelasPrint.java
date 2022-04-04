import java.util.*;

public class TelasPrint {
    //construtor da calsse
    TelasPrint(){}

    //tela de inicio
    public void Principal(){
        System.out.println("-----------------------------------");
        System.out.println("-----------------------------------");
        System.out.println("ESCOLHA SUA OPCAO DIGITANDO O NUMERO");
        System.out.println("1. Cadastrar Funcionario");
        System.out.println("2. Cadastrar Cliente");
        System.out.println("3. Cadastrar Produto");
        System.out.println("4. Cadastrar Compra");
        System.out.println("5. Listar Funcionarios");
        System.out.println("6. Listar Clientes");
        System.out.println("7. Listar Produto");
        System.out.println("8. Listar Compras");
        System.out.println("0. SAIR");
        System.out.print("DIGITE SUA OPCAO: ");
    }
    
    //tela de erro
    public void Erro(){
        System.out.println("-----------------------------------");
        System.out.println("!!OPCAO NAO ENCONTRADA!!");
        System.out.print("DIGITE NOVAMENTE SUA OPCAO: ");
    }

    //tela de cadastro de funcionario
    public Funcionario Fcadastro(int id){
        Scanner scan = new Scanner(System.in);
        boolean check;
        String nome;
        String cpf;
        String end;
        String cel;
        String funcao;
        double salario;
        System.out.println("-----------------------------------");
        System.out.println("-----------------------------------");
        System.out.println("CADASTRANDO FUNCIONARIO");
        System.out.print("NOME: "); nome = scan.nextLine();

        System.out.print("CPF(soh numero): "); 
        do {
            cpf = scan.next();
            if(cpf.length() != 11){
                System.out.println("CPF INVALIDO!");
                System.out.print("CPF(soh numero): "); 
            }
        } while (cpf.length() != 11);
        

        scan.nextLine();
        System.out.print("ENDERECO: "); end = scan.nextLine();
        System.out.print("NUMERO DE CELULAR(com ddd): ");

        do {
            cel = scan.next();
            if(cel.length() != 11){
                System.out.println("NUMERO DE CELULAR INVALIDO!");
                System.out.println("EXEMPLO: 67999999999");
                System.out.print("NUMERO DE CELULAR(soh numero): "); 
            }
        } while (cel.length() != 11);

        scan.nextLine();
        System.out.print("FUNCAO: "); funcao = scan.next();
        scan.nextLine();
        System.out.print("SALARIO: "); 
        
        //tratatar exceção: Caso digitem palavras ou letras ou opção invalida
        do { 
            try 
            { 
              salario = scan.nextDouble();
              check = true;
              if(salario < 0){
                System.out.println("!SALARIO INVALIDO!");
                System.out.print("SALARIO: "); 
                check = false;
              }
            } 
            catch (Exception e) 
            {
                System.out.println("!SALARIO INVALIDO!");
                System.out.print("SALARIO: ");
                scan.nextLine();
                salario = 0;
                check = false;
            }
          } while (!check);
  
        scan.nextLine();
        Funcionario funcionario = new Funcionario(id, nome, cpf, end, cel, funcao, salario);
        return funcionario;
    }

    //tela de cadastro de cliente
    public Cliente Ccadastro(int id){
        Scanner scan = new Scanner(System.in);
        String nome;
        String cpf;
        String end;
        String cel;
        System.out.println("-----------------------------------");
        System.out.println("-----------------------------------");
        System.out.println("CADASTRANDO CLIENTE");
        System.out.print("NOME: "); nome = scan.nextLine();
        System.out.print("CPF(soh numero): "); 

        do {
            cpf = scan.next();
            if(cpf.length() != 11){
                System.out.println("CPF INVALIDO!");
                System.out.print("CPF(soh numero): "); 
            }
        } while (cpf.length() != 11);

        scan.nextLine();
        System.out.print("ENDERECO: "); end = scan.nextLine();
        System.out.print("NUMERO DE CELULAR(soh numero): "); 

        do {
            cel = scan.next();
            if(cel.length() != 11){
                System.out.println("NUMERO DE CELULAR INVALIDO!");
                System.out.println("EXEMPLO: 67999999999");
                System.out.print("NUMERO DE CELULAR(soh numero): "); 
            }
        } while (cel.length() != 11);

        scan.nextLine();
        Cliente cliente = new Cliente(id, nome, cpf, end, cel);
        return cliente;
    }

    //tela de cadastro de cliente
    public Produto Pcadastro(int id){
        Scanner scan = new Scanner(System.in);
        boolean check;
        String nome;
        double preco;
        System.out.println("-----------------------------------");
        System.out.println("-----------------------------------");
        System.out.println("CADASTRANDO PRODUTO");
        System.out.print("Nome: "); nome = scan.nextLine();
        System.out.print("Valor: "); 
        
        //tratatar exceção: Caso digitem palavras ou letras ou opção invalida
        do { 
            try 
            { 
              preco = scan.nextDouble();
              check = true;
              if(preco < 0){
                System.out.println("!VALOR INVALIDO!");
                System.out.print("VALOR: "); 
                check = false;
              }
            } 
            catch (Exception e) 
            {
                System.out.println("!VALOR INVALIDO!");
                System.out.print("VALOR: ");
                scan.nextLine();
                preco = 0;
                check = false;
            }
        } while (!check);

        scan.nextLine();
        Produto produto = new Produto(id, nome, preco);
        return produto;
    }


}