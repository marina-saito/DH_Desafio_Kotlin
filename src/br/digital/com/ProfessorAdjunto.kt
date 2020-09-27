package br.digital.com

class ProfessorAdjunto(
        nomeProfessor: String,
        sobrenomeProfessor: String,
        tempoCasa: Int,
        codigoProfessor: Int,
        var horasMonitoria: Int)
    : Professor(nomeProfessor, sobrenomeProfessor, tempoCasa, codigoProfessor) {
}