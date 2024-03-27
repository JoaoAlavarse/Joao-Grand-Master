fun main() {
    val rna = "AUGUUUUCU"
    val protein = translateRNA(rna)
    println("RNA: $rna => Proteína: $protein")
}


    fun translateRNA(rna: String): List<String> {
        val codonMap = mapOf(
            "AUG" to "Metionina",
            "UUU" to "Fenilalanina",
            "UUC" to "Fenilalanina",
            "UUA" to "Leucina",
            "UUG" to "Leucina",
            "UCU" to "Serina",
            "UCC" to "Serina",
            "UCA" to "Serina",
            "UCG" to "Serina",
            "UAU" to "Tirosina",
            "UAC" to "Tirosina",
            "UGU" to "Cisteína",
            "UGC" to "Cisteína",
            "UGG" to "Triptofano"
        )

        val stopCodons = setOf("UAA", "UAG", "UGA")

        val proteinSequence = mutableListOf<String>()
        var i = 0

        while (i < rna.length - 2) {
            val codon = rna.substring(i, i + 3)

            // Verifica se é um códon de parada
            if (stopCodons.contains(codon)) {
                break
            }

            // Verifica se o códon é válido
            if (codonMap.containsKey(codon)) {
                val aminoAcid = codonMap[codon]
                if (aminoAcid != null) {
                    proteinSequence.add(aminoAcid)
                }
                i += 3
            } else {
                i++
            }
        }

        return proteinSequence
    }

