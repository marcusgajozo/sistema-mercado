import java.util.*;

public class Empresa {
    private List<Caixa> caixa = new ArrayList<>();
    private List<Pessoa> pessoas = new ArrayList<>();
    private List<Produto> produtos = new ArrayList<>();
    private  int id_cliente = 1;
    private int id_funcionario = 1;
    private int id_caixa = 0;
    private int id_produto = 1;
    
    TelasPrint tela = new TelasPrint();

    //construtor da classe
    public Empresa(){
    }
    
    //cadastra clientes
    public void CCadastra(){
        pessoas.add(tela.Ccadastro(id_cliente));
        id_cliente++;
    }

    //cadastra funcionarios
    public void FCadastra(){
        pessoas.add(tela.Fcadastro(id_funcionario));
        id_funcionario++;
    }

    //cadastra produtos
    public void PCadastra(){
        produtos.add(tela.Pcadastro(id_produto));
        id_produto++;
    }

    //cadastra compras
    public void CompCadastrar(){
        System.out.println("-----------------------------------");
        System.out.println("-----------------------------------");
        System.out.println("CADASTRANDO COMPRA");
        Scanner scan = new Scanner(System.in);
        Funcionario funcionario = null;
        Cliente cliente = null;
        int id;
        boolean check;

        //confere se existe funcionarios
        while(funcionario == null && id_funcionario != 1) {
            ListFuncionarios();
            System.out.println("-----------------------------------");
            System.out.print("DIGITE O ID DO FUNCIONARIO: ");

            do { //tratatar exceção: Caso digitem palavras ou letras ou opção invalida
                try 
                { 
                  id = scan.nextInt();
                  check = true;
                  if(id > id_funcionario || id < 0){
                    tela.Erro();
                    check = false;
                  }
                } 
                catch (Exception e) 
                {
                  tela.Erro();
                  scan.nextLine();
                  id = 0;
                  check = false;
                }
              } while (!check);
            
            for (int i = 0; i < pessoas.size(); i++){
                if (pessoas.get(i) instanceof Funcionario){
                    if (pessoas.get(i).getId() == id){
                        funcionario = (Funcionario) pessoas.get(i);
                    }
                }
            }
            scan.nextLine();
        } 

        //confere se existe clientes
        while (cliente == null && id_cliente != 1){
            ListClientes();
            System.out.println("-----------------------------------");
            System.out.print("DIGITE O ID DO CLIENTE: ");
            
            //tratatar exceção: Caso digitem palavras ou letras ou opção invalida
            do { 
                try 
                {
                  id = scan.nextInt();
                  check = true;
                  if(id > id_cliente || id < 0){
                    tela.Erro();
                    check = false;
                  }
                } 
                catch (Exception e) 
                {
                  tela.Erro();
                  scan.nextLine();
                  id = 0;
                  check = false;
                }
              } while (!check);

            for (int i = 0; i < pessoas.size(); i++){
                if (pessoas.get(i) instanceof Cliente){
                    if (pessoas.get(i).getId() == id){
                        cliente = (Cliente) pessoas.get(i);
                    }
                }
            }
            scan.nextLine();
        } 

        //só cadastra compra se existir funcionario, cliente e produto.
        if (cliente != null && funcionario!= null && id_produto != 1) {        
            caixa.add(new Caixa(id_caixa, funcionario, cliente));

            int select;

            while(true){
                ListProduto();
                System.out.println("ADICIONE NO CARRINHO");
                System.out.print("DIGITE O ID DO PRODUTO OU 0 PARA FINALIZAR: ");
                
                //tratatar exceção: Caso digitem palavras ou letras ou opção invalida
                do { 
                    try 
                    { 
                    select = scan.nextInt();
                    check = true;
                    if(select > id_produto || select < 0){
                        tela.Erro();
                        check = false;
                    }
                    } 
                    catch (Exception e) 
                    {
                    tela.Erro();
                    scan.nextLine();
                    select = 0;
                    check = false;
                    }
                } while (!check);
                
                if(select == 0){
                    break;
                }


                for(int i = 0; i < produtos.size(); i++){
                    if (select == produtos.get(i).getId()){
                        caixa.get(id_caixa).add_produto(produtos.get(i));
                    }
                }

                System.out.println("-----------------------------------");
                System.out.println("!ADICIONADO COM SUCESSO!");
            }
            id_caixa++;
        }
        else{
            System.out.println("Sem cliente, funcionario ou produto é impossivel cadastrar compra!");
        }
    }

    //lista todos os funconarios cadastrados
    public void ListFuncionarios(){
        System.out.println("-----------------------------------");
        System.out.println("-----------------------------------");
        System.out.println("LISTA DE FUNCIONARIOS");
        int aux = 0; 
        for(int i = 0; i < pessoas.size(); i++){
            if(pessoas.get(i) instanceof Funcionario){ //confere se pessoa é do tipo funcionario
                System.out.println(pessoas.get(i).toString());
                aux++;
            }
        }
        if(aux == 0){
            System.out.println("Nenhum funcionario cadastrado...");
        }
    }

    //lista todos os clientes cadastrados
    public void ListClientes(){
        System.out.println("-----------------------------------");
        System.out.println("-----------------------------------");
        System.out.println("LISTA DE CLIENTES");
        int aux = 0;
        for(int i = 0; i < pessoas.size(); i++){
            if(pessoas.get(i) instanceof Cliente){ //confere se pessoa é do tipo cliente
                System.out.println(pessoas.get(i).toString());
                aux++;
            }
        }
        if(aux == 0){
            System.out.println("Nenhum cliente cadastrado...");
        }
    }

    //lista todos os produtor cadastrados
    public void ListProduto(){
        System.out.println("-----------------------------------");
        System.out.println("-----------------------------------");
        System.out.println("LISTA DE PRODUTOS");
        int aux = 0;
        for(int i = 0; i < produtos.size(); i++){
            System.out.println(produtos.get(i).toString());
            aux++;
        }
        if(aux == 0){
            System.out.println("Nenhum produto cadastrado...");
        }
    }

    //lista todas as compras cadastradas
    public void ListCompra(){
        System.out.println("-----------------------------------");
        System.out.println("-----------------------------------");
        System.out.println("LISTA DE CAIXAS");
        int aux = 0;
        for(int i = 0; i < caixa.size(); i++){
            System.out.printf("Caixa id: %d\n", caixa.get(i).getId());
            System.out.println("Nome Funcionario: "+caixa.get(i).FNome());
            System.out.println("Nome Cliente: "+caixa.get(i).CNome());
            System.out.println("-------PRODUTOS COMPRADOS------------");
            caixa.get(i).ListProdutos();
            System.out.println("Valor Total: "+caixa.get(i).ValorTotal());
            System.out.println("-----------------------------------");
            System.out.println("-----------------------------------");
            aux++;
        }
        if(aux == 0){
            System.out.println("Nenhuma compra foi cadastrada...");
        }
    }
}
