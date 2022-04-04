
import java.util.*;

class Funcao{}

class Main {
  public static void main(String[] args) {
    Empresa empresa = new Empresa();
    TelasPrint tela = new TelasPrint();
    Scanner scan = new Scanner(System.in);

    //tela de inicio
    //o laço encerra quando o usuario digitar zero(0)
    while(true)
    {
        tela.Principal();

        int select;
        boolean check;

        //tratatar exceção: Caso digitem palavras ou letras.
        do {
          try 
          { 
            select = scan.nextInt();
            check = true;
            if(select > 8 || select < 0){
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


        if (select == 1){ 
          empresa.FCadastra();
        } else if (select == 2){
          empresa.CCadastra();
        } else if (select == 3){
          empresa.PCadastra();
        } else if (select == 4){
          empresa.CompCadastrar();
        } else if (select == 5){
          empresa.ListFuncionarios();
        } else if (select == 6){
          empresa.ListClientes();
        } else if (select == 7){
          empresa.ListProduto();
        } else if (select == 8){
          empresa.ListCompra();
        }else if (select == 0){
            System.out.println("PROGRAMA FINALIZADO COM SUCESSO!");
            break;
        }
    }
  }
}