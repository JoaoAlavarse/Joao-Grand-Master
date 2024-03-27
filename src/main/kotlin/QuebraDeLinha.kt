fun main() {
    println("Insira a sua frase: ")
    var frase = readln()

    println("Insira a quantidade de colunas: ")
    var quantidade = readln().toInt()

    var caracteresNaLinha = 0
    
    var resultado = StringBuilder()

    for (palavra in frase.split(' ')) {
        if (caracteresNaLinha + palavra.length > quantidade) {
            resultado.append("\n")
            caracteresNaLinha = 0
        } else if (resultado.isNotEmpty()) {
            resultado.append(" ")
            caracteresNaLinha++
        }

        resultado.append(palavra)
        caracteresNaLinha += palavra.length
    }

    println(resultado)


}