package br.digital.com

class ProfessorTitular(
        nomeProfessor: String,
        sobrenomeProfessor: String,
        tempoCasa: Int,
        codigoProfessor: Int,
        var especialidade: String)
    : Professor(nomeProfessor, sobrenomeProfessor, tempoCasa, codigoProfessor) {
}