## **Trabalho de Linguagem de Programação Orientada a Objetos**

#### Aluno: Marcus Vinícius Borges Gajozo RGA: 2020.1905.062-2
#### Professor: Lucas Reis

### **Sistema de Mercado**.

O projeto é sobre um mercado, no qual aparecerá na tela uma mensagem indicando opções de escolha de 0 a 8, 0 sendo o finalizador. A primeira opção (1), é o cadastro de funcionários, onde será pedido o nome do funcionário, o CPF, endereço, celular, função e salário, o ID é gerado pelo próprio sistema. A segunda opção (2), é o cadastro de clientes, onde será pedido o nome do cliente, CPF, endereço e celular, o ID também é gerado pelo sistema. A terceira opção (3), é o cadastro de produtos no sistema, que é cadastrado o nome e o preço do produto. Na quarta opção (4), onde se cadastra a compra, é necessário pelo menos um funcionário e um cliente cadastrados, pois um funcionário precisa cadastrar a compra para o cliente. A quinta opção (5), lista todos os funcionários do mercado. Já a sexta opção (6), lista todos os clientes cadastrados. A sétima opção (7), lista dos os produtos cadastrados no sistema do mercado. E por último, a oitava opção (8), lista toda a compra e o valor total da compra. 

### **Classes**:

A **Main** inicia um laço, que recebe números de 0 a 8, caso o número seja diferente ele printa na tela uma mensagem de erro.

As classes **Cliente** e **Funcionários** são extensões da classe abstrata Pessoa, onde nome, CPF, endereço e celular são passadas pelo super(), a diferença entre Cliente e
Funcionário, é que o primeiro possui somente ID, já o segundo, possui salário, função e ID.

A classe Produto guarda o nome e o preço dos produtos cadastrados.

A classe **Caixa** adiciona produtos, adiciona os produtos e calcula a soma do valor total.

A classe **Empresa**, chama o Cadastro de clientes,funcionários, produtos, compras, lista os funcionários, os clientes, os produtos e as compras.
