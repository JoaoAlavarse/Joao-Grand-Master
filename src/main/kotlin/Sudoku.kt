fun main() {
    val sudokuBoard = arrayOf(
        intArrayOf(5, 3, 4, 6, 7, 8, 9, 1, 2),
        intArrayOf(6, 7, 2, 1, 9, 5, 3, 4, 8),
        intArrayOf(1, 9, 8, 7, 4, 2, 5, 6, 7),
        intArrayOf(8, 1, 9, 7, 6, 1, 4, 2, 3),
        intArrayOf(4, 2, 6, 8, 5, 3, 7, 9, 1),
        intArrayOf(7, 1, 3, 9, 2, 4, 8, 5, 5),
        intArrayOf(9, 6, 1, 5, 3, 7, 2, 8, 4),
        intArrayOf(2, 2, 7, 4, 1, 9, 6, 3, 5),
        intArrayOf(3, 4, 5, 2, 8, 6, 1, 7, 9)
    )

    val invalidCells = validateSudoku(sudokuBoard)
    if (invalidCells.isEmpty()) {
        println("O tabuleiro de Sudoku é válido.")
    } else {
        println("O tabuleiro de Sudoku contém valores incorretos nas seguintes células:")
        for ((row, col) in invalidCells) {
            println("(" + (row + 1) + ", " + (col + 1) + ")")
        }
    }
}

fun validateSudoku(board: Array<IntArray>): List<Pair<Int, Int>> {
    val invalidCells = mutableListOf<Pair<Int, Int>>()

    // Verificação de linhas e colunas
    for (i in board.indices) {
        for (j in board[i].indices) {
            val num = board[i][j]
            if (num != 0 && (board[i].count { it == num } > 1 || board.map { it[j] }.count { it == num } > 1)) {
                invalidCells.add(i to j)
            }
        }
    }

    // Verificação de regiões
    for (startRow in 0..<9 step 3) {
        for (startCol in 0..<9 step 3) {
            val nums = HashSet<Int>()
            for (i in startRow..<startRow + 3) {
                for (j in startCol..<startCol + 3) {
                    val num = board[i][j]
                    if (num != 0 && !nums.add(num)) {
                        invalidCells.add(i to j)
                    }
                }
            }
        }
    }

    return invalidCells
}
