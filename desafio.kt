open class Pessoa(
    val nome: String
)

class Aluno(
    nome: String, 
    val idade: String
) : Pessoa (nome)

class Educador(nome: String, 
    val cargo: String
) : Pessoa (nome)

fun main() {

    val listaPessoas = mutableListOf<Pessoa>()

    /*Esta função imprime duas mensagens de boas vindas na tela, usando o método uppercase() da classe String para converter as strings em maiúsculo.
   A função não retorna nenhum valor. */
    fun boasVindas(mensagem: String): Unit {
        println("\tBem vindo ao sistema de cadastro da $mensagem\n".uppercase())
        println("Escolha o tipo de cadastro:\n".uppercase())
    } // Fim da Função
    
            //Nome da Função   -    Nome do parametro
    fun mostrarPessoasCadastradas(listaPessoas: List<Pessoa>) { //Lista de objetos do tipo Pessoa
        println("------ Pessoas cadastradas -------")    
        for (pessoaCadastrada in listaPessoas) { //Recebe da val listaPessoas 

            val tipo: String

                tipo = when { //Tipo vai retornar Aluno ou Educador para printar 
                        pessoaCadastrada is Aluno -> "Aluno"
                        pessoaCadastrada is Educador -> "Educador"
                    else -> "Desconhecido"
                }            

            println("${pessoaCadastrada.nome} está cadastrado como $tipo\n")
        } // Fim do for
    } // Fim da Função

    boasVindas("DIO") //Chamada de Função de boas vindas

    var menu = true

    while (menu) { //Se digitar 2 sai do loop ele se torna false
        println("Menu da DIO:")
        println("Digite 1 para - Cadastrar")
        println("Digite 2 para sair - Sair")
        print("Escolha uma opção: ")

        val escolha = readLine()

                when (escolha) {
                    "1" -> {
                        println("\n--- --- --- --- --- ---\n")
                        println("Escolha o tipo de cadastro:")
                        println("1 - Aluno")
                        println("2 - Educador")
                        print("Opção: ")

                                    val tipoCadastro = readLine() //Entrada de dados pelo teclado

                                            when (tipoCadastro) {
                                                "1" -> {
                                                    println("\n--- --- --- --- --- ---\n") // Separador
                                                    println("Digite o primeiro nome da pessoa: ")
                                                    val nome = readLine() ?: "" //Armazena o dado na variável

                                                    println("Digite a idade do aluno: ")
                                                    val idade = readLine() ?: ""  //Armazena o dado na variável

                                                    listaPessoas.add(Aluno(nome, idade)) //Adiciando os dados das variáveis para a classe Aluno

                                                    println("\n--- --- --- --- --- ---\n") // Separador
                                                    println("Ebaa! $nome agora está cadastrado como Aluno")
                                                    println("Cadastro finalizado com sucesso bem vindo a DIO\n")
                                                }
                                                
                                                "2" -> {
                                                    println("\n--- --- --- --- --- ---\n") // Separador
                                                    println("Digite o nome da pessoa: ")
                                                    val nome = readLine() ?: "" //Armazena o dado na variável

                                                    println("Digite o cargo do educador: (Ex: Professor, TI, Design) ")
                                                    val cargo = readLine() ?: "" //Armazena o dado na variável

                                                    listaPessoas.add(Educador(nome, cargo)) //Adiciando os dados das variáveis para a classe Educador

                                                    println("\n--- --- --- --- --- ---\n") // Separador
                                                    println("Ebaa! $nome agora está cadastrado como Educador")
                                                    println("Cadastro finalizado com sucesso bem vindo a DIO\n")
                                                }
                                                else -> {
                                                    println("Opção inválida. Tente novamente.")
                                                    continue // Retorna o loop novamente
                                                }
                                            } //Fim da condição When

                                            mostrarPessoasCadastradas(listaPessoas) //Chamar a função de mostrar a pessoa cadastrada
                    } //Fim When -> 1

                    "2" -> {
                    menu = false //Se o usuário digitar o 2 o When menu será false logo o loop encerrará 
                    println("\n--- --- --- --- --- --- --\n") // Separador 
                    println("Saindo do sistema. Adeus!")
                    } //Fim When -> 2

            else -> { //Se o usuário digitar outra coisa irá exibir a mensagem de tente novamente
            println("\n--- --- --- --- --- --\n") // Separador 
            println("Opção inválida. Tente novamente.")
            continue // Retorna o loop novamente
            } //Fim When else
        } //Fim da condição escolha
    } // Fim Loop menu 

    println("\n--- --- --- --- --- --- --\n")
    println("\nPressione Enter para sair...")
    readLine() //Recebe ação do teclado para fechar o programa 
}

// Marcel "Maçã ❤️" Florentino  - 07:59 21/09/2023
// https://github.com/applephoria